/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import exceptions.UserOpNotFoundException;
import com.vm.jcomplex.Complex;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Group3
 */
/*
La classe FXMLDocumentController mette in relazione l'interfaccia grafica con i metodi della calcolatrice
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ListView<Complex> listView;
    @FXML
    private TextField textField;
    private Calculator calc;
    private String input = "";
    private int id;
    private boolean flag = false;
    private Invoker invok = new Invoker();
    private Stage stageInst = new Stage();
    @FXML
    private AnchorPane rootPane;

    /*
    Il metodo visualFormat() imposta il numero massimo di cifre decimali visualizzabili ad 8, il carattere "."
    come separatore decimale, il carattere "'" come separatore delle migliaia e la visualizzazione dei numeri
    complessi
     */
    private void visualFormat(Complex c, StringProperty t) {
        DecimalFormatSymbols personal = new DecimalFormatSymbols();
        personal.setDecimalSeparator('.');
        personal.setGroupingSeparator('\'');
        DecimalFormat objFormat = new DecimalFormat("0.########", personal);
        objFormat.setGroupingSize(3);
        objFormat.setGroupingUsed(true);
        String real = objFormat.format(Double.parseDouble(String.valueOf(c.getReal())));
        String imaginary = objFormat.format(Double.parseDouble(String.valueOf(c.getImaginary())));
        if (imaginary.equals("0")) {
            t.setValue(real);
        } else {
            if (c.getImaginary() == 1) {
                imaginary = "";
            } else if (c.getImaginary() == -1) {
                imaginary = "-";
            }
            if (real.equals("0")) {
                t.setValue(imaginary + "i");
            } else {
                if (c.getImaginary() < 0.0) {
                    t.setValue(real + imaginary + "i");
                } else {
                    t.setValue(real + "+" + imaginary + "i");
                }
            }
        }
    }

    /*
    Il metodo visualAlert() crea una finestra informativa che segnala un evento positivo o negativo in base
    al parametro booleano passato in input e stampa come messaggio la stringa passata in input
     */
    private void visualAlert(boolean b, String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().getStylesheets().add(getClass().getResource("/styles/styleAlert.css").toExternalForm());
        if (b == false) {
            stage.getIcons().add(new Image(this.getClass().getResource("/images/cross.png").toString()));
            alert.setTitle("Error Occurred!");
        } else {
            stage.getIcons().add(new Image(this.getClass().getResource("/images/tick.png").toString()));
            alert.setTitle("Well Done!");
        }
        alert.setContentText(s);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //viene impostata la visualizzazione delle celle della listView rappresentante lo stack della calcolatrice
        listView.setCellFactory(s -> {
            ListCell<Complex> cell = new ListCell<Complex>() {
                @Override
                protected void updateItem(Complex c, boolean empty) {
                    super.updateItem(c, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        visualFormat(c, this.textProperty());
                    }
                }
            };
            cell.setAlignment(Pos.CENTER);
            return cell;
        });
        calc = new Calculator();
        ArrayList<Complex> al = new ArrayList<>();

        //gestione della pressione dei tasti della tastiera all'interno della textField
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {

                //controllo che, se verificato, permette di svuotare, digitanto qualsiasi tasto,
                //il contenuto della textField mostrato in seguito all'esecuzione di un'operazione 
                //che ne determina il riempimento. Se il tasto digitato rappresenta un carattere, quest'ultimo
                //viene mostrato a video
                if (flag == true) {

                    //modifica dello stile del contenuto della textField
                    textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: #FFFFFF; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                    String app = ke.getCharacter();
                    textField.clear();
                    textField.setText(app);
                    flag = false;
                }

                //gestione del contenuto della textField alla pressione del tasto ENTER
                if (ke.getCode().equals(KeyCode.ENTER) && !textField.getText().equals("")) {
                    input = textField.getText().trim();
                    textField.clear();

                    //"id" rappresenta l'intero associato all'operazione da eseguire
                    id = calc.recognizer(input);
                    if (id == 0) {              //controllo per inserire nello stack un numero complesso
                        calc.pushComplex(input);
                    } else if (id > 0 && id < 12) {     //controllo per eseguire un'operazione base o sullo stack
                        try {
                            calc.makeOperation(id);
                        } catch (NoSuchElementException e) {
                            textField.setText("Not Enough Elements Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            flag = true;
                            return;
                        }
                    } else if (id == 12) {      //controllo per visualizzare il contenuto di una variabile
                        try {
                            visualFormat(calc.showVar(input.charAt(input.length() - 1)), textField.textProperty());
                        } catch (NullPointerException e) {      //lanciata dalla toString() quando la variabile ha valore null
                            textField.setText("null");
                        }
                        flag = true;
                        return;
                    } else if (id > 12 && id < 17) {        //controllo per eseguire un'operazione sulle variabili
                        try {
                            calc.makeVarOperation(id, input.charAt(input.length() - 1));
                        } catch (NoSuchElementException e) {
                            textField.setText("Not Enough Elements Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            flag = true;
                            return;
                        } catch (NullPointerException e) {
                            textField.setText("Null Variable Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            flag = true;
                            return;
                        }
                    } else if (id == 18) {          //controllo per eseguire un'operazione-utente
                        try {
                            invok.execute(calc.getUserOpMap().get(input));
                            textField.setText("User-Op \"" + input + "\" Executed Successfully");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: lightgreen; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            flag = true;
                        } catch (NoSuchElementException e) {
                            textField.setText("Not Enough Elements Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            invok.rollback(calc.getUserOpMap().get(input));
                            flag = true;
                            return;
                        } catch (NullPointerException e) {
                            textField.setText("Null Variable Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            invok.rollback(calc.getUserOpMap().get(input));
                            flag = true;
                            return;
                        } catch (UserOpNotFoundException e) {
                            textField.setText("Inner User-Op No Longer Exists Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            invok.rollback(calc.getUserOpMap().get(input));
                            flag = true;
                            return;
                        }
                    } else if (id == 19) {          //controllo per cancellare un'operazione-utente
                        invok.delete(calc.getUserOpMap().get(input.split(" ")[1]));
                        textField.setText("User-Op \"" + input.split(" ")[1] + "\" Deleted");
                        textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: lightgreen; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                        flag = true;
                        return;
                    } else if (id == -1) {
                        if (calc.recUserOp(input) == -1) {      //controllo per riconoscere la definizione di un'operazione-utente
                            textField.setText("Syntax Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            flag = true;
                            return;
                        }
                        String nameOp = input.split(" ")[0];
                        String s;
                        if (calc.getUserOpMap().containsKey(nameOp)) {
                            s = "Modified";
                        } else {
                            s = "Added";
                        }

                        //inserimento o sostituzione di un'operazione-utente
                        calc.getUserOpMap().put(nameOp, new UserOpCommand(nameOp, input.substring(nameOp.length() + 1), calc));
                        textField.setText("User-Op \"" + nameOp + "\" " + s);
                        textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: lightgreen; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                        flag = true;
                        return;
                    }

                    //aggiornamento del contenuto della listView limitando la visualizzazione di essa ai primi
                    //12 elementi
                    listView.getItems().clear();
                    al.clear();
                    al.addAll(calc.getStack());
                    if (calc.getStack().size() > 12) {
                        listView.getItems().addAll(al.subList(0, 12));
                    } else {
                        listView.getItems().addAll(al.subList(0, calc.getStack().size()));
                    }
                }
            }
        });
    }

    /*
    Il metodo openInst() gestisce l'evento costituito dalla pressione della voce "Instructions" del menu
    facendo visualizzare una finestra contenente una descrizione delle operazioni eseguibili con la calcolatrice
     */
    @FXML
    private void openInst(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLInstructions.fxml"));
        if (stageInst == null || !stageInst.isShowing()) {
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/styleInstructions.css").toExternalForm());
            stageInst.getIcons().add(new Image(this.getClass().getResourceAsStream("/images/iconInstructions.png")));
            stageInst.setScene(scene);
            stageInst.setTitle("Instructions");
            stageInst.setIconified(false);
            stageInst.show();
        } else if (stageInst.isIconified()) {
            stageInst.setIconified(false);
        } else {
            stageInst.toFront();
        }
    }

    /*
    Il metodo saveDialog() gestisce l'evento costituito dalla pressione della voce "Save User-Operations" 
    del menu chiamando il metodo saveUserOps() della classe Calculator. In seguito al tentativo di salvataggio
    di un file viene mostrato un alert attraverso il metodo visualAlert() definito in precedenza
     */
    @FXML
    private void saveDialog(ActionEvent event) {
        FileChooser fileChooser1 = new FileChooser();
        fileChooser1.setTitle("Save User-Operations");
        fileChooser1.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("File", "*.bin"));
        File file = fileChooser1.showSaveDialog(rootPane.getScene().getWindow());
        if (!calc.saveUserOps(file)) {
            visualAlert(false, "Impossible to save user-operations in selected file");
            return;
        }
        visualAlert(true, "User-operations successfully saved in selected file");
    }

    /*
    Il metodo restoreDialog() gestisce l'evento costituito dalla pressione della voce "Restore User-Operations" 
    del menu chiamando il metodo restoreUserOps() della classe Calculator. In seguito al tentativo di ripristino
    di un file viene mostrato un alert attraverso il metodo visualAlert() definito in precedenza
     */
    @FXML
    private void restoreDialog(ActionEvent event) {
        FileChooser fileChooser2 = new FileChooser();
        fileChooser2.setTitle("Ricerca file lista studenti");
        fileChooser2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("File", "*.bin"));
        File file = fileChooser2.showOpenDialog(rootPane.getScene().getWindow());
        if (!calc.restoreUserOps(file)) {
            visualAlert(false, "Impossible to restore user-operations from selected file");
            return;
        }
        visualAlert(true, "User-operations from selected file successfully restored");
    }

}

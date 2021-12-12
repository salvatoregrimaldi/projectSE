/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

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

    private void visualAlert(boolean b, String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().getStylesheets().add(getClass().getResource("styleAlert.css").toExternalForm());
        if (b == false) {
            stage.getIcons().add(new Image(this.getClass().getResource("cross.png").toString()));
            alert.setTitle("Error Occurred!");
        } else {
            stage.getIcons().add(new Image(this.getClass().getResource("tick.png").toString()));
            alert.setTitle("Well Done!");
        }
        alert.setContentText(s);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (flag == true) {
                    textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: #FFFFFF; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                    String app = ke.getCharacter();
                    textField.clear();
                    textField.setText(app);
                    flag = false;
                }
                if (ke.getCode().equals(KeyCode.ENTER) && !textField.getText().equals("")) {
                    input = textField.getText();
                    textField.clear();
                    id = calc.recognizer(input);
                    if (id == 0) {
                        calc.pushComplex(input);
                    } else if (id > 0 && id < 12) {
                        try {
                            calc.makeOperation(id);
                        } catch (NoSuchElementException e) {
                            textField.setText("Not Enough Elements Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            flag = true;
                            return;
                        }
                    } else if (id == 12) {
                        input = input.trim();
                        try {
                            visualFormat(calc.showVar(input.charAt(input.length() - 1)), textField.textProperty());
                        } catch (NullPointerException e) {      //lanciata dalla toString() quando la variabile ha valore null
                            textField.setText("null");
                        }
                        flag = true;
                        return;
                    } else if (id > 12 && id < 17) {
                        input = input.trim();
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
                    } else if (id == 18) {
                        try {
                            invok.execute(calc.getUserOpMap().get(input.trim()));
                            textField.setText("User-Op \"" + input.trim() + "\" Executed Successfully");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: lightgreen; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            flag = true;
                        } catch (NoSuchElementException e) {
                            textField.setText("Not Enough Elements Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            invok.rollback(calc.getUserOpMap().get(input.trim()));
                            flag = true;
                            return;
                        } catch (NullPointerException e) {
                            textField.setText("Null Variable Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            invok.rollback(calc.getUserOpMap().get(input.trim()));
                            flag = true;
                            return;
                        } catch (UserOpNotFoundException e) {
                            textField.setText("Inner User-Op No Longer Exists Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            invok.rollback(calc.getUserOpMap().get(input.trim()));
                            flag = true;
                            return;
                        }
                    } else if (id == 19) {
                        invok.delete(calc.getUserOpMap().get(input.trim().split(" ")[1]));
                        textField.setText("User-Op \"" + input.trim().split(" ")[1] + "\" Deleted");
                        textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: lightgreen; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                        flag = true;
                        return;
                    } else if (id == -1) {
                        if (calc.recUserOp(input) == -1) {
                            textField.setText("Syntax Error");
                            textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: tomato; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                            flag = true;
                            return;
                        }
                        input = input.trim();
                        String nameOp = input.split(" ")[0];
                        String s;
                        if (calc.getUserOpMap().containsKey(nameOp)) {
                            s = "Modified";
                        } else {
                            s = "Added";
                        }
                        calc.getUserOpMap().put(nameOp, new UserOpCommand(nameOp, input.substring(nameOp.length() + 1), calc));
                        textField.setText("User-Op \"" + nameOp + "\" " + s);
                        textField.setStyle("-fx-background-radius: 10px; -fx-background-color: #333333; -fx-text-fill: lightgreen; -fx-border-color: #D1901A; -fx-border-radius: 10px; -fx-font-size: 20px; -fx-font-family: Verdana");
                        flag = true;
                        return;
                    }
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

    @FXML
    private void openInst(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLInstructions.fxml"));
        if (stageInst == null || !stageInst.isShowing()) {
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("styleInstructions.css").toExternalForm());
            stageInst.getIcons().add(new Image(this.getClass().getResourceAsStream("iconInstructions.png")));
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

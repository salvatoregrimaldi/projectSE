/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import com.vm.jcomplex.Complex;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    public static final int N_OP = 11;

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
                        DecimalFormatSymbols personal = new DecimalFormatSymbols();
                        personal.setDecimalSeparator('.');
                        personal.setGroupingSeparator('\'');
                        DecimalFormat objFormat = new DecimalFormat("0.########", personal);
                        objFormat.setGroupingSize(3);
                        objFormat.setGroupingUsed(true);
                        String real = objFormat.format(Double.parseDouble(String.valueOf(c.getReal())));
                        String imaginary = objFormat.format(Double.parseDouble(String.valueOf(c.getImaginary())));
                        if (imaginary.equals("0")) {
                            setText(real);
                        } else {
                            if (c.getImaginary() == 1) {
                                imaginary = "";
                            } else if (c.getImaginary() == -1) {
                                imaginary = "-";
                            }
                            if (real.equals("0")) {
                                setText(imaginary + "i");
                            } else {
                                if (c.getImaginary() < 0.0) {
                                    setText(real + imaginary + "i");
                                } else {
                                    setText(real + "+" + imaginary + "i");
                                }
                            }
                        }
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
                    } else if (id > 0 && id <= N_OP) {
                        try {
                            calc.makeOperation(id);
                        } catch (NoSuchElementException e) {
                            textField.setText("Not Enough Elements Error");
                            flag = true;
                            return;
                        }
                    } else if (id == -1) {
                        textField.setText("Syntax Error");
                        flag = true;
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
}

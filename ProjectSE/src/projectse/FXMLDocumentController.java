/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import com.vm.jcomplex.Complex;
import java.net.URL;
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
    public static final int N_OP = 6;

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
                        setText(c.toString());
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
                            return;
                        }
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

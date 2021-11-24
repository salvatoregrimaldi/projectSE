/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectse;

import com.vm.jcomplex.Complex;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Salvatore
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ListView<Complex> listView;
    @FXML
    private TextField textField;
    private Calculator calc;
    private String input = "";
    private int id;
    public static final int N_OP = 20;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        calc = new Calculator();
        ListProperty<Complex> listProperty = new SimpleListProperty<>();
        listView.setItems(listProperty);
        listProperty.set(FXCollections.observableArrayList());
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    input = textField.getText();
                    textField.clear();
                    id=calc.recognizer(input);
                    if(id==0){
                        calc.pushComplex(input);
                        listProperty.clear();
                        listProperty.addAll(calc.getStack());
                    }
                    else if(id>0 && id<=N_OP){
                        calc.makeOperation(id);
                    }
                }
            }
        });
    }    
    
}

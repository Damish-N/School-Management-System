/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class TeacherReqController implements Initializable {

    @FXML
    private Button btnAccept;
    @FXML
    private Button btnRej;
    @FXML
    private Button close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickAccept(ActionEvent event) {
    }

    @FXML
    private void clickReject(ActionEvent event) {
    }

    @FXML
    private void clickClose(ActionEvent event) {

        // do what you have to do
        Stage stage = (Stage) close.getScene().getWindow();
        // do what you have to do
        stage.close();
        
    }

}

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
import javafx.scene.control.TextField;
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
    @FXML
    private TextField lblUserName;
    @FXML
    private TextField lblName;
    @FXML
    private TextField lblId;

    TeacherReqModel teacherReqModel = new TeacherReqModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickAccept(ActionEvent event) {
        System.out.println("helllo");
        if (teacherReqModel.acceptReq(lblUserName.getText())) {
            System.out.println("Registerd");
            Stage stage = (Stage) close.getScene().getWindow();
            // do what you have to do
            stage.close();

        };

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

    public void setLabelText(String userName, String name, int Id) {
        lblUserName.setText(userName);
        lblName.setText(name);
        lblId.setText(String.valueOf(Id));
    }

}

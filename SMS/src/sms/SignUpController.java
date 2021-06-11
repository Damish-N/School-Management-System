/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SignUpController implements Initializable {

    @FXML
    private Button btnSignUp;
    @FXML
    private Label login;
    @FXML
    private TextField lblUserName;
    @FXML
    private TextField lblName;
    @FXML
    private TextField lblPassword;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private DatePicker datePicker;
    private String userName, password, type, bDay, name;
    SignUpModel signUpModel = new SignUpModel();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (signUpModel.isDisconected()) {
            System.out.println("Connected");
        } else {
            System.out.println("Connected");
        }

        comboBox.getItems().add("Principle");
        comboBox.getItems().add("Teacher");

    }

    @FXML
    private void clickSignUp(ActionEvent event) {
        userName = lblUserName.getText();
        name = lblName.getText();
        password = lblPassword.getText();
        type = comboBox.getSelectionModel().getSelectedItem();
        bDay = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (type.equals("Principle")) {
            if (signUpModel.isCreatedPrinciple(userName, name, password, bDay)) {
                try {
                    Parent root = null;
                    Stage stage = new Stage();
                    ((Node) event.getSource()).getScene().getWindow().hide();
                    root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                    javafx.scene.Scene scene = new javafx.scene.Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            System.out.println("Still not function");
        }

    }

    @FXML
    private void clickLogin(MouseEvent event) {
        try {
            Parent root = null;
            Stage stage = new Stage();
            ((Node) event.getSource()).getScene().getWindow().hide();
            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

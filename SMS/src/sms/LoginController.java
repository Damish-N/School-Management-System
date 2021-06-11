/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();
    @FXML
    private Button btnLogin;
    @FXML
    private Label signUp;
    @FXML
    private TextField lblUserName;
    @FXML
    private TextField lblPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (loginModel.isDisconected()) {
            System.out.println("Connected");
        } else {
            System.out.println("Connected");
        }
    }

    @FXML
    private void clickLogin(ActionEvent event) throws IOException {

        try {
            if (loginModel.isLogin(lblUserName.getText(), lblPassword.getText())) {
                Parent root = null;
                Stage stage = new Stage();
                ((Node) event.getSource()).getScene().getWindow().hide();

                if (lblUserName.getText().matches("PRI-(.*)")) {
                    root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    root = FXMLLoader.load(getClass().getResource("HomeTeacher.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

            } else {
                System.err.println("Wrong Password");
            }
        } catch (SQLException ex) {
            System.err.println("Wrong Password");
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void clickSignUp(MouseEvent event) {
        try {
            Parent root = null;
            Stage stage = new Stage();
            ((Node) event.getSource()).getScene().getWindow().hide();
            root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

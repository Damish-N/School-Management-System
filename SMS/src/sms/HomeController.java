/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import static sms.UserSession.instance;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnAddStu;
    @FXML
    private Button btnViewStu;
    @FXML
    private Button btnAddExm;
    @FXML
    private Button btnStact;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Label userName;
    @FXML
    private Label setTime;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String name = instance.getUserName();

        System.out.println(name);
        userName.setText(name);
        Thread timerThread = new Thread(() -> {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        while (true) {
            try {
                Thread.sleep(1000); //1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final String time = simpleDateFormat.format(new Date());
            Platform.runLater(() -> {
                setTime.setText(time);
            });
        }
    });   timerThread.start();
        
        
        
        
        
        
        
        try {
            
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
            borderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void logOut(ActionEvent event) {
        try {
            Parent root = null;
            Stage stage = new Stage();
            ((Node) event.getSource()).getScene().getWindow().hide();
            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickHome(ActionEvent event) {
        selectScreen("HomeView");
    }

    @FXML
    private void clickAddStu(ActionEvent event) {
        selectScreen("AddStudent");
    }

    @FXML
    private void clickViewStu(ActionEvent event) {
        selectScreen("ViewStudents");
    }

    @FXML
    private void clickAddExm(ActionEvent event) {
    }

    @FXML
    private void clickStact(ActionEvent event) {
    }
    
    private void selectScreen(String page){
        try {
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
            borderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

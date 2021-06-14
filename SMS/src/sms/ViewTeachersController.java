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
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ViewTeachersController implements Initializable {

    @FXML
    private TableView<Teachers> tvPendingTech;
    @FXML
    private TableColumn<Teachers, Integer> colId;
    @FXML
    private TableColumn<Teachers, String> colUserName;
    @FXML
    private TableColumn<Teachers, String> colName;
    @FXML
    private TableView<Teachers> tvRegTech;

    public ViewTeachersModel viewTeachersModel = new ViewTeachersModel();
    @FXML
    private TableColumn<Teachers, String> colBirthDay;
    @FXML
    private TableColumn<Teachers, Integer> colIdR;
    @FXML
    private TableColumn<Teachers, String> colUserNameR;
    @FXML
    private TableColumn<Teachers, String> colNameR;
    @FXML
    private TableColumn<Teachers, String> colDOBR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        Thread timerThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000); //1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                Platform.runLater(() -> {
                    pendingTeach();
                    regTeach();
                });
            }
        });
        timerThread.start();
        

        tvPendingTech.setRowFactory(tv -> {
            TableRow<Teachers> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    try {
                        Teachers rowData = row.getItem();
                        System.out.println(rowData.getName());

                        Parent root = null;
                        Stage stage = new Stage();
//                        ((Node) event.getSource()).getScene().getWindow().setOpacity(.5);
                        root = FXMLLoader.load(getClass().getResource("TeacherReq.fxml"));
                        Scene scene = new Scene(root);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initOwner(root.getScene().getWindow());
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(ViewTeachersController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
            return row;
        });

    }

    @FXML
    private void clickUnregTech(MouseEvent event) {

//        try {
//            System.out.println("Clicked it");
//            Parent root = null;
//            Stage stage = new Stage();
////            ((Node) event.getSource()).getScene().getWindow().setOpacity(.5);
//            root = FXMLLoader.load(getClass().getResource("TeacherReq.fxml"));
//            Scene scene = new Scene(root);
//            
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(ViewTeachersController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        TableRow<Teachers> row = new TableRow<>();
//        if (event.getClickCount() == 2 && (!row.isEmpty())) {
//                    Teachers rowData = row.getItem();
//                    System.out.println(rowData.getName());
//                }
    }

    private void pendingTeach() {
        ObservableList<Teachers> list = viewTeachersModel.getTeachersList();
        System.out.println(list);
        colId.setCellValueFactory(new PropertyValueFactory<Teachers, Integer>("teacherId"));
        colName.setCellValueFactory(new PropertyValueFactory<Teachers, String>("name"));
        colUserName.setCellValueFactory(new PropertyValueFactory<Teachers, String>("userName"));
        colBirthDay.setCellValueFactory(new PropertyValueFactory<Teachers, String>("birthDay"));

        tvPendingTech.setItems(list);
    }

    private void regTeach() {
        ObservableList<Teachers> Reglist = viewTeachersModel.getRegTeachersList();
        colIdR.setCellValueFactory(new PropertyValueFactory<Teachers, Integer>("teacherId"));
        colNameR.setCellValueFactory(new PropertyValueFactory<Teachers, String>("name"));
        colUserNameR.setCellValueFactory(new PropertyValueFactory<Teachers, String>("userName"));
        colDOBR.setCellValueFactory(new PropertyValueFactory<Teachers, String>("birthDay"));

        tvRegTech.setItems(Reglist);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        ObservableList<Teachers> list= viewTeachersModel.getTeachersList();
        System.out.println(list);
        colId.setCellValueFactory(new PropertyValueFactory<Teachers, Integer>("teacherId"));
        colName.setCellValueFactory(new PropertyValueFactory<Teachers, String>("name"));
        colUserName.setCellValueFactory(new PropertyValueFactory<Teachers, String>("userName"));
        colBirthDay.setCellValueFactory(new PropertyValueFactory<Teachers, String>("birthDay"));
        
        tvPendingTech.setItems(list);
        
        
        
        ObservableList<Teachers> Reglist= viewTeachersModel.getRegTeachersList();
        System.out.println(list);
        colIdR.setCellValueFactory(new PropertyValueFactory<Teachers, Integer>("teacherId"));
        colNameR.setCellValueFactory(new PropertyValueFactory<Teachers, String>("name"));
        colUserNameR.setCellValueFactory(new PropertyValueFactory<Teachers, String>("userName"));
        colDOBR.setCellValueFactory(new PropertyValueFactory<Teachers, String>("birthDay"));
        
        tvRegTech.setItems(Reglist);
        
        
        
        
        
        
    }    
    
    
    
    
    
    
}

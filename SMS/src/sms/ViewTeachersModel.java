/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author HP
 */
public class ViewTeachersModel {
    Connection connection;

    public ViewTeachersModel() {
        connection = SqlConnection.connector();
        if (connection == null) {
//            System.out.println("Exit here");
            System.exit(1);
        }
    }

    public boolean isDbconnected() {
        try {
//            System.out.println(connection.isClosed());
            return !connection.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(ViewTeachersModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public ObservableList<Teachers> getTeachersList(){
        try {
            ObservableList<Teachers> techList = FXCollections.observableArrayList();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            String query = "Select * from teachers where status == 0 ";
            Teachers teachers;
;            
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                teachers = new Teachers(resultSet.getInt("teacherId"), resultSet.getString("name"), resultSet.getString("userName"),resultSet.getString("birthDay"));
                techList.add(teachers);
            }
            return techList;
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewTeachersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
         
         
         
     }
    
    public ObservableList<Teachers> getRegTeachersList(){
        try {
            ObservableList<Teachers> techList = FXCollections.observableArrayList();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            String query = "Select * from teachers where status == 1 ";
            Teachers teachers;
;            
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                teachers = new Teachers(resultSet.getInt("teacherId"), resultSet.getString("name"), resultSet.getString("userName"),resultSet.getString("birthDay"));
                techList.add(teachers);
            }
            return techList;
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewTeachersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
         
         
         
     }
    
    
}

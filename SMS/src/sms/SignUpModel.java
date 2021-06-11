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

/**
 *
 * @author HP
 */
public class SignUpModel {

    Connection connection;

    public SignUpModel() {
        connection = SqlConnection.connector();
        if (connection == null) {
            System.out.println("Connected");
        } else {
            System.err.println("Disconected");
        }
    }

    boolean isDisconected() {
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isCreatedPrinciple(String userName, String name, String password, String bDay) {
        try {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            String query = "";
            query = "INSERT INTO principle (userName,name,password,birthDay)   VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "PRI-" + userName);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, bDay);

//            resultSet = preparedStatement.executeQuery();
            int i = preparedStatement.executeUpdate();
            System.out.println(bDay);
            if (i > 0) {
                System.out.println("wadee okey");
                return true;
            } else {
                System.out.println("wadee  not okey");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SignUpModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean isCreatedTeacher(String userName, String name, String password, String bDay) {
        try {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            String query = "";
            query = "INSERT INTO teachers (userName,name,password,birthDay)   VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "TEC-" + userName);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, bDay);

//            resultSet = preparedStatement.executeQuery();
            int i = preparedStatement.executeUpdate();
            System.out.println(bDay);
            if (i > 0) {
                System.out.println("wadee okey");
                return true;
            } else {
                System.out.println("wadee  not okey");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SignUpModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}

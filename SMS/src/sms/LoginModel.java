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
public class LoginModel {

    Connection con;

    public LoginModel() {
        con = SqlConnection.connector();
        if (con == null) {
            System.exit(1);
        }
    }

    public boolean isDisconected() {
        try {
            return !con.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean isLogin(String user, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        
        String query = "";
//        System.err.println(user);
        if (user.matches("PRI(.*)")) {
            try {
                query = "Select * from principle where userName= ? and password = ? ";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }

            } catch (SQLException ex) {

                Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
                return false;

            }
        } else {

            try {
                query = "Select * from teachers where userName= ? and password = ?  and status == 1";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } 
        }

    }
}

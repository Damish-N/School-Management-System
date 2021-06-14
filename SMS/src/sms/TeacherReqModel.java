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
public class TeacherReqModel {

    Connection connection;

    public TeacherReqModel() {
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

    public boolean acceptReq(String userName) {
        try {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            System.out.println(userName);
            String query = "";
            query = "UPDATE teachers SET status = 1 WHERE userName == ? ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);

            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                System.out.println("wadee okey");
                return true;
            } else {
                System.out.println("wadee  not okey");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TeacherReqModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}

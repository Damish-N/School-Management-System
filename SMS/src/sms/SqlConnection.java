/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class SqlConnection {

    public static Connection connector() {

        try {
            Class.forName("org.sqlite.JDBC");
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\HP\\Desktop\\test\\test.sqlite");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sms.sqlite");
            return conn;
        } catch (Exception e) {

            return null;
        }

    }

}

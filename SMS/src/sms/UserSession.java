/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

/**
 *
 * @author HP
 */
public class UserSession {
    
   public static UserSession instance;
    private String userName;
    UserSession(String userName) {
        this.userName = userName;
    }

    public static UserSession getInstace(String userName) {
        if(instance== null) {
            instance = new UserSession(userName);
        }
        return instance;
    }
    public String getUserName() {
        return userName;
    }
    public void cleanUserSession() {
        userName = null;// or null
        instance = null;
    }
     public String toString() {
        return "UserSession{" +
                "userName='" + userName+
                '}';
    }
    
    
}

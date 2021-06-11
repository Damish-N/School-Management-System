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
public class Teachers {
    private int teacherId;
    private String name;
    private String userName;
    private String birthDay;

    public Teachers(int teacherId, String name, String userName, String birthDay) {
        this.teacherId = teacherId;
        this.name = name;
        this.userName = userName;
        this.birthDay = birthDay;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    
   

    
    
}

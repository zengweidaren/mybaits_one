package com.zengweidaren.pojo;


//import java.util.Arrays;

public class User {

    protected String id ;

    protected String magicId ;

    protected String firstName ;

    protected String lastName ;

//    protected String[] depts ;
    protected String username ;
    protected  String numstate;

    public String getNumstate() {
        return numstate;
    }

    public void setNumstate(String numstate) {
        this.numstate = numstate;
    }

//    public String[] getDepts() {
//        return depts;
//    }
//
//    public void setDepts(String[] depts) {
//        this.depts = depts;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMagicId() {
        return magicId;
    }

    public void setMagicId(String magicId) {
        this.magicId = magicId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", magicId='" + magicId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
//                ", depts=" + Arrays.toString(depts) +
                ", username='" + username + '\'' +
                ", numstate='" + numstate + '\'' +
                '}';
    }
}
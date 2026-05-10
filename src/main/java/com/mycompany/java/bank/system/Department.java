/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.bank.system;

/**
 *
 * @author yarzarmin
 */
//abstract class for all department subclass
public abstract class Department {
    
    private int departmentId;
    private String departmentName;
    
    //constructor
    public Department(int departmentId, String departmentName){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
    
    //getter for department id
    public int getDepartmentId(){
        return departmentId;
    }
    
    //getter for department name
    public String getDepartmentName(){
        return departmentName;
    }
    
    //abstract class for every subclass
    public abstract String getDeparmentFunction();
    
    //to string department print nicely
    @Override
    public String toString(){
        return departmentName;
    }
}

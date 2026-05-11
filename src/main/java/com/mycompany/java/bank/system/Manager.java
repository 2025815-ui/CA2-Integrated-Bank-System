/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.bank.system;

/**
 *
 * @author yarzarmin
 */
//abstract class for all manager subclass
public abstract class Manager {
    
    private int managerId;
    private String managerType;
    
    //create constructor
    public Manager(int managerId, String managerType){
        this.managerId = managerId;
        this.managerType = managerType;
    }
    
    //getter for managerID
    public int getmanagerId(){
        return managerId;
    }
    
    //getter for managertype
    public String getmanagerType(){
        return managerType;
    }
    
    //to string manager print nicely
    @Override
    public String toString(){
        return managerType;
    }
}


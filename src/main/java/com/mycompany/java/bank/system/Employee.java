/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.bank.system;

/**
 *
 * @author yarzarmin
 */

//Abstract class for all employee subclass
public abstract class Employee {
    
    private String employeeName;
    private Manager manager;
    private Department department;
    
    //constructor
    public Employee(String employeeName,Manager manager, Department department){
        this.employeeName = employeeName;
        this.manager = manager;
        this.department = department;
    }
    
    //getter for employeename
    public String getEmployeeName(){
        return employeeName;
    }
    
    //getter for manager
    public Manager getManager(){
        return manager;
    }
    
    //getter for department
    public Department getDepartment(){
        return department;
    }

    public abstract String getRole();
    //to string print nicely
    @Override
    public String toString(){
        return "Name: " + employeeName
                + "| Role: " + getRole()
                + " | Manager: " + manager.getmanagerType()
                + " | Department: " + department.getDepartmentName();
    }
}

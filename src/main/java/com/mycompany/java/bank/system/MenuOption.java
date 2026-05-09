/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.bank.system;

/**
 *
 * @author yarzarmin
 */
public enum MenuOption {
    //create menu with enum, each constant stores a number and a display label
    SORT_EMPLOYEE(1,"Sort Employees"),
    SEARCH_EMPLOYEE(2,"Search Employees"),
    ADD_EMPLOYEE(3,"Add Employee"),
    CREATE_BINARY_TREE(4,"Create Binary Tree"),
    EXIT(5,"Exit the program");
    
    private int value;
    private String label;
    
    //enum menu constructor
    MenuOption(int value, String label){
        this.value = value;
        this.label = label;
    }
    
    //get method for input value
    public int getValue(){
        return value;
    }
    
    //get method for input label
    public String getLabel(){
        return label;
    }
}

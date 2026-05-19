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
    LOAD_FILE(1,"Load the file"),
    SORT_EMPLOYEE(2,"Sort Employees"),
    SEARCH_EMPLOYEE(3,"Search Employees"),
    ADD_EMPLOYEE(4,"Add Employee"),
    CREATE_BINARY_TREE(5,"Create Binary Tree"),
    EXIT(6,"Exit the program");
    
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

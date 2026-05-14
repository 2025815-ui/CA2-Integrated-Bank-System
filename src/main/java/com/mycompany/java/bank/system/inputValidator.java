/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.bank.system;

/**
 *
 * @author yarzarmin
 */
public class inputValidator {
    
    //validate name input from user
    public static boolean isValidName(String name){
        
        //check if null
        if(name == null){
            System.out.println("Name cannot be empty!");
            return false;
        }
        
        //check if there is number or special character input
        if(!name.matches("[a-zA-Z]+") || name.trim().isEmpty()){
            System.out.println("Name must contain letters only!");
            return false;
        }
        
        //check name input is Full name
        String [] part = name.trim().split(" ");
        if(part.length < 2){
            System.out.println("Please Enter both First name and Last name!");
            return false;
        }
        
        return true;
    }
    //validate manager selection
    public static boolean isValidManager(int choice){
        if(choice < 1 || choice > 3){
            System.out.println("Invalid Manager choice ! Please choose between 1 to 3.");
            return false;
    }
        return true;
    }   
    //validate department selectioin
    public static boolean isValidDepartment(int choice){
        if(choice <1 || choice > 4){
            System.out.println("Invalid Department choice ! Please choose between 1 to 4");
            return false;
        }
        return true;
    }
    //validate role selection
    public static boolean isValidRole(int choice) {
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid role choice! Please enter 1, 2 or 3.");
            return false;
        }
        return true;
    }
        
}

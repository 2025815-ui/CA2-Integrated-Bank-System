/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.java.bank.system;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yarzarmin
 */
public class JavaBankSystem {
    
      //static class for the menu option and this will call in main class
    public static void displayMenu() {
        System.out.println("\n======BANK SYSTEM======");
        //using foreach loop to show all the options
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getValue() + "." + option.getLabel());
        }
        System.out.println("\nEnter your choice: ");
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please Enter the file to read: ");
        String filename = input.nextLine(); //getting user input
        
        ArrayList<String> names = ApplicantFileReader.readNames(filename);//reading the file
        
      
        boolean running = true;

        while (running) {
            displayMenu();
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch(choice){
                case 1:
                    
                case 2:
                    
                case 3:
                    
                case 4:
                    
                case 5:
                    
                default:
                    System.out.println("Invalid Choice!!!");
            }
        }
    }

  

}

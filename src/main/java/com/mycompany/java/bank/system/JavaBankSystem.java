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

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    //static class for the menu option and this will call in main class
    public static void displayMenu() {
        System.out.println("\n======BANK SYSTEM======");
        //using foreach loop to show all the options
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getValue() + "." + option.getLabel());
        }
        System.out.println("\nEnter your choice: ");
    }

    public static void LoadFromFile(String filename) {

        ArrayList<Employee> loaded = ApplicantFileReader.LoadNameFromFile(filename);

        if (loaded.isEmpty()) {
            System.out.println("No Name loaded from file!");
        }

        //Check each loaded employee before adding to main list
        int added = 0;

        for (Employee e : loaded) {

            boolean duplicate = false;
            
            for (Employee existing : employees) {
                
                if (existing.getemployeeName().equalsIgnoreCase(e.getemployeeName())) {
                    
                    duplicate = true;
                    break; // stop checking — already found a match
                }
            }
            if(!duplicate){
                employees.add(e);
                added++;
                
            }
        }
        employees.addAll(loaded);

        ApplicantFileReader.displayFirst20(employees);

    }
    
    

    public static void main(String[] args) {


        LoadFromFile("Applicants_Form.txt");

        boolean running = true;

        while (running) {
            displayMenu();

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:

                case 6:

                default:
                    System.out.println("Invalid Choice!!!");
            }
        }
    }

}

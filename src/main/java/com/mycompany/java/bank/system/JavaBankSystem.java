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
                
                if (existing.getEmployeeName().equalsIgnoreCase(e.getEmployeeName())) {
                    
                    duplicate = true;
                    break; // stop checking — already found a match
                }
            }
            if(!duplicate){
                employees.add(e);
                added++;
                
            }
        }
        System.out.println(added + " employee added!");

        ApplicantFileReader.displayFirst20(employees);

    }
    
    public static void sortEmployee(){
        
        if(employees.isEmpty()){
            System.out.println("No employee to sort!");
            System.out.println("Please load a file or add employee first");
            return;
        }
        
        EmployeeSorter.mergeSort(employees,0, employees.size() - 1);
        System.out.println("\nEmployee sorted successfully!");
        
        int limit = Math.min(20, employees.size());
        System.out.println("=====First " + limit + " sorted employees.");
        for(int i = 0; i< limit; i++){
            System.out.println((i+1) + ". " + employees.get(i));
        }
        
        System.out.println("\nTotal employees in the system " + employees.size() );
    }
    
    
    public static void searchEmployee(){
        
    }
    
    
    public static void addEmployee(){
        
    }
    
    
    public static void createBinaryTree(){
        
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
                    sortEmployee();
                    break;
                

                case 2:
                    searchEmployee();
                    break;

                case 3:
                    addEmployee();
                    break;

                case 4:
                    createBinaryTree();
                    break;

                case 5:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid Choice!!!");
            }
        }
    }

}

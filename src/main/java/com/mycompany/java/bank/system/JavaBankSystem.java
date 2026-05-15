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
        //check if the list is empty
        if(employees.isEmpty()){
            System.out.println("No employee to search!");
            System.out.println("Please load a file or add employee first");
            return;
        }
        //sorting before search, because binarysearch works on sorted list.
        EmployeeSorter.mergeSort(employees, 0, employees.size() - 1);
        
        //Ask user for name to search
        System.out.println("\nEnter employee name to search..");
                
        String searchName = input.nextLine();
        
        //run binarysearch on sorted list and stored the name in result.
        int index = EmployeeSearcher.binarySearch(employees, 0, employees.size() -1 , searchName);
        
        //checking if the name is in the list
        if(index != -1){
            
            Employee result= employees.get(index);
            
            System.out.println("\nEmployee found.");
            System.out.println("====================");
            System.out.println(result);
            System.out.println("====================");

        }else{
            System.out.println("Employee not found!");
            System.out.println("\nMake sure Employee name is spelled correctly.");
        }
        
    }
    
    
    public static void addEmployee(){
        
        System.out.println("\n=====ADD EMPLOYEE=====");
        
        System.out.println("Enter Employee name (First name & Last name): ");
        String addName = input.nextLine();
        
        if(!inputValidator.isValidName(addName)){
            return;
        }
        
        System.out.println("\n=====Enter Manager Type=====");
        System.out.println("1. Senior Manager");
        System.out.println("2. Assistant Manager");
        System.out.println("3. Team Lead");
        System.out.println("Enter your choice: ");
        int managerChoice = input.nextInt();
        input.nextLine();
        
        if(!inputValidator.isValidManager(managerChoice)){
            return;
        }
        
        
        System.out.println("\n=====Select Department=====");
        System.out.println("1. IT");
        System.out.println("2. HR");
        System.out.println("3. Loan");
        System.out.println("4. Foreign Exhange");
        System.out.println("Enter your choice: ");
        int departmentChoice = input.nextInt();
        input.nextLine();
        
        if(!inputValidator.isValidDepartment(departmentChoice)){
            return;
        }
        
        System.out.println("\n====Select Role=====");
        System.out.println("1. Teller");
        System.out.println("2. Loan Officer");
        System.out.println("3. Security Guard");
        System.out.println("Enter your choice: ");
        int roleChoice = input.nextInt();
        input.nextLine();
        
        if(!inputValidator.isValidRole(roleChoice)){
            return;
        }
        
        Manager manager;
        switch(managerChoice){
            case 1: 
                manager = new SeniorManager(); break;
            case 2:
                manager = new AssistantManager(); break;
            default :
                manager = new TeamLead(); break;
        }
        
        Department department;
        switch(departmentChoice){
            case 1:
                department = new ITDepartment(); break;
            case 2:
                department = new HRDepartment(); break;
            case 3:
                department = new LoanDepartment(); break;
            default :
                department = new ForeignExchangeDepartment(); break;
                
        }
        
        Employee employee;
        switch(roleChoice){
            case 1:
                employee = new Teller(addName,manager,department); break;
            case 2:
                employee = new  LoanOfficer(addName,manager,department); break;
            default:
                employee = new SecurityGuard(addName,manager,department); break;
        }
        
        employees.add(employee);
        System.out.println("\n" + addName + " added successfully!");
        System.out.println(employee);
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
                    EmployeeHierarchy.buildHierarchy(employees);
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid Choice!!!");
            }
        }
        input.close();
    }

}

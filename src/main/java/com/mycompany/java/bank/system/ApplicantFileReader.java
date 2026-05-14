/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.bank.system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author yarzarmin
 */
public class ApplicantFileReader {

    public static ArrayList<String> readNames(String filename) {

        ArrayList<String> names = new ArrayList<>();//create empty array list

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename)); //read file from user input

            reader.readLine();
            String line;
            //Validate while reading file
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {

                    String[] parts = line.split(",");

                    // Make sure line has at least first and last name
                    if (parts.length >= 2) {

                        // Combine first name and last name only
                        String fullName = parts[0].trim()
                                + " "
                                + parts[1].trim();
                        names.add(fullName);
                    }
                }
            }

            reader.close();//stop file reader
            System.out.println("File read successfully.");

        } catch (Exception e) {
            System.out.println("File not found : " + filename); //error handling
        }
        return names;
    }

    public static boolean isDuplicate(ArrayList<Employee> employees, String name) {
        for (Employee e : employees) {
            if (e.getEmployeeName().equalsIgnoreCase(name)) {
                return true; // duplicate found
            }
        }
        return false; // name is new

    }

    public static ArrayList<Employee> LoadNameFromFile(String filename) {

        ArrayList<String> names = readNames(filename);//read names from the file

        ArrayList<Employee> employees = new ArrayList<>(); //create empty array list for the employee names

        //validate if name is empty
        if (names.isEmpty()) {
            System.out.println("No names found in the file !");
            return employees;
        }

        Random random = new Random(); //creating random to match each name

        //convert each into employee object
        for (String name : names) {

           if(isDuplicate(employees, name)){
               continue;
            }

            //picking random manager subclass
            int managerIndex = random.nextInt(3);
            Manager manager;
            switch (managerIndex) {
                case 1:
                    manager = new SeniorManager();
                    break;
                case 2:
                    manager = new AssistantManager();
                    break;
                default:
                    manager = new TeamLead();
                    break;
            }

            int departmentIndex = random.nextInt(4);
            Department department;
            switch (departmentIndex) {
                case 1:
                    department = new ITDepartment();
                    break;
                case 2:
                    department = new HRDepartment();
                    break;
                case 3:
                    department = new LoanDepartment();
                    break;
                default:
                    department = new ForeignExchangeDepartment();
                    break;
            };

            int rolesIndex = random.nextInt(3);
            Employee employee;
            switch (rolesIndex) {
                case 1:
                    employee = new Teller(name, manager, department);
                    break;
                case 2:
                    employee = new LoanOfficer(name, manager, department);
                    break;
                default:
                    employee = new SecurityGuard(name, manager, department);
                    break;

            }

            employees.add(employee);//adding convert employee to list

        }
        System.out.println(employees.size() + " employees loaded from file.");
        return employees;
    }

    public static void displayFirst20(ArrayList<Employee> employees) {

        EmployeeSorter.mergeSort(employees, 0, employees.size() - 1);

        int limit = Math.min(20, employees.size());

        System.out.println("\n===First " + limit + " Employee sorted.");

        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + employees.get(i));
        }
    }
}

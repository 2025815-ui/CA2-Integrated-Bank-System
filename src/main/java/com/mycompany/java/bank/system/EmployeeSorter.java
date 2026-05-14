/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.bank.system;

import java.util.ArrayList;

/**
 *
 * @author yarzarmin
 */
//using merge sort for sorting employeename alphabetically
public class EmployeeSorter {
    
    //main sort method
    public static void mergeSort(ArrayList<Employee> employees, int left, int right){
        
        //single element is sorted by definition, stop recursion when one element left
        if(left < right){
            
            //find the middle to split the array
            int middle = (left + right)/2;
            
            //splitting left untill single element
            mergeSort(employees,left,middle);
            
            //splitting right untill single element
            mergeSort(employees, middle +1 , right);
            
            //combine two sorted back 
            merge(employees, left, middle, right);
        }
    }
    
    //Merging method - combine two sorted section
    public static void merge(ArrayList<Employee> employees, int left, int middle, int right){
        
        //create temporary array to store
        ArrayList<Employee> temp = new ArrayList<>();
        
      
        int i = left;// i for left
        int j = middle + 1;// j for right
        
        //comparing element from both
        while(i <= middle && j <= right){
            
            // Get first name from left element by splitting the full name and taking the first word
            String firstNameLeft = employees.get(i).getEmployeeName().split(" ")[0];
            
            // Get first name from right element by splitting the full name and taking the first word
            String firstNameRight = employees.get(j).getEmployeeName().split(" ")[0];
            
            // Compare only the first names alphabetically to decide the order
            if(firstNameLeft.compareToIgnoreCase(firstNameRight) <= 0) {
                
                temp.add(employees.get(i));//left comes first alphabetically
                i++;
                
            }else{
                
                temp.add(employees.get(j));//right comes first alphabetically
                j++;
            }  

        }
        
        // Copy the rest of the left elements to prevent duplicates or missing data
        while(i <= middle){
            temp.add(employees.get(i));
            i++;
        }
        
        // Copy the rest of the right elements to prevent duplicates or missing data
        while(j <= right){
            temp.add(employees.get(j));
            j++;
        }

        //copy sorted into original list
        for(int k=0; k < temp.size(); k++){
            employees.set(left + k, temp.get(k));
        }
    }
}

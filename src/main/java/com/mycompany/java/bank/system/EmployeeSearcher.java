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
//Searching using Binary Search Algorithms
public class EmployeeSearcher {
    
    public static Employee binarySearch(ArrayList<Employee> employee, String targetName){
        
        //start with full array
        int left = 0;
        int right = employee.size()-1;
        
        //keep searching until valid range 
        while(left <= right){
            
            //finding middle position
            int middle = (left + right)/2;
            
            //keeping middle in current
            String currentName = employee.get(middle).getEmployeeName();
            
            //compare middle with the searching name
            int comparison = currentName.compareToIgnoreCase(targetName);
            
            //Name found
            if(comparison == 0){
                return employee.get(middle);
            }
            //current comes before targetname
            if(comparison < 0){
                
                left = middle +1;
             //current comes after targetname   
            }else{
                
                left = middle -1;
            }
        }
        
        return null;//name not found in the list
    }
}

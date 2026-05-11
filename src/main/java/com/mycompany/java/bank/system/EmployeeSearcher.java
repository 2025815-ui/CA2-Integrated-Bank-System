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
public class EmployeeSearcher {
    
    public static Employee binarySearch(ArrayList<Employee> employee, String targetName){
        
        int left = 0;
        int right = employee.size()-1;
        
        while(left <= right){
            
            int middle = (left + right)/2;
            
            String currentName = employee.get(middle).getemployeeName();
            
            int comparison = currentName.compareToIgnoreCase(targetName);
            
            
            if(comparison == 0){
                return employee.get(middle);
            }
            
            if(comparison < 0){
                
                left = middle +1;
            }else{
                
                left = middle -1;
            }
        }
        return null;
    }
}

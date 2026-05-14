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
    

    public static int binarySearch(ArrayList<Employee> employees, int left, int right, String target) {
        // Base case: element not found
        if (left > right) {
            return -1;
        }

        // Find the middle index
        int mid = left + (right - left) / 2;
        
        
        String midName = employees.get(mid).getEmployeeName();
        
        
        int comparrison = midName.compareToIgnoreCase(target);

        // Check if the middle element is the target
        if (comparrison == 0) {
            return mid; // Element found
        }

        // If target is smaller, search the left half
        if (comparrison > 0) {
            return binarySearch(employees, left, mid - 1, target);
        }
        // Else, search the right half
        else {
            return binarySearch(employees, mid + 1, right, target);
        }
    }
    
}

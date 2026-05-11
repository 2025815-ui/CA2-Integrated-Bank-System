/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.bank.system;

/**
 *
 * @author yarzarmin
 */

//subclass employee
public class Teller extends Employee{
    
    // Constructor passes values up to Employee parent
    public Teller(String employeeName, Manager manager, Department department){
        super(employeeName,manager,department);
    }
    
    @Override
    public String getRole(){
        return "Teller";
    } 
}

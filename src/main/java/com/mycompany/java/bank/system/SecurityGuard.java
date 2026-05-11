/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.bank.system;

/**
 *
 * @author yarzarmin
 */
public class SecurityGuard extends Employee{
    
    public SecurityGuard(String employeeName, Manager manager, Department department){
        super(employeeName, manager, department);
    }
    
    @Override
    public String getRole(){
        return "Security Guard";
    }
}

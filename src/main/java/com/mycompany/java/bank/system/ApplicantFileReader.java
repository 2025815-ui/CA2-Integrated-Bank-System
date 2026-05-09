/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.bank.system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/**
 *
 * @author yarzarmin
 */
public class ApplicantFileReader {
    
    public static ArrayList<String> readNames(String filename){
        ArrayList<String> names = new ArrayList<>();
        
        try{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null){
                if(!line.trim().isEmpty()){
                    names.add(line);
                }
            }
            reader.close();
            System.out.println("File read successfully.");
            
        }catch(Exception e){
            System.out.println("File not found : " + filename);
        }
        return names;
    }
}

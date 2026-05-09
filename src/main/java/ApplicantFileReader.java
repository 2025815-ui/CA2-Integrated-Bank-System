/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/**
 *
 * @author yarzarmin
 */
public class ApplicantFileReader {
    
    public static ArrayList<String> readNames(String fileName){
        ArrayList<String> names = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            
        }catch(Exception e){
            System.out.println("File not found : " + fileName);
        }
        return names;
    }
}

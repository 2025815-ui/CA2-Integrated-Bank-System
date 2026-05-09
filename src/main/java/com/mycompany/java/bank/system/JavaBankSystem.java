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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the file to read: ");
        String filename = input.nextLine();
        ArrayList<String> names = ApplicantFileReader.readNames("Applicant_Form.txt"); 
    }
}

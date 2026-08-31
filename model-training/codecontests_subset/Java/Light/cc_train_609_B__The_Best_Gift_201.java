//package codeforce;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package codeforce;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wired
 */
public class CodeFOrce2 {

    /**
     * @param args the command line arguments
 
 */
    static Scanner reader = new Scanner(System.in);  
    static int arr1[];
    static int arr2[];
    static int n ,m ;
    
    public static void main(String[] args) {
            n = reader.nextInt();
            m = reader.nextInt();
    
            arr1=new int[n];
            arr2=new int[m];
            
            for (int i = 0; i < m; i++) {
                arr2[i]=0;
            }
            for(int i=0;i<n;i++){
               int num = reader.nextInt(); 
                arr1[i]= num;
                arr2[num-1]++;
            }
            int c=0;
            for (int i = 0; i < n; i++) {
                c+=n - i -arr2[arr1[i]-1];
                arr2[arr1[i]-1]--;   
            }
            System.out.println(c);
    }
    
}




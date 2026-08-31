/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.math.*;
import java.io.*;

/**
 *
 * @author magzhankairanbay
 */
public class Code {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
        
            Scanner in = new Scanner(System.in);
            
            int n = in.nextInt();
            
            int k = 0;
            
            String s = in.next();   
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'I') {
                    k++;
                }
            }
            
            if (k >= 1) {
                if (k == 1) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                return;
            } 
            
            int c = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'A') {
                    c++;
                }
            }
            
            System.out.println(c);
            
        } catch(Exception ex) {
        
            System.out.println(ex.toString());
        }
    }
    
}
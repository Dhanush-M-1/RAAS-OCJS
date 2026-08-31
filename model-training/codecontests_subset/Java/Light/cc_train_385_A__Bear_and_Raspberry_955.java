/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication5;

import java.util.Scanner;

/**
 *
 * @author pro
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner r=new Scanner(System.in);
       int d,s,max=0,f[] ;
       
       d=r.nextInt();
       s=r.nextInt();
       f=new int[d];
       for(int i=0;i<d;i++)
       {
            f[i]=r.nextInt();
           
       }
        for(int i=0;i<d-1;i++)
        {
            max=Math.max(f[i]-f[i+1]-s, max);
        }
        System.out.println(max);
    }
    
}

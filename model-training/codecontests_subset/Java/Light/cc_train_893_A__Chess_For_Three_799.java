/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package pkg893a;

import java.util.Scanner;

/**
 *
 * @author pranto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
       int ck=3;
       boolean flag=true;
       for(int i=0;i<n;i++){
       int a=in.nextInt();
       if(a==ck){
           System.out.println("NO");
           flag=false;
       break;
       }
       
       ck=6-ck-a;
       
       }
       if(flag==true){
           System.out.println("YES");}
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Ahmed-Kharoubi
 */
public class A11 {
     public static void main(String[] args) {
         Scanner input=new Scanner(System.in); 
         
         int k =input.nextInt();
         input.nextLine();
         String s=input.nextLine(); 
         int[] occ =new int[26]; 
         if (k==1){
             System.out.println(s);
             return;}
         for (int i=0;i<s.length();i++){
             occ[s.charAt(i)-'a']++; 
             
         }
         String b=""; 
         for (int i=0;i<26;i++){
             if ((occ[i]%k)==0){
                 for (int j=0;j<(occ[i]/k);j++){
                        b+=(char)(i+'a');}
                 
             }
             else {
                 System.out.println(-1);
                  return;
         }}
             String l="";
             for (int i=0;i<k;i++){
                 l+=b;
             }
             System.out.println(l);
         }
}
         
         
    
     


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Bryan AW
 */
public class Codeforces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        //A and B and Compilation Errors
                  
          Scanner sc=new Scanner(System.in);
          
          int n=Integer.parseInt(sc.next());
          
          int[] a=new int[n];
          
          for (int i=0;i<n;i++){
              a[i]=Integer.parseInt(sc.next());
          }
          
          Arrays.sort(a);
          
          int[] b=new int[n-1];
          
          for (int i=0;i<n-1;i++){
              b[i]=Integer.parseInt(sc.next());
          }
          
          Arrays.sort(b);
          
          int[] c=new int[n-2];
          
          for (int i=0;i<n-2;i++){
              c[i]=Integer.parseInt(sc.next());
          }
          
          Arrays.sort(c);
          
          int err1=a[n-1], err2=b[n-2];
          
          for (int i=0;i<n-1;i++){
              if (a[i]!=b[i]){
                  err1=a[i];
                  break;
              }
          }
          
          for (int i=0;i<n-2;i++){
              if (b[i]!=c[i]){
                  err2=b[i];
                  break;
              }
          }
          
          System.out.println(err1);
          
          System.out.println(err2);
        
    }
    
}

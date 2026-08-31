/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 //package bear.and.raspberry;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author kero atef
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   public static int a ;
    public static void main(String[] args){
        
    int n,c,x,z,y,k,m=0,g,w;
    Scanner o = new Scanner (System.in);
   // BufferedReader o= new BufferedReader (new InputStreamReader (System.in));
    n = o.nextInt();
    c= o.nextInt();
    int [] arr = new int [n];
    int [] arr2 = new int [n];
    for (int i=0;i<n;i++)
    {
        x = o.nextInt();
        arr[i]= x;
    }
    for (int j=0 ;j<n-1;j++)
    {
        if (arr[j]>arr[j+1])
        {
            y=arr [j]-arr[j+1];
            arr2  [m]=y;
            m++;
        }
    }
    if (m!=0)
    {
    Arrays.sort(arr2);
  w= arr2.length;
    z= arr2 [w-1];
     for (int l=0 ;l<n-1;l++)
    {
        if (arr[l] > arr[l+1])
        {
            g=arr [l]-arr[l+1];
            if (z==g)
            {
                a= l;
            }
        }
    }
    k= arr[a]-arr[a+1]-c;
     if (k>=0)
     {
         System.out.println(k);
     }
    else
     {
         System.out.println(0);
     }
       
    }
    else 
    {
        System.out.println(0);
    }
    }
}

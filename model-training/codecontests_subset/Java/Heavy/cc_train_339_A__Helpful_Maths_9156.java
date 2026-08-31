/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public final class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        String str=in.next();
        int[] arr= new int[4];
        arr[0]=0;
        for(int i=0;i<str.length();i=i+2){
            arr[Integer.parseInt(str.substring(i,i+1))]+=1;
        }
       // System.out.println(arr[3]);
        String ans="";
        String temp="";
        int chk=0;
        for(int j=1;j<=3;j++){
            temp="";chk=j;
            for(int k=0;k<arr[j];k++){
            
            temp=""+chk;
            //System.out.println("temp :"+temp);
             ans=ans+temp+"+";}
        }
        System.out.println(ans.substring(0,str.length()));
}}
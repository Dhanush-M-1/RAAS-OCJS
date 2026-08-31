/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Lost;
import java.io.*;
import java.util.*;
public class A1165 
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        int c=0,cou=0;
        String s=sc.next();
        for(int i=s.length()-1;i>=0;i--)
        {
            if(c==y)
            {
                if(s.charAt(i)=='0')
                    cou++;
                
            }
            else if(c==x)
                break;
            else
            {
                if(s.charAt(i)=='1')
                        cou++;
            }
            c++;
        }
        System.out.println(cou);
    }
}

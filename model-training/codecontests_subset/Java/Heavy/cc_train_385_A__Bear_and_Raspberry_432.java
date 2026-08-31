/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package codeforces;

import java.util.Scanner;

/**
 *
 * @author Pulkit
 */
public class q1_2401 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n,c;
        n=in.nextInt();
        c=in.nextInt();
        int[] ar=new int[n];
        int i,max=0;
        for(i=0;i<n;i++)
        {
            ar[i] = in.nextInt();
            if(i>0)
            {
                if((ar[i-1] - ar[i] - c)>max)
                {
                    max = (ar[i-1] - ar[i] - c);
                }
            }
                    
        }
        System.out.println(max);
    }
    
}

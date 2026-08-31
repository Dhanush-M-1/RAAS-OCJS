/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package acm.prepare;

import java.util.Scanner;

/**
 *
 * @author Rock
 */
public class Fox {
    

    
public static void main(String[] stuff)   
{
    
Scanner in = new Scanner(System.in);
 int[] Divisors = {2,3,5};
		int a=in.nextInt(), b = in.nextInt();
                
                if(a==b)
                {
                    
                    System.out.println("0");
                    System.exit(0);
                }
                
		int ans = 0;
		for(int i =0;i<3;i++)
		{
			int c = 0;
                        int k = 0;
			while(a%Divisors[i]==0) {a/=Divisors[i]; c++;}
			while(b%Divisors[i]==0) {b/=Divisors[i]; k++;}
			ans+=Math.abs(c-k);
		}
                System.out.println((a==b)? ans : "-1");
                
		
    
    
}}

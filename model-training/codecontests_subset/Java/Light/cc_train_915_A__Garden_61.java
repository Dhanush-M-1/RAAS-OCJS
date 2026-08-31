//package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
	   Scanner s = new Scanner(System.in);

	   int totalBuckets = s.nextInt();
	   int gardenLength = s.nextInt();

	   int minHours = Integer.MAX_VALUE;
	   while(totalBuckets --> 0)
       {
           int capacity = s.nextInt();

           if(gardenLength%capacity == 0)
           {
               minHours = Math.min(minHours,gardenLength/capacity);
           }
       }

       System.out.println(minHours);
    }
}

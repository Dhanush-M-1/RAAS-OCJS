//package com.example.myPackage;

import java.util.Scanner;

public class BadTriangle {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int t = s.nextInt();
        while(t-->0)
        {

            int n = s.nextInt();
            long arr[] = new long[n];
            for(int i=0;i<n;i++)
                arr[i] = s.nextLong();

           if(arr[n-1]>=(arr[0] + arr[1]))
               System.out.println(1 +" " +2 + " "+ n );
            else
                System.out.println(-1);


        }
    }
}

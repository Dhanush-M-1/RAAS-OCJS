//package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class H {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int k = sc.nextInt();
        for(int i=1;i<k;i++){
            for(int j=1;j<k;j++){
                System.out.print(Integer.toString(i*j,k)+" ");
            }
            System.out.println();
        }
    }
}

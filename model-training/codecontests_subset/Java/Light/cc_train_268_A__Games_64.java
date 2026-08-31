//package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int sum=0;
        int[]home= new int[101];
        int []guest = new int[101];
        for(int i=0; i< n; i++){
            home[input.nextInt()]++;
            guest[input.nextInt()]++;
        }
            for(int j=0; j< 101; j++){
                    sum+=(home[j]*guest[j]);
            }

        System.out.println(sum);
    }
}

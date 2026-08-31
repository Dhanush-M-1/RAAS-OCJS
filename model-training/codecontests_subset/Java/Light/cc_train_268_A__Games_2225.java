//package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int sum=0;
        int[]home= new int[n];
        int []guest = new int[n];
        for(int i=0; i< n; i++){
            home[i]=input.nextInt();
            guest[i]=input.nextInt();
        }
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if(home[i]==guest[j])
                    sum++;
            }
        }
        System.out.println(sum);
    }
}

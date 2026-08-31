//package com.company;

import java.util.*;

public class A {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int mn = 0;
        //int m = (int)1e6;
        int res = 0;
        for(int i = 0; i<n; i++){
            int temp = in.nextInt();
            mn = Math.max(mn,Math.min(temp-1,(int)1e6-temp));
        }
        System.out.println(mn);
    }
}

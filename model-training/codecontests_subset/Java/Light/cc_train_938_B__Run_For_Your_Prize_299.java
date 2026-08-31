//package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=1,j=-1;
        int x;
        for(int k=0;k<n;k++){
            x=sc.nextInt();
            if(x<=500000)
                i=x;
            else if(j==-1){
                j=x;
            }
        }
        if(j==-1)
            j=1000000;
        System.out.println(Math.max(i-1,1000000-j));
    }
}
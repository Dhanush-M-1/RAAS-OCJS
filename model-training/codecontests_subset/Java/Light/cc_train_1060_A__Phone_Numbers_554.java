//package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String s = in.next();
        int[] arr = new int[10];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'0']+=1;
        }
        System.out.println(Math.min(arr[8],t/11));
    }
}

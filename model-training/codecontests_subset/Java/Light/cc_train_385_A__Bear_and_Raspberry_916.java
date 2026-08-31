//package com.example.hackerranksolutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CodeforcesProblems {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int c = in.nextInt();
        int res = 0;
        int prev = in.nextInt();
        for(int i = 1; i<n; i++) {
            int cur = in.nextInt();
            int val = prev - cur - c;
            if(val>res) {
                res = val;
            }
            prev = cur;
        }
        System.out.println(res);
    }
}

//package com.example.hackerranksolutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Temp {



    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] pos = new int[127];
        for(int i = 'a'; i<='z'; i++) pos[i] = -1;
        for(int i = n-1; i>=0; i--) {
            int x = str.charAt(i);
            if(pos[x] < 0) pos[x] = i;
        }
        for(int i = 0; i<n; i++) {
            int x = str.charAt(i);
            for(int j = x-1; j>='a'; j--) {
                if(pos[j] > i) {
                    System.out.println("YES\n"+(i+1)+" "+(pos[j]+1));
                    return;
                }
            }
        }
        System.out.println("NO");
    }

}


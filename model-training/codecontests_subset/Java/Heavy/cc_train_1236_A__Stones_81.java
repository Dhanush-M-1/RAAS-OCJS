/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Akhilesh
 */
public class A1236 {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(scan.readLine().trim());
        
        test : while(t-- > 0){
            String str[] = scan.readLine().split("\\s+");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            int ans1 = 0, ans2 = 0;
            
            ans1 += Math.min(3*b, 3*(c/2));
            b -= ans1/3;
            ans1 += Math.min(3*a, 3*(b/2));
            
            ans2 += Math.min(3*a, 3*(b/2));
            b -= (ans2/3)*2;
            ans2 += Math.min(3*b, 3*(c/2));
            System.out.println(Math.max(ans1, ans2));
        }
    }
}

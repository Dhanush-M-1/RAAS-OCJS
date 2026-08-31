//package com.company;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        boolean ans = false;
        int l = 0;
        int r = 0;
        //System.out.println(s);
        for (int i=1;i<n;i++){
            if (s.charAt(i) < s.charAt(i-1)){
                ans = true;
                l = i;
                r = i+1;
                break;
            }
        }
        if (ans){
            System.out.println("YES");
            System.out.printf("%d %d", l, r);
        } else {
            System.out.println("NO");
        }
    }
}

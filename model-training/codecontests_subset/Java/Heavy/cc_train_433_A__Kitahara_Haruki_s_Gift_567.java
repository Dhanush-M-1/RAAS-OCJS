/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;

/**
 *
 * @author DELL
 */
public class main {

    public static void main(String args[]) throws IOException {
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(x.readLine());
        String s = x.readLine();
        String[] s1 = s.split(" ");

        int[] a = new int[n];
        int S = 0;
        int F = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
            if (a[i] == 100) {
                S++;
            } else {
                F++;
            }
        }
        if (S == 0 && F % 2 != 0) {
            System.out.println("NO");
        } 
        else if (S % 2 !=  0) {
            System.out.println("NO");
        }
        else System.out.println("YES");   

    }
}

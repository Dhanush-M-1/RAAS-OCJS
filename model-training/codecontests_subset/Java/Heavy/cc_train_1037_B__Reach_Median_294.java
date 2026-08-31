/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package pkg1037a;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Vessi
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, k;
        n = in.nextInt(); k = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = in.nextInt();
        Arrays.sort(a);
        // 1 2 5 5 8 10 14 -> 11
        
        int m = n / 2;
        long count1 = 0, count2 = 0;
        if (a[m] < k)
        for(int i = m; i < n && a[i] < k; i++)
            count1 += k - a[i];
        if (a[m] > k)
        for(int i = m; i >= 0 && a[i] > k; i--)
            count1 += a[i] - k;        
        System.out.println(count1);
    }
    
}

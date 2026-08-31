//package com.company.codeforces.div2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Daniil on 5/5/2016.
 */
public class Task2 {
    public static void main(String[] args) throws IOException {

        //Scanner scanner = new Scanner(new FileInputStream("file.in"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextInt();
        long[] arr = new long[n];
        for (int i =0 ;i < n; ++ i){
            arr[i] = scanner.nextInt();
        }

        long sum = 0;
        long res = 0;
        for (int i = 1; i <= n; ++ i){
            if (sum + (i) >= k){
                res = arr[(int)(k - sum - 1)];
                break;
            }

            sum += i;
        }
        System.out.println(res);
        scanner.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Practice_1100;

import java.io.*;

/**
 *
 * @author Akhilesh
 */
public class A1227 {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        
        int test = Integer.parseInt(scan.readLine().trim());
        
        test:
        while (test-- > 0) {
            int n = Integer.parseInt(scan.readLine().trim()), min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                String str[] = scan.readLine().split("\\s+");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                min = Math.min(min, b);
                max = Math.max(max, a);
            }
            
            System.out.println(max - min > 0 ? max - min : 0);
        }
    }    
}

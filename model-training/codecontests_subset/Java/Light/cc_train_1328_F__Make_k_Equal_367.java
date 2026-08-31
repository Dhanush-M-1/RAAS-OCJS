///package main;

import java.io.*;
import java.util.*;

public final class Main {
    Scanner sc;

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
    
    {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }
    
    void run() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[30][n];
        for(int i=0; i<n; i++)
            a[0][i] = sc.nextInt();
        
        for(int row=1; row<30; row++) {
            for(int col=0; col<n; col++) {
                if(a[row - 1][col] == 0) {
                    a[row][col] = -1;
                } else {
                    a[row][col] = a[row - 1][col] / 2;
                }
            }
        }
        
        int[] count = new int[200005];
        int[] costs = new int[200005];
        for(int i=0; i<30; i++) {
            for(int j=0; j<n; j++) {
                if(a[i][j] == -1)
                    continue;
                if(count[a[i][j]] == k)
                    continue;
                count[a[i][j]]++;
                costs[a[i][j]] += i;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<count.length; i++) {
            if(count[i] == k) {
                min = Math.min(min, costs[i]);
            }
        }
        
        System.out.println(min);
    }
}
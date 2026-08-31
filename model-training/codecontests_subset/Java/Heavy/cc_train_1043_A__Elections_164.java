//package codeforces.CF1043.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Solver solver = new Solver();

            int n = Integer.parseInt(br.readLine().trim());
            int[] input = new int[n];
            Scanner sc = new Scanner(br.readLine());
            for (int ii = 0; ii < n; ii++) {
                input[ii] = sc.nextInt();
            }
            solver.solve(n, input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Solver {

    public void solve(int n, int[] input) {
        int total = 0;
        int max = Integer.MIN_VALUE;
        for (int v : input) {
            total += v;
            max = v > max ? v : max;
        }
        int minTotal = total * 2 + 1;
        int k = Math.max(max, (int) Math.ceil(minTotal / (double) n));

        System.out.println(k);
    }

}

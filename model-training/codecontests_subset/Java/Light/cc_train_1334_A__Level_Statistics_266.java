//https://codeforces.com/contest/1334/problem/0

import java.io.PrintWriter;
import java.util.Scanner;

public class LevelStatistics {



    public static void main(String[] args) {
        // write your code here

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();

        while (t-- > 0){
            int n  = in.nextInt();
            int[][] stats= new int[n+1][2];
            stats[0][0] = 0;
            stats[0][1] = 0;
            for (int i = 1; i <=n; i++) {
                stats[i][0] = in.nextInt();
                stats[i][1] = in.nextInt();
            }
            boolean good = true;

            for (int i = 1; i <= n; i++) {
                int pp = stats[i-1][0], p= stats[i][0];
                int cc = stats[i-1][1], c = stats[i][1];
                if (c > p || c < cc || p < pp || p - pp < c - cc){
                    good = false;
                    break;
                }

//                    if (stats[i][1] > stats[i][0] || stats[i][1] < stats[i-1][1]
//                    || stats[i][0] < stats[i-1][0]
//                    || (stats[i][1] > stats[i-1][1] && stats[i][0] <= stats[i-1][0])){
//                        good =false;
//                        break;
//                    }
            }

            out.println(good ? "YES": "NO");

        }

        out.close();
    }
}

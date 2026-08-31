import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main (String[] args) throws IOException {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        int n = Integer.parseInt(br.readLine());
        Pair[] trees = new Pair[n];
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            String[] ih = br.readLine().split(" ");
            trees[i] = new Pair(Integer.parseInt(ih[0]), Integer.parseInt(ih[1]));
        }
        System.out.println(rec(0, Integer.MIN_VALUE, trees, dp));
    }

    static int rec(int ind, int prev, Pair[] trees, int dp[]) {
        if (ind < 0 || ind >= trees.length || prev >= trees[ind].ind) {
            return 0;
        }
        long temp = 0l;
        if (dp[ind] > 0) return dp[ind];
        if ((trees[ind].ind - trees[ind].height) > prev) {
            return dp[ind] = Math.max(1 + rec(ind + 1, trees[ind].ind, trees, dp),
                    Math.max(1 + rec(ind+1, trees[ind].ind + trees[ind].height, trees, dp),
                            rec(ind+1, trees[ind].ind, trees, dp)));
        }
        return dp[ind] = Math.max(1 + rec(ind+1, trees[ind].ind + trees[ind].height, trees, dp),
                rec(ind+1, trees[ind].ind, trees, dp));
    }

    static class Pair {
        int ind;
        int height;
        Pair(int l, int r) {
            ind = l;
            height = r;
        }
    }
}

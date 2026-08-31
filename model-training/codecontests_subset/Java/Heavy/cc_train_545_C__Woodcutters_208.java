import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] trees = new int[n][2];
        for (int i = 0; i < n; ++i) {
            trees[i][0] = scan.nextInt();
            trees[i][1] = scan.nextInt();
        }
        if (n == 1) {
            System.out.println(1);
        } else {
            int res = 2;
            for (int i = 1; i < n - 1; ++i) {
                int h = trees[i][1];
                int dxl = trees[i][0] - trees[i - 1][0];
                int dxr = trees[i + 1][0] - trees[i][0];
                if (h < dxl) {
                    res++;
                } else if (h < dxr) {
                    res++;
                    trees[i][0] += h;
                }
            }
            System.out.println(res);
        }
    }
}

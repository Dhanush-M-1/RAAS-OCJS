// package CF1107;

import java.io.*;
import java.util.*;

public class CF1107D {
    private static boolean solve(int n, boolean[][] nums, int x) {
        for (int i = 0; i < n / x; ++i) {
            for (int j = 0; j < n / x; ++j) {
                boolean cur = nums[i * x][j * x];
                for (int a = i * x; a < (i + 1) * x; ++a) {
                    for (int b = j * x; b < (j + 1) * x; ++b) {
                        if (nums[a][b] != cur) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

        String nStr = bi.readLine();
        int n = Integer.parseInt(nStr);

        ArrayList<String> nums = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String line = bi.readLine();
            nums.add(line);
        }

        boolean[][] numsBoolean = new boolean[n][n];
        for (int i = 0; i < nums.size(); ++i) {
            char[] chars = nums.get(i).toCharArray();
            for (int j = 0; j < chars.length; ++j) {
                int hex = Integer.parseInt(String.valueOf(chars[j]), 16);
                for (int k = 0; k < 4; ++k) {
                    numsBoolean[i][j*4 + k] = (hex & (1 << (3 - k))) > 0;
                }
            }
        }

        int res = 1;
        for (int i = n; i >= 2; --i) {
            if (n % i == 0) {
                boolean resCur = solve(n, numsBoolean, i);
                if (resCur) {
                    res = i;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
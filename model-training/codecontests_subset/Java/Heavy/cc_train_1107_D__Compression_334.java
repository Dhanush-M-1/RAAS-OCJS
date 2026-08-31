import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Q4 {
    public static void main (String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String take = in.readLine();
            for (int q = 0; q < (n/4); q++) {
                char c = take.charAt(n/4 - q - 1);
                int num = Integer.parseInt(c+"", 16);
                int j = 0;
                while (num > 0) {
                    arr[i][q*4 + j] = num%2 == 1;
                    j++;
                    num /= 2;
                }
            }

        }
        int hi = n;
        int lo = 1;
        int i;
        for (i = hi; i >= lo; i--) {
            if (pred(i, arr)) {
                break;
            }
        }
        System.out.println(i);
    }


    public static boolean pred(int x, boolean[][] arr) {
        if (arr.length % x != 0) return false;
        int passes = arr.length / x;
        for (int i = 0; i < passes; i++) {
            for (int j = 0; j < passes; j++) {
                if (!same(i*x, j*x, x, arr)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean same(int i, int j, int x, boolean[][] arr) {
        boolean b = arr[i][j];
        for (int r = i; r < i + x; r++) {
            for (int c = j; c < j + x; c++) {
                if (arr[r][c] != b) return false;
            }
        }
        return true;
    }

}

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class B {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        for (int t1 = 0; t1 < t; t1++) {
            int n = in.nextInt();
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.next().toCharArray();
            }
            pw.println(solve(arr, n));
        }

        pw.close();
    }

    static String solve(char[][] arr, int n) {
        int zero = 0;
        if (arr[0][1] == '0') zero++;
        if (arr[1][0] == '0') zero++;
        if (arr[n - 1][n - 2] == '0') zero++;
        if (arr[n - 2][n - 1] == '0') zero++;
        if (zero == 1) {
            if (arr[0][1] == '0') return "1\n" + 2 + " " + 1;
            if (arr[1][0] == '0') return "1\n" + 1 + " " + 2;
            if (arr[n - 1][n - 2] == '0') return "1\n" + (n - 1) + " " + n;
            if (arr[n - 2][n - 1] == '0') return "1\n" + n + " " + (n - 1);
        }
        if (zero == 2) {
            if (arr[0][1] == arr[1][0]) return "0";
            if (arr[0][1] == '0') {
                if (arr[n - 1][n - 2] == '1') return  "2\n" + 1 + " " + 2 + "\n" + n + " " + (n - 1);
                return "2\n" + 1 + " " + 2 + "\n" + (n - 1) + " " + n;
            }
            if (arr[n - 1][n - 2] == '1') return  "2\n" + 2 + " " + 1 + "\n" + n + " " + (n - 1);
            return "2\n" + 2 + " " + 1 + "\n" + (n - 1) + " " + n;
        }
        if (zero == 3) {
           if (arr[0][1] != arr[1][0]) {
               if (arr[0][1] == '0') return "1\n" + 1 + " " + 2;
               return "1\n" + 2 + " " + 1;
           }
           if (arr[n - 1][n - 2] == '0') return "1\n"+ n + " " + (n - 1);
           return "1\n" + (n  - 1) + " " + n;
        }
        return "2\n" + 1 + " " + 2 + "\n" + 2 + " " + 1;
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}
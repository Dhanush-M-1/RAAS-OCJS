import java.io.*;
import java.util.*;

public class Round676B2 {
    static int n;
    static char[][] mat;

    public static void main(String s[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            mat = new char[n][n];
            for (int i = 0; i < n; i++) {
                char[] c = (br.readLine()).toCharArray();
                for (int j = 0; j < n; j++)
                    mat[i][j] = c[j];
            }
            char a = mat[0][1], b = mat[1][0], c = mat[n - 1][n - 2], d = mat[n - 2][n - 1];
            if (a == b) {
                if (c == d) {
                    if (a != c)
                        System.out.println("0");
                    else {
                        System.out.println(2);
                        System.out.println("1 2\n2 1");
                    }
                } else {
                    if (c == a)
                        System.out.println("1\n" + (n) + " " + (n - 1));
                    else System.out.println("1\n" + (n - 1) + " " + n);
                }
            } else if (c == d) {
                if (a == c)
                    System.out.println("1\n" + 1 + " " + 2);
                else System.out.println("1\n" + 2 + " " + 1);
            } else {
                System.out.println("2");
                if (a == '1')
                    System.out.println("1 2");
                else System.out.println("2 1");
                if (c == '0')
                    System.out.println(n + " " + (n - 1));
                else System.out.println((n - 1) + " " + n);
            }
        }
    }
}

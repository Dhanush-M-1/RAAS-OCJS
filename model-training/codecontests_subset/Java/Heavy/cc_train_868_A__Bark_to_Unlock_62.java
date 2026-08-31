//package TIM;


import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;


public class Main {
    static Scanner input = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);


    public static void main(String[] args) throws IOException {
        char[] s = input.next().toCharArray();
        int n = input.nextInt();
        char[][] c = new char[105][105];
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            c[i] = input.next().toCharArray();
            if (c[i][0] == s[0] && c[i][1] == s[1]) flag = true;
        }
        for (int i = 0; i < n; i++) {
            if (c[i][1] == s[0]) {
                for (int j = 0; j < n; j++)
                    if (c[j][0] == s[1]) {
                        flag = true;
                        break;
                    }
            }
            if (flag) break;
        }
        System.out.println(flag ? "YES" : "NO");
    }
}

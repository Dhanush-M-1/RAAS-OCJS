/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.text.*;

public class cf284b {

    static BufferedReader br;
    static Scanner sc;
    static PrintWriter out;

    public static void initA() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            //br = new BufferedReader(new FileReader("input.txt"));
            sc = new Scanner(System.in);
            //out = new PrintWriter("output.txt");
            out = new PrintWriter(System.out);
        } catch (Exception e) {
        }
    }

    public static void initB() {
        try {

            br = new BufferedReader(new FileReader("input.txt"));
            sc = new Scanner(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");

        } catch (Exception e) {
        }
    }

    public static String getString() {
        try {
            return br.readLine();
        } catch (Exception e) {
        }
        return "";
    }

    public static Integer getInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
        }
        return 0;
    }

    public static Integer[] getIntArr() {
        try {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int n = temp.countTokens();
            Integer temp2[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                temp2[i] = Integer.parseInt(temp.nextToken());
            }
            return temp2;
        } catch (Exception e) {
        }
        return null;
    }

    public static Long[] getLongArr() {
        try {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int n = temp.countTokens();
            Long temp2[] = new Long[n];
            for (int i = 0; i < n; i++) {
                temp2[i] = Long.parseLong(temp.nextToken());
            }
            return temp2;
        } catch (Exception e) {
        }
        return null;
    }

    public static String[] getStringArr() {
        try {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int n = temp.countTokens();
            String temp2[] = new String[n];
            for (int i = 0; i < n; i++) {
                temp2[i] = (temp.nextToken());
            }
            return temp2;
        } catch (Exception e) {
        }
        return null;
    }

    public static int getMax(Integer[] ar) {
        int t = ar[0];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > t) {
                t = ar[i];
            }
        }
        return t;
    }

    public static void print(Object a) {
        out.println(a);
    }

    public static void print(String s, Object... a) {
        out.printf(s, a);
    }

    public static int nextInt() {
        return sc.nextInt();
    }

    public static double nextDouble() {
        return sc.nextDouble();
    }

    public static void main(String[] ar) {
        initA();
        solve();
        out.flush();
    }

    public static void solve() {
        int n = getInt();
        char j[] = getString().toCharArray();

        int k[] = new int[256];

        for (char c : j) {
            k[c]++;
        }

        if (k['I'] == 0) {
            int out = 0;
            for (int i = 0; i < n; i++) {
                if (j[i] == 'F') {
                    continue;
                }
                out++;
            }
            print(out);
        } else if (k['I'] == 1) {
            print(1);

        } else {
            print(0);
        }

    }
}

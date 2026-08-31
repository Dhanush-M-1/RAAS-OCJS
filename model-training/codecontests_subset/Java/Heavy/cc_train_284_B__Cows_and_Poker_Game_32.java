//package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class CodeForce {

    private static Scanner sc;

    private static void solve() throws IOException {
        int n = sc.nextInt();
        String s = sc.next();
        int in = 0, al = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                in++;
            } else {
                if (s.charAt(i) == 'A') {
                    al++;
                }
            }
        }
        int num;
        if (in > 1) {
            num = 0;
        } else {
            if (in == 0) {
                num = al;
            } else {
                num = 1;
            }
        }
        System.out.println(num);
    }

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        solve();
    }
}

class MyScanner {

    private StreamTokenizer st;
    private Scanner sc;

    public MyScanner(InputStream is) {
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(is)));
        sc = new Scanner(is);
    }

    public int nextInt() throws IOException {
        st.nextToken();
        return ((int) st.nval);
    }

    public double nextDouble() throws IOException {
        st.nextToken();
        return (st.nval);
    }

    public long nextLong() {
        return (sc.nextLong());
    }

    public String next() {
        return (sc.next());
    }

    public String nextLine() {
        return (sc.nextLine());
    }
}
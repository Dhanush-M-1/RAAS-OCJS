//package codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class CodeForces {

    public void solve(MyScanner sc, MyPrinter out) throws IOException {
        int n = sc.nextInt();
        int[][] m = new int[n][2];
        for (int i = 0; i < n; i++) {
            m[i][0] = sc.nextInt();
            m[i][1] = sc.nextInt();
        }
        int all = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && m[i][0] == m[j][1]) {
                    all++;
                }
            }
        }
        System.out.println(all);
    }

    public static void main(String[] args) throws IOException {
        CodeForces cf = new CodeForces();
        MyScanner sc = new MyScanner(System.in);
        MyPrinter out = new MyPrinter(System.out);
        cf.solve(sc, out);
        out.close();
    }
}

class MyScanner {

    private StreamTokenizer st;

    public MyScanner(InputStream is) {
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(is)));
    }

    public int nextInt() throws IOException {
        st.nextToken();
        return ((int) st.nval);
    }

    public double nextDouble() throws IOException {
        st.nextToken();
        return (st.nval);
    }

    public String nextString() throws IOException {
        st.nextToken();
        if (st.ttype == StreamTokenizer.TT_WORD) {
            return (st.sval);
        } else {
            return ("not found");
        }
    }
}

class MyPrinter {

    private BufferedWriter out;

    public MyPrinter(OutputStream os) {
        out = new BufferedWriter(new PrintWriter(os));
    }

    public void println(int i) throws IOException {
        out.write(Integer.toString(i));
        out.newLine();
    }

    public void println(double d) throws IOException {
        out.write(Double.toString(d));
        out.newLine();
    }

    public void println(long l) throws IOException {
        out.write(Long.toString(l));
        out.newLine();
    }

    public void println(String s) throws IOException {
        out.write(s);
        out.newLine();
    }

    public void println(char c) throws IOException {
        out.write(Character.toString(c));
        out.newLine();
    }

    public void print(int i) throws IOException {
        out.write(Integer.toString(i));
    }

    public void print(double d) throws IOException {
        out.write(Double.toString(d));
    }

    public void print(long l) throws IOException {
        out.write(Long.toString(l));
    }

    public void print(String s) throws IOException {
        out.write(s);
    }

    public void print(char c) throws IOException {
        out.write(Character.toString(c));
    }

    public void close() throws IOException {
        out.flush();
        out.close();
    }
}

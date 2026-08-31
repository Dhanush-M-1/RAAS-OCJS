import java.io.*;
import java.util.*;

public class Main {
    public void solve() {
        int q = ni();
        for (int i = 0; i < q; i++) {
            int l = ni();
            int r = ni();
            int d = ni();
            if ((l > d) || (r < d)) {
                write(d + "\n");
            } else {
                int k = r / d;
                if (k * d <= r) {
                    k++;
                }
                write(k * d + "\n");
            }
        }
    }






    public static void main(String[] args) {
        Main m = new Main();
        m.solve();
        try {
            m.out.close();
        } catch (IOException e) {}
    }

    BufferedReader in;
    BufferedWriter out;
    StringTokenizer tokenizer;
    public Main() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public String n() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(in.readLine());
            } catch (IOException e) {}
        }
        return tokenizer.nextToken();
    }
    public int ni() {
        return Integer.parseInt(n());
    }
    public void write(String s) {
        try {
            out.write(s);
        } catch (IOException e) {}
    }
}
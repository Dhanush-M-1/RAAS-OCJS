/*
* sdfsjfksdflsfs
* s
* sd* fsd
* */

import javafx.util.Pair;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Input in = new Input(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(in, out);
        out.close();
    }
}

class Input {
    public BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer;

    public Input(InputStream inputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        stringTokenizer = null;
    }

    public String nextString() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextString());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextString());
    }

}


class Task {
    private int[] aa1;
    private int[] bb1;
    private int[] cc1;
    private int[] aa2;
    private int[] bb2;
    private int[] cc2;

    private int[] TTT(String s) {
        int[] ans = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i) - 'a']++;
        }
        return ans;
    }

    private int kol(int[] x, int[] y) {
        int ans = 111111;
        for (int i = 0; i < 26; i++) {
            if (y[i] != 0) {
                ans = Math.min(ans, x[i] / y[i]);
            }
        }

        return ans;
    }

    private void res1(int[] a, String s, int kol) {
        for (int j = 0; j < s.length(); j++) {
            a[s.charAt(j) - 'a'] -= kol;
        }

        aa1 = a;
    }

    private void res2(int[] a, String s, int kol) {
        for (int j = 0; j < s.length(); j++) {
            a[s.charAt(j) - 'a'] -= kol;
        }

        aa2 = a;
    }

    private void print(String b, String c, int kolb, int kolc, PrintWriter out, int[] aa) {
        for (int i = 0; i < kolc; i++) {
            out.print(c);
        }
        for (int i = 0; i < kolb; i++) {
            out.print(b);
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < aa[i]; j++) {
                out.print((char) (i + 'a'));
            }
        }
    }

    public void solve(Input in, PrintWriter out) throws IOException {
        String a = in.nextString();
        String b = in.nextString();
        String c = in.nextString();


        int[] aa = TTT(a);
        int[] bb = TTT(b);
        int[] cc = TTT(c);

        int m = 0;
        int kolb = kol(aa, bb);
        int xb = 0;
        int xc = 0;

        for (int i = 0; i <= kolb; i++) {
            int x = 111111;
            for (int j = 0; j < 26; j++) {
                if (cc[j] != 0) {
                    x = Math.min((aa[j] - i * bb[j]) / cc[j], x);
                }
            }

            if (m < i + x) {
                m = i + x;
                xb = i;
                xc = x;
            }
        }

        for (int i = 0; i < xb; i++) {
            out.print(b);
        }
        for (int i = 0; i < xc; i++) {
            out.print(c);
        }
        for (int i = 0; i < 26; i++) {
            int y = aa[i] - xb * bb[i] - xc * cc[i];
            for (int j = 0; j < y; j++) {
                out.print((char) (i + 'a'));
            }
        }
    }
}
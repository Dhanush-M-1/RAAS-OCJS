import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class B implements Runnable {

    int[] f;

    private void solve() throws IOException {
        f = new int[13];
        f[1] = 31;
        f[2] = 28;
        f[3] = 31;
        f[4] = 30;
        f[5] = 31;
        f[6] = 30;
        f[7] = 31;
        f[8] = 31;
        f[9] = 30;
        f[10] = 31;
        f[11] = 30;
        f[12] = 31;

        String s = nextToken();

        HashMap<String, Integer> h = new HashMap<String, Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (i + 10 > s.length()) break;
            String check = s.substring(i, i + 10);
            if (valid(check)) {
                if (h.containsKey(check)) {
                    h.put(check, h.get(check) + 1);
                } else {
                    h.put(check, 1);
                }
            }
        }

        String res = "";
        int max = 0;
        for (String k : h.keySet()) {
            int cnt = h.get(k);
            if (cnt > max) {
                max = cnt;
                res = k;
            }
        }
        int c = 0;
        for (String k : h.keySet()) {
            int cnt = h.get(k);
            if (cnt == max) {
                c++;
            }
        }
        if (c > 1) {
            throw new RuntimeException();
        }
        pl(res);
    }

    private boolean valid(String s) {
        String[] f = s.split("[-]");
        if (f.length != 3)
            return false;

        if (f[0].contains("-") || f[0].equals(""))
            return false;
        if (f[1].contains("-") || f[1].equals(""))
            return false;
        if (f[2].contains("-") || f[2].equals(""))
            return false;

        int days = Integer.parseInt(f[0]);
        if (days < 10) {
            if (f[0].length() < 2)
                return false;
        }
        int months = Integer.parseInt(f[1]);
        if (months < 10) {
            if (f[1].length() < 2)
                return false;
        }
        int years = Integer.parseInt(f[2]);
        if (years != 2013 && years != 2014 && years != 2015) {
            return false;
        }
        if (months > 12 || months == 0)
            return false;
        if (days > this.f[months] || days == 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        new B().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new BufferedReader(
                    new InputStreamReader(System.in)));
            writer = new PrintWriter(System.out);
            tokenizer = null;
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    BigInteger nextBigInteger() throws IOException {
        return new BigInteger(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    void p(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.flush();
            writer.print(objects[i]);
            writer.flush();
        }
    }

    void pl(Object... objects) {
        p(objects);
        writer.flush();
        writer.println();
        writer.flush();
    }

    int cc;

    void pf() {
        writer.printf("Case #%d: ", ++cc);
        writer.flush();
    }

}
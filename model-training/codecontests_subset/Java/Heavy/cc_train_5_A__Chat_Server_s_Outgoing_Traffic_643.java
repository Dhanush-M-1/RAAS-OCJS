import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.*;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class TaskCF implements Runnable {
    private void solve() throws IOException {
        long res = 0;
        long cnt = 0;
        while (true) {
            String cmd = reader.readLine();
            if (cmd == null)
                break;
            if (cmd.charAt(0) == '+') {
                cnt++;
            } else if (cmd.charAt(0) == '-') {
                cnt--;
            } else {
                long len = cmd.length() - cmd.indexOf(':') - 1;
                res += len * cnt;
            }
        }
        writer.print(res);

    }

    public static void main(String[] args) {
        new TaskCF().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            writer = new PrintWriter(System.out);
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

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
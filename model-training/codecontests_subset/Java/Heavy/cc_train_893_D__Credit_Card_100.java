import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

import static java.lang.StrictMath.sqrt;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        static final int N = (int) 1e6 + 7;
                
        int max(int x, int y) {
          if (x < y) return y;
          return x;
        }        
                
        int[] a = new int[N];
        int[] p = new int[N];
        int[] s = new int[N];
        
        public void solve(int testNumber, InputReader in, PrintWriter out) {
          int n = in.nextInt(), d = in.nextInt();
          boolean valid = true;
          for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            p[i] = p[i - 1] + a[i];
            if (p[i] > d) {
              valid = false;
            }
          }
          s[n] = p[n];
          for (int i = n - 1; i >= 1; i--) {
            s[i] = max(p[i], s[i + 1]);
          }
          int cur = 0, ans = 0;
          for (int i = 1; i <= n; i++) {
            if (a[i] == 0 && p[i] + cur < 0) {
              ans++;
              int maxi = 0;
              cur += d - cur - s[i];
              if (p[i] + cur < 0) {
                valid = false;
              }
            }
          }
          if (!valid) ans = -1;
          out.print(ans);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        
    }
}
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author masterbios
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int a[] = new int[n];
            int one = 0;
            int two = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                sum += a[i];
                if (a[i] == 100) one++;
                else two++;
            }
            int x = 0;
            int y = 0;
//       out.println(sum);
            sum /= 100;
            if (sum % 2 == 0) {
                sum *= 100;
                if (two == 0 && one > 0) {
                    out.println("YES");
                } else if (two > 0 && one == 0) {
                    if (two % 2 == 0) {
                        out.println("YES");
                    } else {
                        out.println("NO");
                    }
                } else if (two > 0 && one > 0) {
                    int tempa = two / 2;
                    int tempb = two - tempa;
                    tempa *= 200;
                    tempb *= 200;
                    one *= 100;
                    if (tempa != sum / 2) {
                        int need = sum / 2 - tempa;
                        if (need <= one) one -= need;
                        tempa += need;
//                   out.println(need+" "+one);
                    }
                    if (tempb != sum / 2) {
                        int need = sum / 2 - tempb;
                        if (need <= one) one -= need;
                        tempb += need;
//                   out.println(need+" "+one);
                    }
//               System.err.println(tempa+" "+tempb);
                    if (tempa == tempb && tempb == sum / 2) {
                        out.println("YES");
                    } else {
                        out.println("NO");
                    }
                }
            } else {
                out.println("NO");
            }
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
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
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


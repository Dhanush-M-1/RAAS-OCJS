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
 * @author bhavy seth
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long l = sc.nextLong();
                long r = sc.nextLong();
                long count = 0;
                int start = 0;
                for (int i = 1; i <= n; i++) {
                    long x = Math.max(1, (n - i) * 2);
                    if (l <= count + x) {
                        start = i;
                        break;
                    } else {
                        count += x;
                    }
                }

        /*  if(l==count+1){
              out.print(start+" ");
              count++;
          }*/
                int curr = start;
                long incnt = 0;
                {
                    for (int i = 0; i < Math.max(2 * (n - start), 1); i++) {
                        count++;
                        incnt++;
                        if (incnt % 2 == 0) {
                            curr++;
                        }
                        if (count == l) {
                            break;
                        }
                    }
                    if (incnt % 2 == 0) {
                        for (int i = curr; i <= n; i++) {
                            if (count <= r) {
                                out.print(i + " ");
                                count++;
                            }
                            if (i == n)
                                break;
                            if (count <= r) {
                                out.print(start + " ");
                                count++;
                            }
                            if (count > r)
                                break;
                        }
                    } else {
                        for (int i = curr + 1; i <= n; i++) {
                            if (count <= r) {
                                out.print(start + " ");
                                count++;
                            }
                            if (count <= r) {
                                out.print(i + " ");
                                count++;
                            }
                            if (count > r)
                                break;
                        }
                    }

                    if (count < r) {
                        for (int i = start + 1; i < n; i++) {
                            for (int j = i + 1; j <= n; j++) {
                                if (count <= r) {
                                    out.print(i + " ");
                                    count++;
                                }
                                if (count <= r) {
                                    out.print(j + " ");
                                    count++;
                                }
                                if (count > r)
                                    break;
                            }
                            if (count > r)
                                break;
                        }

                    }
                    if (count <= r)
                        out.print(1);
                }

                out.println();
            }
        }

    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new
                    InputStreamReader(inputStream));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}


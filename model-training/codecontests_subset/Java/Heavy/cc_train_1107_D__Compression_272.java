import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by timur on 28.03.15.
 */

public class TaskD {
    boolean eof;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new TaskD().run();
    }

    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "-1";
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }


    void run() throws IOException {
        InputStream input = System.in;
        PrintStream output = System.out;
        try {
            File f = new File("a.in");
            if (f.exists() && f.canRead()) {
                input = new FileInputStream(f);
                output = new PrintStream("a.out");
            }
        } catch (Throwable e) {
        }
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);
        solve();
        br.close();
        out.close();
    }

    String cmpa(int a, int b) {
        if (a > b) {
            return "More ";
        } else if (a < b) {
            return "less ";
        } else
            return "Equals ";
    }

    String cmpq(int a, int b) {
        if (a >= b) {
            return "1 ";
        } else {
            return "0 ";
        }
    }

    void solve() {
        int n = nextInt();
        int[][] a = new int[n + 1][n + 1];
        String s;
        int x, k;
        for (int i = 0; i < n; i++) {
            s = nextToken();
            for (int j = 0; j < n; j += 4) {
                if ('0' <= s.charAt(j / 4) && s.charAt(j / 4) <= '9') {
                    x = s.charAt(j / 4) - '0';
                } else {
                    x = 10 + s.charAt(j / 4) - 'A';
                }

                k = 16;
                for (int l = 0; l < 4; l++) {
                    k /= 2;
                    a[i + 1][j + 1 + l] = a[i][j + 1 + l] + a[i + 1][j + l] - a[i][j + l];
                    if ((x & k) == k) {
                        a[i + 1][j + 1 + l] += 1;
                    }
                }
            }
        }
        //        for (int i = 0; i < n; i++) {
        //            for (int j = 0; j < n; j++) {
        //                out.print(a[i + 1][j + 1] + " ");
        //            }
        //            out.println();
        //        }

        int bex, enx, bey, eny, sum, dd;
        boolean ok;
        for (int div = n; div > 0; div--) {
            if (n % div == 0 && a[n][n] % (div * div) == 0) {
                dd = div * div;
                k = n / div;
                ok = true;
                for (int i = 0; i < k; i++) {
                    bex = i * div;
                    enx = i * div + div;
                    for (int j = 0; j < k; j++) {
                        bey = j * div;
                        eny = j * div + div;
                        sum = a[enx][eny] - a[enx][bey] - a[bex][eny] + a[bex][bey];
                        if (sum % dd != 0) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok)
                        break;
                }
                if (ok) {
                    out.print(div);
                    return;
                }
            }
        }
        out.print("1");
    }

}
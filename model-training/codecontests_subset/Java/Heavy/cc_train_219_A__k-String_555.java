import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        KString solver = new KString();
        solver.solve(1, in, out);
        out.close();
    }

    static class KString {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int k = in.nextInt();
            char[] a = in.next().toCharArray();

            int[] b = new int[26];
            for (char c : a) {
                b[c - 'a']++;
            }

            int[] c = new int[26];
            for (int i = 0; i < 26; i++) {
                if (b[i] != 0 && b[i] % k != 0) {
                    out.println(-1);
                    return;
                } else {
                    c[i] = b[i] / k;
                }
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < 26; j++) {
                    if (b[j] != 0) {
                        for (int l = 0; l < c[j]; l++) {
                            sb.append((char) (j + 'a'));
                            b[j]--;
                        }
                    }
                }
            }

            out.println(sb.toString());
        }

    }
}


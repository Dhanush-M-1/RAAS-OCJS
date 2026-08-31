import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class B {

    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[]a = next().toCharArray();
        char[]b = next().toCharArray();
        char[]c = next().toCharArray();
        int A = a.length;
        int B = b.length;
        int C = c.length;
        int x = 0, y = 0;
        int[]cnt_a = new int[26], cnt_b = new int[26], cnt_c = new int[26];
        for (int i = 0; i < A; i++) {
            cnt_a[a[i]-'a']++;
        }
        for (int i = 0; i < B; i++) {
            cnt_b[b[i]-'a']++;
        }
        for (int i = 0; i < C; i++) {
            cnt_c[c[i]-'a']++;
        }
        for (int i = 0; i <= 100000; i++) {
            int xx = i, yy = 1000000;
            boolean ok = true;
            for (int j = 0; j < 26; j++) {
                if ((long)i*cnt_b[j] > cnt_a[j]) {
                    ok = false;
                    break;
                }
                if (cnt_c[j] != 0)
                    yy = Math.min(yy, (cnt_a[j]-i*cnt_b[j]) / cnt_c[j]);
            }
            if (xx+yy > x+y && ok) {
                x = xx;
                y = yy;
            }
        }
        for (int i = 1; i <= x; i++) {
            pw.print(b);
            for (int j = 0; j < B; j++) {
                cnt_a[b[j]-'a']--;
            }
        }
        for (int i = 1; i <= y; i++) {
            pw.print(c);
            for (int j = 0; j < C; j++) {
                cnt_a[c[j]-'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= cnt_a[i]; j++) {
                pw.print((char)('a'+i));
            }
        }
        pw.close();
    }
    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    private static String next() throws IOException {
        while (st==null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}

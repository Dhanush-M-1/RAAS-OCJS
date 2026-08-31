
import java.io.*;
import java.util.*;

public class TaskA {
    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static InputReader sc = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);
    private static double contriA(double tot, double ta, double tb) {
        return tot * tb / (ta + tb);
    }
    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        List<Long> cha = new ArrayList<>();
        List<Long> chb = new ArrayList<>();
        List<Long> chc = new ArrayList<>();
        final long inf = (long) 1e18;
        cha.add(inf); chb.add(inf); chc.add(inf);
        for (int i = 0; i < n; i++) {
            if (a[i][1] == 1 && a[i][2] == 0) {
                cha.add((long) a[i][0]);
            } else if (a[i][1] == 0 && a[i][2] == 1) {
                chb.add((long) a[i][0]);
            } else if (a[i][1] == 1 && a[i][2] == 1) {
                chc.add((long) a[i][0]);
            }
        }
        cha.sort(Collections.reverseOrder());
        chb.sort(Collections.reverseOrder());
        chc.sort(Collections.reverseOrder());
        long ans = 0;
        boolean can = true;
        for (int i = 0; i < k; i++) {
            long op0 = cha.get(cha.size() - 1) + chb.get(chb.size() - 1);
            long op1 = chc.get(chc.size() - 1);
            if (Math.min(op0, op1) >= inf) {
                can = false;
                break;
            }
            if (op0 < op1) {
                ans += op0;
                cha.remove(cha.size() - 1);
                chb.remove(chb.size() - 1);
            } else {
                ans += op1;
                chc.remove(chc.size() - 1);
            }
        }
        if (!can) ans = -1;
        out.println(ans);
        out.close();
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

import java.util.*;
import java.io.*;

public class TaskC {
    private FastScanner in;
    private PrintWriter out;

    final int segNum = 500;

    public void solve() throws IOException {
        int n = in.nextInt(), k = in.nextInt(), b = in.nextInt(), a = in.nextInt(), q = in.nextInt();
        int[] aHelp = new int[segNum];
        int[] bHelp = new int[segNum];

        int[] number = new int[segNum * segNum];
        for (int i = 0; i < q; i++) {
            if (in.nextInt() == 1) {
                int d = in.nextInt() - 1;
                int an = in.nextInt();
                int curSeg = d / segNum;

                aHelp[curSeg] -= Math.min(number[d], a);
                bHelp[curSeg] -= Math.min(number[d], b);
                number[d] += an;
                aHelp[curSeg] += Math.min(number[d], a);
                bHelp[curSeg] += Math.min(number[d], b);
            } else {
                int dStart = in.nextInt() - 1;
                int dEnd = dStart + k - 1;
                int curSegStart = dStart / segNum;
                int curSegEnd = dEnd / segNum;
                int res = 0;

                for (int j = 0; j < curSegStart; j++) {
                    res += aHelp[j];
                }
                for (int j = curSegEnd + 1; j < segNum; j++) {
                    res += bHelp[j];
                }
                for (int j = curSegStart * segNum; j < dStart; j++) {
                    res += Math.min(number[j], a);
                }
                for (int j = dEnd + 1; j < curSegEnd * segNum + segNum; j++) {
                    res += Math.min(number[j], b);
                }
                out.println(res);
            }

        }
    }



    public void run() {
        try {
            in = new FastScanner();
            out = new PrintWriter(System.out);
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

    public static void main(String[] arg) {
        new TaskC().run();
    }
}
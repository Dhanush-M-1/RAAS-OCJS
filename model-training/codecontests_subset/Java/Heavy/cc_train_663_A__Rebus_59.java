import java.util.*;
import java.io.*;

public class TaskA {
    private FastScanner in;
    private PrintWriter out;

    public void solve() throws IOException {
        String line = in.nextLine();
        int val = Integer.valueOf(line.substring(line.indexOf("=") + 2));
        int cntPlus = 1, cntMinus = 0;

        for (char c : line.toCharArray()) {
            if (c == '+') {
                cntPlus++;
            }
            if (c == '-') {
                cntMinus++;
            }
        }

        if (cntMinus == 0 && cntPlus == 1) {
            out.println("Possible");
            out.println(val + " = " + val);
            return;
        }

        int minOk = cntMinus + val, maxOk = cntMinus * val + val;

        int minOkPlus = cntPlus, maxOkPlus = cntPlus * val;

        if (minOk > maxOkPlus || maxOk < minOkPlus) {
            out.println("Impossible");
            return;
        }
        out.println("Possible");

        int res = (minOkPlus <= minOk && minOk <= maxOkPlus) ? minOk : minOkPlus;
        int needPlus = res;
        int needMinus = res - val;

        int[] plusList = get(needPlus, cntPlus, val);
        int[] minusList = get(needMinus, cntMinus, val);

        int p1 = 1, p2 = 0;

        out.print(plusList[0]);
        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) == '?') {
                if (line.charAt(i - 2) == '-') {
                    out.print(minusList[p2]);
                    p2++;
                } else {
                    out.print(plusList[p1]);
                    p1++;
                }
            } else {
                out.print(line.charAt(i));
            }
        }

    }

    int[] get(int need, int cnt, int max) {
        if (cnt == 0) {
            return new int[0];
        }
        int[] res = new int[cnt];
        int avg = need / cnt;
        for (int i = 0; i < cnt; i++) {
            res[i] = avg;
        }
        for (int i = 0; i < need - avg * cnt; i++) {
            res[i]++;
        }
        return res;
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
        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] arg) {
        new TaskA().run();
    }
}
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE1 solver = new TaskE1();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE1 {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int n, k;
            n = in.nextInt();
            k = in.nextInt();
            List<Integer> alice = new ArrayList<>();
            List<Integer> bob = new ArrayList<>();

            List<Integer> timesBoth = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int t = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();
                if (a == b && a == 1) {
                    timesBoth.add(t);
                    continue;
                }
                if (a == 1) {
                    alice.add(t);
                }
                if (b == 1) {
                    bob.add(t);
                }
            }
            if (alice.size() + timesBoth.size() < k || bob.size() + timesBoth.size() < k) {
                out.println(-1);
            } else {
                Collections.sort(alice);
                Collections.sort(bob);
                int i = 0, j = 0;
                while (i < alice.size() && j < bob.size()) {
                    timesBoth.add(alice.get(i) + bob.get(i));
                    i++;
                    j++;
                }
                Collections.sort(timesBoth);
                long ans = 0;
                for (int i1 = 0; i1 < k; i1++) {
                    ans += timesBoth.get(i1);
                }
                out.println(ans);
            }
        }

    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner(InputStream io) {
            br = new BufferedReader(new InputStreamReader(io));
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

    }
}


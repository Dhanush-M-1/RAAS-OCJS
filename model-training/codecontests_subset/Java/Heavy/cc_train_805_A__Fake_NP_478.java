import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
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
            int l = in.ni();
            int r = in.ni();
            if (l == r) {
                if (l % 2 == 0)
                    out.println(l);
                else
                    out.println(find(l));
            } else {
                out.println(2);
            }
        }

        int find(int l) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            int sqrt = (int) Math.sqrt(l);
            for (int i = 2; i <= Math.sqrt(l); i++) {
                int count = 0;
                while (l % i == 0) {
                    count++;
                    l /= i;
                }
                hm.put(i, count);
            }
            if (l > 1)
                hm.put(l, 1);
            int max = 0;
            int num = 0;
            Iterator<Integer> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                int key = iterator.next();
                if (hm.get(key) > max) {
                    max = hm.get(key);
                    num = key;
                }
            }
            return num;
        }

    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String n() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public int ni() {
            return Integer.parseInt(n());
        }

    }
}


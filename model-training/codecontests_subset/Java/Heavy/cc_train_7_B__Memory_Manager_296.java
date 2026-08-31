import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CF7B {
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        int n = IN.nextInt(), max = IN.nextInt() - 1;
        LinkedList<int[]> list = new LinkedList<>();// st end id
        int id = 1;
        PrintWriter pr = new PrintWriter(System.out);
        while (n-- > 0) {
            String line = IN.readLine();
            if (line.charAt(0) == 'a') {
                String str[] = line.split(" ");
                int size = Integer.valueOf(str[1]);
                boolean ok = false;
                int pre = 0;
                for (int i = 0; i < list.size(); i++) {
                    int tmp[] = list.get(i);
                    if (tmp[0] - pre >= size && pre + size - 1 <= max) {
                        ok = true;
                        list.add(i, new int[] { pre, pre + size - 1, id });
                        break;
                    } else {
                        pre = tmp[1] + 1;
                    }
                }
                if (!ok) {
                    if (pre + size - 1 <= max) {
                        list.add(new int[] { pre, pre + size - 1, id });
                        ok = true;
                    }
                }
                if (ok) {
                    pr.println(id++);
                } else {
                    pr.println("NULL");
                }
            } else if (line.charAt(0) == 'e') {
                String str[] = line.split(" ");
                boolean ok = false;
                int eid = Integer.valueOf(str[1]);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i)[2] == eid) {
                        list.remove(i);
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    pr.println("ILLEGAL_ERASE_ARGUMENT");
                }
            } else {
                int pre = 0;
                for (int i = 0; i < list.size(); i++) {
                    int tmp[] = list.get(i);
                    int size = tmp[1] - tmp[0];
                    tmp[0] = pre;
                    tmp[1] = tmp[0] + size;
                    pre = tmp[1] + 1;
                }
            }
        }
        pr.flush();
    }

    static final class IN {

        private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st = null;

        public static String readLine() throws IOException {
            return br.readLine();
        }

        public static String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    break;
                }
            }
            return st.nextToken();
        }

        public static int nextInt() {
            return Integer.valueOf(next());
        }

        public static long nextLong() {
            return Long.valueOf(next());
        }

        public static void close() {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

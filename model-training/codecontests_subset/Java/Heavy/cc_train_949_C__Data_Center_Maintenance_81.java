import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.util.Vector;
import java.util.Stack;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * @author khokharnikunj8
 */

public class Main {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                new Main().solve();
            }
        }, "1", 1 << 26).start();
    }

    void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ProblemCDataCenterMaintenance solver = new ProblemCDataCenterMaintenance();
        solver.solve(1, in, out);
        out.close();
    }

    static class ProblemCDataCenterMaintenance {
        ArrayList<Integer>[] arrayList;
        ArrayList<Integer>[] arrayList1;
        ArrayList<Integer> ans;
        ArrayList<Integer>[] temp;
        boolean[] visited;
        Stack<Integer> st;
        int[] index;
        int ans_size = Integer.MAX_VALUE;
        int ans_index = -1;

        private void dfs1(int node) {
            visited[node] = true;
            for (int i : arrayList[node])
                if (!visited[i]) dfs1(i);
            st.push(node);
        }

        private void dfs2(int node, int currentIndex) {
            visited[node] = true;
            index[node] = currentIndex;
            temp[currentIndex].add(node);
            for (int i : arrayList1[node])
                if (!visited[i]) dfs2(i, currentIndex);
        }

        private void kojasaru(int n) {
            st = new Stack<>();
            visited = new boolean[n + 1];
            int currentIndex = 1;
            for (int i = 1; i <= n; i++) if (!visited[i]) dfs1(i);
            Arrays.fill(visited, false);
            while (!st.isEmpty()) {
                int tt = st.pop();
                if (!visited[tt]) dfs2(tt, currentIndex++);
            }
            boolean[] isSource = new boolean[currentIndex];
            for (int i = 1; i <= n; i++) for (int j : arrayList[i]) if (index[j] != index[i]) isSource[index[i]] = true;

            for (int i = 1; i < currentIndex; i++) {
                if (isSource[i]) continue;
                if (ans_size > temp[i].size()) {
                    ans_size = temp[i].size();
                    ans_index = i;
                }
            }
        }

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int m = in.scanInt();
            int h = in.scanInt();
            temp = new ArrayList[n + 1];
            arrayList = new ArrayList[n + 1];
            arrayList1 = new ArrayList[n + 1];
            index = new int[n + 1];
            ans = new ArrayList<>();
            int[] hours = new int[n + 1];
            for (int i = 0; i <= n; i++) arrayList[i] = new ArrayList<>();
            for (int i = 0; i <= n; i++) arrayList1[i] = new ArrayList<>();
            for (int i = 0; i <= n; i++) temp[i] = new ArrayList<>();
            for (int i = 1; i <= n; i++) hours[i] = in.scanInt();

            while (m-- > 0) {
                int c1 = in.scanInt();
                int c2 = in.scanInt();
                if ((hours[c1] + 1) % h == hours[c2]) {
                    arrayList[c1].add(c2);
                    arrayList1[c2].add(c1);
                }
                if ((hours[c2] + 1) % h == hours[c1]) {
                    arrayList[c2].add(c1);
                    arrayList1[c1].add(c2);
                }
            }
            kojasaru(n);
            out.println(ans_size);
            for (int i : temp[ans_index]) out.print(i + " ");

        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int index;
        private BufferedInputStream in;
        private int total;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (index >= total) {
                index = 0;
                try {
                    total = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (total <= 0) return -1;
            }
            return buf[index++];
        }

        public int scanInt() {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                }
            }
            return neg * integer;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}


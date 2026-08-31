import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.TreeSet;
import java.util.ArrayList;
import java.io.InputStream;
 

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class TaskE {
        TreeSet<Integer>[] set1;
        TreeSet<Integer> set2;
 
        int bfs(int i) {
            ArrayList<Integer> rem = new ArrayList<>();
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(i);
            rem.add(i);
            int cnt = 0;
            while (!q.isEmpty()) {
                int t = q.poll();
                for (int temp : set2) {
                    if (!set1[t].contains(temp)) {
                        q.add(temp);
                        rem.add(temp);
                    }
                }
                for (int temp : rem) {
                    set2.remove(temp);
                    cnt++;
                }
                rem.clear();
            }
            return cnt;
        }
 
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            set1 = new TreeSet[n + 1];
            set2 = new TreeSet<>();
            for (int i = 1; i <= n; i++) set1[i] = new TreeSet<>();
            for (int i = 0; i < m; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                set1[x].add(y);
                set1[y].add(x);
            }
 
            for (int i = 1; i <= n; i++) set2.add(i);
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) {
                if (set2.contains(i)) {
                    int count = bfs(i);
                    ans.add(count);
                }
            }
 
            out.println(ans.size());
            Collections.sort(ans);
            for (int temp : ans)
                out.print((temp - 1) + " ");
            out.println();
 
 
        }
 
    }
 
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
 
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
 
 
            return buf[curChar++];
        }
 
        public int nextInt() {
            int c = read();
 
            while (isSpaceChar(c))
                c = read();
 
            int sgn = 1;
 
            if (c == '-') {
                sgn = -1;
                c = read();
            }
 
            int res = 0;
 
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
 
                res *= 10;
                res += c & 15;
 
                c = read();
            } while (!isSpaceChar(c));
 
            return res * sgn;
        }
 
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
    }
}
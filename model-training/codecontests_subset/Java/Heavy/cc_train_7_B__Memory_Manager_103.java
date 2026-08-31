import java.io.*;
import java.util.*;

/**
 * @author def
 * @version 1.0
 */
public class B {

    public static void main(String[] args) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int t = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] mem = new int[m];
        int id = 0;
        while (t-- > 0) {
            st = new StringTokenizer(in.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("alloc")) {
                int n = Integer.parseInt(st.nextToken());
                boolean flag = false;
                int i = 0;
                while (i <= m - n && !flag) {
                    int j = 0;
                    while (j < n && mem[i + j] == 0) ++j;
                    if (j == n) {
                        flag = true;
                        ++id;
                        for (j = 0; j < n; ++j) {
                            mem[i + j] = id;
                        }
                    }
                    i += j + 1;
                }
                out.println(flag ? id : "NULL");
            } else if (cmd.equals("erase")) {
                int x = Integer.parseInt(st.nextToken());
                if (x > 0 && x <= id) {
                    int i = 0;
                    while (i < m && mem[i] != x) ++i;
                    if (i < m) {
                        while (i < m && mem[i] == x) {
                            mem[i++] = 0;
                        }
                    } else {
                        out.println("ILLEGAL_ERASE_ARGUMENT");
                    }
                } else {
                    out.println("ILLEGAL_ERASE_ARGUMENT");
                }
            } if (cmd.equals("defragment")) {
                int j = 0;
                while (j < m && mem[j] != 0) ++j;
                for (int i = j + 1; i < m; ++i) {
                    if (mem[i] != 0) {
                        mem[j++] = mem[i];
                        mem[i] = 0;
                    }
                }
            }
        }

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
/*
22 11
alloc 2
alloc 2
alloc 3
alloc 2
alloc 2
erase 2
erase 4
alloc 4
defragment
alloc 4
erase 5
alloc 2
erase 7
erase 3
erase -2
alloc 6
alloc 5
erase 1
erase 6
alloc 6
defragment
alloc 6
*/
import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;

    public String next() throws Exception {
        if (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(next());
    }
    public long nextLong() throws Exception {
        return Long.parseLong(next());
    }
    public double nextDouble() throws Exception {
        return Double.parseDouble(next());
    }

    public void run() throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int t = nextInt();
        int m = nextInt();
        String command = "";
        int n = 0, c = 1, cm = 0;
        int[] mem = new int[m];
        Arrays.fill(mem, 0);
        for (int i = 0; i < t; i++) {
            command = next();
            if (command.equals("alloc")) {
                n = nextInt();
                int free = 0, start = -1;
                for (int j = 0; j < m; j++) {
                    if (mem[j] == 0)
                        free++;
                    else
                        free = 0;
                    if (free == n) {
                        start = j - free + 1;
                        break;
                    }

                }
                if (start != -1) {
                    for (int j = start; j < start + free; j++)
                        mem[j] = c;
                    out.println(c);
                    c++;
                } else {
                    out.println("NULL");
                }
            } else if (command.equals("erase")) {
                n = nextInt();
                boolean f = false;
                for (int j = 0; j < m; j++) {
                    if (mem[j] == n && n != 0) {
                        mem[j] = 0;
                        f = true;
                    }
                }
                if (!f) out.println("ILLEGAL_ERASE_ARGUMENT");
            } else {
                int start = 0, end = 0;
                for (int j = 0; j < m; j++) {
                    if (mem[j] == 0) {
                        start = j;
                        end = j;
                        while(end < m && mem[end] == 0) end++;
                        if (end < m) {
                            for (int k = start; k < m; k++)
                                if (k + end - start < m)
                                    mem[k] = mem[k + end - start];
                            for (int k = m - (end - start); k < m; k++)
                                mem[k] = 0;
                        }
                        
                    }
                }
            }
            //out.println(Arrays.toString(mem));
        }
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}
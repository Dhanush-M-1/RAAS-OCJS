
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }


    static class TaskD {
        final int nmax = 1000005;
        int n, m;
        int p[] = new int[nmax];
        int viz[] = new int[nmax];
        int currCollor = 1;
        List<Integer> gf[] = new ArrayList[nmax];
        int color[] = new int[nmax];
        int init[] = new int[nmax];

        public void dfs(int node) {
            viz[node] = 1;
            color[node] = currCollor;
            for (int i = 0; i < gf[node].size(); ++i) {
                int vc = gf[node].get(i);
                if (viz[vc] == 0) {
                    dfs(vc);
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            for (int i = 1; i <= n; ++i) {
                gf[i] = new ArrayList<Integer>();
            }

            for (int i = 1; i <= n; ++i) {
                p[i] = in.nextInt();
                init[p[i]] = i;
                //System.out.println(p[i]);
            }
            for (int i = 1; i <= m; ++i) {
                Integer x, y;
                x = in.nextInt();
                y = in.nextInt();
                //out.println(x + " " + y);
                gf[x].add(y);
                gf[y].add(x);
            }

            for (int i = 1; i <= n; ++i) {
                if (viz[i] == 0) {
                    ++currCollor;
                    dfs(i);
                }
            }

            List<Integer> all[] = new ArrayList[nmax];
            for(int i=1; i<=currCollor; ++i){
                all[i] = new ArrayList<>();
            }
            for(int i=1; i<=n; ++i){
                all[ color[i] ].add(i);
            }
            for(int i=1; i<=currCollor; ++i){
                Collections.reverse(all[i]);
            }

            for(int i=n; i>=1; --i){
                int sz = all[ color[ init[i] ] ].size();
                p[ all[ color[init[i]]  ].get(sz-1)] = i;
                all[ color[init[i]] ].remove(sz-1);
            }

            for(int i=1; i<=n; ++i){
                out.print(p[i] + " ");
            }



        }


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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }

}
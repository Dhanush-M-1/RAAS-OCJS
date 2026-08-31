    import java.io.*;
    import java.util.*;

    public class Solution {
        StringTokenizer st;
        BufferedReader in;
        PrintWriter out;

        void solve() throws IOException {
            //in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "ISO-8859-1"));
            //out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "ISO-8859-1"));
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            Locale.setDefault(Locale.ENGLISH);

            int n = nextInt();
            int m = nextInt();

            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = nextInt();
            }

            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = nextInt() - 1;
            }


            boolean[] used = new boolean[n];
            int[][] a = new int[n][2];
            int pos = 0;
            for (int i = 0; i < m; i++) {
                if (!used[b[i]]) {
                    a[pos++] = new int[]{w[b[i]], b[i]};
                    used[b[i]] = true;
                }
            }

            int ans = 0;
            for (int i = 0; i < m; i++) {
                pos = 0;
                while (a[pos][1] != b[i]) {
                    ans += a[pos][0];
                    pos++;
                }

                int[] tmp = new int[]{a[pos][0], a[pos][1]};
                for (int j = pos; j > 0; j--) {
                    a[j] = a[j - 1];
                }
                a[0] = tmp;
            }

            out.print(ans);

            in.close();
            out.close();
        }

        public static void main(String[] args) throws IOException {
            new Solution().solve();
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
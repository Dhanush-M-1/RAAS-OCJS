
import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int g = 0; g < t; g++) {
            int n = in.nextInt();

            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.next();
            }

            if(s[0].charAt(1) == s[1].charAt(0)){
                if(s[n-2].charAt(n-1) == s[n-1].charAt(n-2)){
                    if(s[n-2].charAt(n-1) == s[0].charAt(1)){
                        out.println(2);
                        out.println((n-1) + " " + (n));
                        out.println((n) + " " + (n-1));
                    } else {
                        out.println(0);
                    }
                } else if(s[n-2].charAt(n-1) == s[0].charAt(1)){
                    out.println(1);
                    out.println((n-1) + " " + (n));
                } else if(s[n-1].charAt(n-2) == s[0].charAt(1)){
                    out.println(1);
                    out.println((n) + " " + (n-1));
                }
            } else if(s[n-2].charAt(n-1) == s[n-1].charAt(n-2)){
                if(s[n-2].charAt(n-1) == s[0].charAt(1)){
                    out.println(1);
                    out.println((1) + " " + (2));
                } else if(s[n-1].charAt(n-2) == s[1].charAt(0)){
                    out.println(1);
                    out.println((2) + " " + (1));
                }
            } else if(s[n-2].charAt(n-1) != s[n-1].charAt(n-2)){
                if(s[n-2].charAt(n-1) == s[0].charAt(1)){
                    out.println(2);
                    out.println((n) + " " + (n-1));
                    out.println((1) + " " + (2));
                } else if(s[n-1].charAt(n-2) == s[0].charAt(1)){
                    out.println(2);
                    out.println((n-1) + " " + (n));
                    out.println(1 + " " + 2);
                }
            }

        }


        out.flush();
    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }
}

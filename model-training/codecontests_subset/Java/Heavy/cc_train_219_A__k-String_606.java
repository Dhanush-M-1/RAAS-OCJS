import java.io.*;
import java.util.*;

public class Solution {

    private static void solve(InputReader in, OutputWriter out) {
        int k = in.nextInt();
        String s = in.next();

        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++)
            a[s.charAt(i) - 'a']++;

        if (s.length() % k != 0)
            out.print(-1);

        else {
            int n = s.length() / k;
            boolean possible = true;
            List<Character> ans = new ArrayList<Character>();

            for (int i = 0; i < a.length; i++)
                if (a[i] > 0) {
                    if (a[i] < k) {
                        possible = false;
                        break;

                    } else if (a[i] == k) {
                        ans.add((char) ('a' + i));
                        n--;

                    } else if (a[i] > k) {
                        if (a[i] % k != 0) {
                            possible = false;
                            break;

                        } else {
                            int times = a[i] / k;
                            n -= times;

                            for (int j = 0; j < times; j++)
                                ans.add((char) ('a' + i));
                        }
                    }
                }

            if (possible && n == 0) {
                s = "";
                for (Character c: ans)
                    s += c;

                for (int i = 0; i < k; i++)
                    out.print(s);

            } else
                out.print(-1);
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        solve(in, out);
        in.close();
        out.close();
    }

    private static class InputReader {

        private BufferedReader br;
        private StringTokenizer st;

        InputReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            st = null;
        }

        String nextLine() {
            String line = null;

            try {
                line = br.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return line;
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String line = nextLine();

                if (line == null)
                    return null;

                st = new StringTokenizer(line);
            }

            return st.nextToken();
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

        int[] nextIntArray(int n) {
            int[] a = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = nextInt();

            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];

            for (int i = 0; i < n; i++)
                a[i] = nextLong();

            return a;
        }

        void close() {
            try {
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class OutputWriter {

        BufferedWriter bw;

        OutputWriter(OutputStream os) {
            bw = new BufferedWriter(new OutputStreamWriter(os));
        }

        void print(int i) {
            print(Integer.toString(i));
        }

        void println(int i) {
            print(i);
            print('\n');
        }

        void print(long l) {
            print(Long.toString(l));
        }

        void println(long l) {
            print(l);
            print('\n');
        }

        void print(double d) {
            print(Double.toString(d));
        }

        void println(double d) {
            print(d);
            print('\n');
        }

        void print(boolean b) {
            print(Boolean.toString(b));
        }

        void println(boolean b) {
            print(b);
            print('\n');
        }

        void print(char c) {
            try {
                bw.write(c);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(char c) {
            print(c);
            print('\n');
        }

        void print(String s) {
            try {
                bw.write(s);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(String s) {
            print(s);
            print('\n');
        }

        void close() {
            try {
                bw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

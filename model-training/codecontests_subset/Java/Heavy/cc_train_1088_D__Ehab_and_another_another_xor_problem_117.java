import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(in, out);
        out.close();
    }

    static class Solution {
        int guess(int a, int b, FastScanner in, PrintWriter out) {
            out.println("? " + a + " " + b);
            out.flush();
            return in.nextInt();
        }
        public void solve(FastScanner in, PrintWriter out) {
            int a = 0, b = 0;

            int type = guess(0, 0, in, out);

            for (int i = 29; i >= 0; i--) {
                int aFlipped = guess(a | (1 << i), b, in, out);

                if (aFlipped == 1) {
                    // 1. a = 0xxx and b = 0yyy ?
                    // 2. a = 0xxx and b = 1yyy -1   xxx > yyy
                    // 3. a = 1xxx and b = 0yyy 1

                    int bFlipped = guess(a, b | (1 << i), in, out);

                    if (type == 0) {
                        continue;
                    }

                    if (bFlipped == -1) {
                        // must be case 1
                        continue;
                    } else if (bFlipped == 0) {
                        if (type == 1) {
                            a |= (1 << i);
                            type = 0;
                        } else if (type == -1) {
                            b |= (1 << i);
                            type = 0;
                        }
                    } else {
                        if (type == -1) {
                            b |= (1 << i);
                        } else if (type == 1) {
                            a |= (1 << i);
                        }

                        type = 1;
                    }
                } else if (aFlipped == 0) {
                    // 1. a = 0 and b = 1
                    // 2. a = 1 and b = 0

                    if (type == 1) {
                        a |= (1 << i);
                    } else {
                        b |= (1 << i);
                    }

                    type = 0;
                } else if (aFlipped == -1) {
                    // 1. a = 1xxx and b = 0yyy 1
                    // 2. a = 1xxx and b = 1yyy  ?     xxx < yyyy
                    // 3. a = 0xxx and b = 1yyy -1

                    int bFlipped = guess(a, b | (1 << i), in, out);

                    if (type == 0) {
                        a |= (1 << i);
                        b |= (1 << i);
                        continue;
                    }

                    if (bFlipped == 1) {
                        // must be case 2
                        a |= (1 << i);
                        b |= (1 << i);
                        continue;
                    } else if (bFlipped == 0) {
                        if (type == 1) {
                            a |= (1 << i);
                            type = 0;
                        } else if (type == -1) {
                            b |= (1 << i);
                            type = 0;
                        }
                    } else {
                        if (type == -1) {
                            b |= (1 << i);
                        } else if (type == 1) {
                            a |= (1 << i);
                        }

                        type = -1;
                    }
                }
            }

            out.println("! " + a + " " + b);
            out.flush();
        }
    }

    static class FastScanner {
        public BufferedReader br;
        public StringTokenizer st;

        public FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    public static void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long l = in.nextLong();
            long r = in.nextLong();
            long acc = 0;
            for (int i = 1; i <= n; ++i) {
//                System.out.println(acc);
                long currAcc = (n-i)*2;
                if (acc + currAcc < l) {
                    acc += currAcc;
                    continue;
                } else if (l > acc) {
                    long start = l - acc;
                    if (start % 2 == 0) {
                        out.print(start / 2 + i);
                        out.print(' ');
                        start++;
                    }
                    long end = r - acc;
                    while (start <= currAcc && start <= end) {
                        out.print(i);
                        out.print(' ');
                        start++;
                        if (start <= end) {
                            out.print(start / 2 + i);
                            out.print(' ');
                            start++;
                        }
                    }
                    acc += currAcc;
                    continue;
                } else if (acc + currAcc < r) {
                    long start = 1;
                    while (start <= currAcc) {
                        out.print(i);
                        out.print(' ');
                        start++;
                        if (start <= currAcc) {
                            out.print(start / 2 + i);
                            out.print(' ');
                            start++;
                        }
                    }
                    acc += currAcc;
                    continue;
                } else if (r >= acc) {
                    long start = 1;
                    long end = r - acc;
                    while (start <= end) {
                        out.print(i);
                        out.print(' ');
                        start++;
                        if (start <= end) {
                            out.print(start / 2 + i);
                            out.print(' ');
                            start++;
                        }
                    }
                    acc += currAcc;
                    break;
                } else break;
            }
            if (r == n*(n-1)+1) {
                out.print(1);
            }
            out.println();
        }
    }

//    int[] a = new int[n];
//    int[] p = new int[n];
//        for (int i = 0; i < n; ++i) {
//        a[i] = in.nextInt();
//    }
//        for (int i = 0; i < n; ++i) {
//        p[i] = in.nextInt();
//    }
//    int m = in.nextInt();
//    int[] b = new int[m];
//        for (int i = 0; i < m; ++i) {
//        b[i] = in.nextInt();
//    }

//    public static void solve(InputReader in, PrintWriter out) {
//        int t = in.nextInt();
//        while(t-- > 0) {
//            int n = in.nextInt();
//            long x = in.nextLong();
//            List<Pair> p = new ArrayList<>(n);
//            Pair min = new Pair(Long.MAX_VALUE, Long.MAX_VALUE);
//            int index = -1;
//            for (int i = 0; i < n; ++i) {
//                Pair pair = new Pair(in.nextLong(), in.nextLong());
//                p.add(pair);
//                if (pair.compareTo(min) < 0) {
//                    min = pair;
//                    index = i;
//                }
//            }
//        }
//    }

    static class Pair implements Comparable<Pair> {
        long a;
        long b;

        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            int compare = Long.compare(this.a, o.a);
            if (compare == 0) {
                compare = Long.compare(this.b, o.b);
            }
            return compare;
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

        public void skip() {
            tokenizer = null;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        if (n == 4 || m < n + 1) {
            out.println(-1);
        } else {
            show(new int[]{a, b, c, d}, n, out);
            out.println();
            show(new int[]{c, d, a, b}, n, out);
        }

        out.flush();
        in.close();
        out.close();
    }

    private static void show(int[] a, int n, PrintWriter out) {
        out.print(a[0]);
        out.print(' ');

        out.print(a[2]);
        out.print(' ');

        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                if (a[j] == i) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                out.print(i);
                out.print(' ');
            }
        }

        out.print(a[3]);
        out.print(' ');

        out.print(a[1]);
        out.print(' ');
    }


    private static class Node implements Comparable<Node> {
        int value;
        int count;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            int rc = Integer.compare(this.count, o.count);
            if (rc != 0) {
                return rc;
            } else {
                return -Integer.compare(this.value, o.value);
            }
        }
    }

    static class Reader {
        BufferedReader reader;
        StringTokenizer st;

        Reader(InputStreamReader stream) {
            reader = new BufferedReader(stream);
            st = null;
        }

        void close() throws IOException {
            reader.close();
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}
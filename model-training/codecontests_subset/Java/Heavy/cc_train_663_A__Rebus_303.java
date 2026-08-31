import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String s = in.nextLine();
        String[] a = s.split(" ");

        int len = (a.length - 1) / 2;
        int n = Integer.parseInt(a[a.length - 1]);
        int[] ans = new int[len];
        int[] mark = new int[len];

        ans[0] = 1;
        mark[0] = 1;
        int countPlus = 1;
        int countSub = 0;
        for (int i = 1; i < len; i++) {
            int pos = i * 2 - 1;
            ans[i] = 1;
            boolean plus = a[pos].equals("+");
            if (plus) {
                countPlus++;
            } else {
                countSub++;
            }
            mark[i] = plus ? 1 : -1;
        }

        int max = n * countPlus - countSub;
        int min = countPlus - n * countSub;

        if (n < min || n > max) {
            out.println("Impossible");
        } else if (countPlus > countSub) {
            out.println("Possible");
            int val = (n * countSub + n) / (countPlus);
            int remain = (n * countSub + n) % (countPlus);

            int now = val;
            if (remain != 0) {
                now++;
                remain--;
            }
            out.print(now);
            for (int i = 1; i < len; i++) {
                if (mark[i] == 1) {
                    now = val;
                    if (remain != 0) {
                        now++;
                        remain--;
                    }
                    out.print(" + " + now);
                } else {
                    out.print(" - " + n);
                }
            }
            out.print(" = " + n);
        } else {
            out.println("Possible");
            int val = (n * countPlus - n) / countSub;
            int remain = (n * countPlus - n) % countSub;

            out.print(n);
            for (int i = 1; i < len; i++) {
                if (mark[i] == -1) {
                    int now = val;
                    if (remain != 0) {
                        now++;
                        remain--;
                    }
                    out.print(" - " + now);
                } else {
                    out.print(" + " + n);
                }
            }
            out.print(" = " + n);
        }

        out.flush();
        in.close();
        out.close();
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
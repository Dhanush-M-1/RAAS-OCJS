import java.io.*;
import java.util.StringTokenizer;
// نورت الكود يا كبير اتفضل

// يا رب Accepted
public class MinimumInteger {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = in.nextInt();
        while (t-- > 0) {
            double l = in.nextInt();
            double r = in.nextInt();
            double d = in.nextInt();
            int x;
            if (d < l)
                out.println((int) d);
            else if (r % d != 0) {
                out.println((int) ((int) Math.ceil(r / d) * d));
            } else
                out.println((int) ((int) ((r / d) + 1) * d));
        }

        out.close();
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
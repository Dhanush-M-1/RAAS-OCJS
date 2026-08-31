import java.io.*;
import java.util.StringTokenizer;

public class TaskD {

    long mod = 998244353;

    long pow(long a, long b) {
        long c = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                c = (c * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return c;
    }

    void run() {
        FastReader in = new FastReader(System.in);
//        FastReader in = new FastReader(new FileInputStream("input.txt"));
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));


        int n = in.nextInt();

        int[][] a = new int[n][10];
        int[] lens = new int[11];

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();

            int j = 0;
            while (x > 0) {
                a[i][j] = x % 10;
                x /= 10;
                j++;
            }
            lens[j]++;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (a[i][j] == 0) continue;
                for (int k = 1; k < 11; k++) {
                    if (lens[k] == 0) continue;
                    int p1 = j + Math.min(j, k);
                    ans = (ans + a[i][j] * lens[k] * pow(10, p1) % mod) % mod;

                    int p2 = j + Math.min(j + 1, k);
                    ans = (ans + a[i][j] * lens[k] * pow(10, p2) % mod) % mod;
                }
            }
        }

        out.println(ans);




        out.close();
    }

    class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(nextLine());

            return st.nextToken();
        }

        String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
    }


    public static void main(String[] args) {
        new TaskD().run();
    }
}

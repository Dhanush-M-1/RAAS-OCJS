import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class B {
    String fileName = "<name>";

    public void solve() throws IOException {
        int n = nextInt();
        long k = nextLong();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        long l = 0;
        long r = n + 1;
        while (r - l > 1) {
            long m = (r + l) / 2;
            if (m * (m + 1) / 2 < k) {
                l = m;
            } else {
                r = m;
            }
        }
        long groupNumber = l;
        k -= groupNumber * (groupNumber + 1) / 2;
        out.print(a[(int)(k-1)]);
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new B().run();
    }
}
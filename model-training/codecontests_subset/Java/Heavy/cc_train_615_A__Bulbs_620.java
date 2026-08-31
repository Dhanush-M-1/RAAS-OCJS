import java.io.*;
import java.util.*;

public class cf338_a {
    private final boolean fileInput = false;
    private final String fileName = "";

    public void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int k = 0;
        int []a = new int[m];
        for (int i = 0; i < n; i++) {
            k = nextInt();
            for (int j = 0; j < k; j++) {
                a[nextInt() - 1]++;
            }
        }
        boolean can = true;
        for (int i = 0; i < m; i++) {
            if (a[i] == 0){
                can = false;
            }
        }
        if (can) {
            out.print("YES");
        } else {
            out.print("NO");
        }
    }

    public void run() throws IOException {
        try {
            if (fileInput) {
                br = new BufferedReader(new FileReader(new File(fileName + ".in")));
                out = new PrintWriter(fileName + ".out");
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            }
            solve();
            br.close();
            out.close();
        } catch (IOException e) {

        }

    }

    public static void main(String[] args) throws IOException {
        new cf338_a().run();
    }

    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            try {
                in = new StringTokenizer(br.readLine());
            } catch (IOException | NullPointerException e) {
                throw new IOException();
            }
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

    public void log(String s) {
        System.out.print(s);
    }

    public void logln(String s) {
        System.out.println(s);
    }
}
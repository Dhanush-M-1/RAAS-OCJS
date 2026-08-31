import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int x[] = new int[n + 1];
        int h[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = fr.nextInt();
            h[i] = fr.nextInt();
        }
        int dp[][] = new int[n + 1][3]; // 0 = don't cut, 1 = cut on left, 2 = cut on right
        x[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            if (x[i - 1] + h[i - 1] < x[i]) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][2]);
            }
            if (x[i] - h[i] > x[i - 1]) {
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                if (x[i - 1] + h[i - 1] < x[i] - h[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[i - 1][2]);
                }
                dp[i][1]++;
            }
            dp[i][2] = 1 + dp[i][0];
        }
        fw.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
    }

}


class FastReader {
    public FastReader() {
    }

    public FastReader(String fileName) throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(fileName));
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String nextString() throws IOException {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextString());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextString());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextString());
    }
}

class FastWriter {
    public FastWriter() {
    }

    public FastWriter(String fileName) throws IOException {
        this.bw = new BufferedWriter(new FileWriter(fileName));
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void print(Object o) throws IOException {
        bw.write(o.toString());
        bw.flush();
    }

    void println(Object o) throws IOException {
        print(o.toString() + "\n");
    }

    void printSp(Object o) throws IOException {
        print(o.toString() + " ");
    }
}
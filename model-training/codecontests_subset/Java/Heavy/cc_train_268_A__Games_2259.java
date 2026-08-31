import java.io.*;
import java.util.*;

public class Main implements Runnable {

    public final String TASKNAME = "";
    public final boolean CONSOLE = true;

    public static void main(String[] args) {
        new Thread(new Main()).start();
    }

    BufferedReader br;
    PrintWriter out;
    StringTokenizer in;

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

    private void solve() throws IOException {
        int n = nextInt();

        int[][] array = new int[n][2];

        for (int i = 0; i < n; i++) {
            array[i][0] = nextInt();
            array[i][1] = nextInt();
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && array[i][0] == array[j][1]) {
                    result++;
                }
            }
        }

        out.print(result);
    }

    public void run() {
        try {
            if (CONSOLE) {
                br = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                br = new BufferedReader(new FileReader(new File(TASKNAME + ".in")));
                out = new PrintWriter(new File(TASKNAME + ".out"));
            }

            solve();

            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}

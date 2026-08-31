import java.io.*;

public class ProblemA {

    private StreamTokenizer in;
    private PrintWriter out;

    public ProblemA(StreamTokenizer in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    private String next() throws IOException {
        in.nextToken();
        return in.sval;
    }

    private int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        var in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        var out = new PrintWriter(new OutputStreamWriter(System.out));
        new ProblemA(in, out).solve();
        out.flush();
        out.close();
    }

    private int T;

    private void solve() throws IOException {
        T = nextInt();

        for (int i = 0; i < T; i++) {
            int n = nextInt();
            long a = 0, b = 0, c = 0;
            for (int j = 0; j < n; j++) {
                int curr = nextInt();
                if (j == 0) {
                    a = curr;
                }else if (j == 1) {
                    b = curr;
                } else if (j == n-1) {
                    c = curr;
                }
            }
            if (a + b <= c) {
                out.println("1 2 " + (n));
            } else {
                out.println(-1);
            }
        }
    }
}

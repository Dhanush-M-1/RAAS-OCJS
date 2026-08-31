import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; // System.out is a PrintWriter
// import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
// import java.util.ArrayList;
// import java.util.Collections;    //  for ArrayList sorting mainly
// import java.util.HashMap;
// import java.util.hashset;
// import java.util.Random;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        FastScanner scn = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int tc = scn.nextInt();
        while (tc-- > 0) {
            int N = scn.nextInt();
            char[][] arr = new char[N][];
            for (int i = 0; i < N; i++) {
                arr[i] = scn.next().toCharArray();
            }
            if (arr[0][1] == arr[1][0] && arr[(N - 2)][(N - 1)] == arr[(N - 1)][(N - 2)]
                    && arr[(N - 1)][(N - 2)] == arr[0][1]) {
                out.println(2);
                out.println(N + " " + (N - 1));
                out.println((N - 1) + " " + N);
            } else if (arr[0][1] == arr[1][0] && arr[(N - 2)][(N - 1)] == arr[(N - 1)][(N - 2)]) {
                out.println(0);
            } else if (arr[0][1] == arr[1][0]) {
                if (arr[(N - 1)][(N - 2)] == arr[0][1]) {
                    out.println(1);
                    out.println(N + " " + (N - 1));
                } else {
                    out.println(1);
                    out.println((N - 1) + " " + N);
                }

            } else if (arr[(N - 1)][(N - 2)] == arr[(N - 2)][(N - 1)]) {
                if (arr[(N - 1)][(N - 2)] == arr[0][1]) {
                    out.println(1);
                    out.println(1 + " " + 2);
                } else {
                    out.println(1);
                    out.println(2 + " " + 1);
                }
            } else {
                if (arr[(N - 1)][(N - 2)] == arr[0][1]) {
                    out.println(2);
                    out.println(N + " " + (N - 1));
                    out.println(2 + " " + 1);
                } else {
                    out.println(2);
                    out.println(N + " " + (N - 1));
                    out.println(1 + " " + 2);
                }
            }
        }
        out.close();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.st = new StringTokenizer("");
        }

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            if (st.hasMoreTokens()) {
                return st.nextToken("").trim();
            }
            try {
                return br.readLine().trim();
            } catch (IOException err) {
                err.printStackTrace();
            }
            return "";
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

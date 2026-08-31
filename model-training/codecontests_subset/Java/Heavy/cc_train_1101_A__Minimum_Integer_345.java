import java.io.*;
import java.util.*;

public class Sirius {
    static BufferedReader br;
    static StringTokenizer st = new StringTokenizer("");

    static int nextInt() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int l = nextInt();
            int r = nextInt();
            int d = nextInt();
            if (d >= l && d <= r) {
                out.println(r / d * d + d);
            } else {
                out.println(d);
            }
        }
        out.close();
    }
}

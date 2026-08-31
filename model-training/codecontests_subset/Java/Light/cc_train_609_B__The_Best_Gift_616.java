import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            t -= 1;
            a[t] += 1;
        }
        long answer = 0;
        for (int i = 0; i < m; i++) {
            long tmp = 0;
            for (int k = i + 1; k < m; k++) {
                tmp += a[k];
            }
            answer += a[i] * tmp;
        }
        out.println(answer);
        out.close();

    }

    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;


        public MyScanner(InputStream isr) {
            br = new BufferedReader(new InputStreamReader(isr));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}



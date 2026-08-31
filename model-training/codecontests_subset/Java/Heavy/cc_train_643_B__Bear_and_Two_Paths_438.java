import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by n on 08.05.2016.
 */
public class D673 {

    public static void main(String[] args) {

        MyScanner in = new MyScanner();
        int n = in.nextInt();
        int k = in.nextInt();

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        if ((n > 4) && (k > n)) {
            System.out.print(a + " " + c + " ");
            for (int i = 1; i <= n; i++) {
                if ((i != a) && (i != b) && (i != c) && (i != d)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println(d + " " + b);

            System.out.print(c + " " + a + " ");
            for (int i = 1; i <= n; i++) {
                if ((i != a) && (i != b) && (i != c) && (i != d)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println(b + " " + d);
        } else System.out.println(-1);

    }


    private static class MyScanner {


        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
    }
}

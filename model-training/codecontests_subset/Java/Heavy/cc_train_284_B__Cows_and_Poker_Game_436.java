
import java.io.*;
import java.util.*;

public class B {

    public void solve() throws Exception {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String s = in.next();
        int A = 0;
        int I = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') {
                A++;
            } else if (s.charAt(i) == 'I') {
                I++;
            }
        }

        if (I == 0) {
            System.out.println(A);
        } else if (I == 1) {
            System.out.println(I);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws Exception {
        new B().solve();
    }

    class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner(InputStream input) {
            br = new BufferedReader(new InputStreamReader(input));
            st = null;
        }

        public Scanner(FileReader input) {
            br = new BufferedReader(input);
            st = null;
        }

        public String next() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws Exception {
            return br.readLine();
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        public long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        public double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }

        public boolean hasNextLine() throws Exception {
            if (br.ready()) {
                return true;
            }
            return false;
        }
    }
}

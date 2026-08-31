import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int k = in.nextInt();
        String s = in.next();
        if (k == 1) {
            System.out.println(s);
            return;
        }
        String ans = "";
        for (char c = 'a'; c <= 'z'; c++) {
            int occ = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    occ++;
                }
            }
            if (occ == 0) {
                continue;
            }
            if (occ % k == 0) {
                for (int i = 0; i < occ / k; i++) {
                    ans += c;
                }
            } else {
                System.out.println(-1);
                return;
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(ans);
        }
    }


}



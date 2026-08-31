import java.util.*;
import java.io.*;

public class B676 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char [][] grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next().toCharArray();
            }
            if (grid[0][1] == grid[1][0] && grid[n - 1][n - 2] == grid[n - 2][n - 1] && grid[0][1] != grid[n - 1][n - 2]) {
                out.println(0);
            } else if (grid[0][1] == grid[1][0] && grid[n - 1][n - 2] == grid[n - 2][n - 1]) {
                out.println(2);
                out.println(1 + " " + 2);
                out.println(2 + " " + 1);
            } else if (grid[0][1] == grid[1][0]) {
                out.println(1);
                if (grid[0][1] == grid[n - 1][n - 2]) {
                    out.println(n + " " + (n - 1));
                } else {
                    out.println((n - 1) + " " + (n));
                }
            } else if (grid[n - 1][n - 2] == grid[n - 2][n - 1]) {
                out.println(1);
                if (grid[0][1] == grid[n - 1][n - 2]) {
                    out.println(1 + " " + (2));
                } else {
                    out.println((2) + " " + (1));
                }
            } else {
                out.println(2);
                if (grid[0][1] == '0') {
                    out.println(1 + " " + 2);
                } else {
                    out.println(2 + " " + 1);
                }

                if (grid[n - 1][n - 2] == '1') {
                    out.println(n + " " + (n - 1));
                } else {
                    out.println((n - 1) + " " + n);
                }
            }
        }
        out.close();
    }


    //-----------MyScanner class for faster input----------
    public static class MyScanner {
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

}
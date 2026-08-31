import java.io.*;
import java.util.*;

public class RaifRound {

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {

            while (st == null || !st.hasMoreTokens()) {
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

    public static void main(String args[]) {
        FastReader scn = new FastReader();
        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();

            char ch1 = scn.next().charAt(1);
            String str = scn.next();
            char ch2 = str.charAt(0);
            char ch3 = '0';
            char ch4 = '0';
            if (n == 3) {
                ch3 = str.charAt(n - 1);
                ch4 = scn.next().charAt(n - 2);
            } else {
                for (int i = 2; i < n - 2; i++) {
                    scn.next();
                }
                ch3 = scn.next().charAt(n - 1);
                ch4 = scn.next().charAt(n - 2);
            }

            if (ch1 == '0' && ch2 == '0') {
                if (ch3 == '0' && ch4 == '0') {
                    System.out.println("2");
                    System.out.println("1 2");
                    System.out.println("2 1");
                } else if (ch3 == '0' && ch4 == '1') {
                    System.out.println("1");
                    System.out.println((n - 1) + " " + n);
                } else if (ch3 == '1' && ch4 == '0') {
                    System.out.println("1");
                    System.out.println(n + " " + (n - 1));
                } else if (ch3 == '1' && ch4 == '1') {
                    System.out.println("0");
                }
            } else if (ch1 == '0' && ch2 == '1') {
                if (ch3 == '0' && ch4 == '0') {
                    System.out.println("1");
                    System.out.println("1 2");
                } else if (ch3 == '0' && ch4 == '1') {
                    System.out.println("2");
                    System.out.println("2 1");
                    System.out.println((n - 1) + " " + n);

                } else if (ch3 == '1' && ch4 == '0') {
                    System.out.println("2");
                    System.out.println("2 1");
                    System.out.println((n) + " " + (n - 1));
                } else if (ch3 == '1' && ch4 == '1') {
                    System.out.println("1");
                    System.out.println("2 1");
                }
            } else if (ch1 == '1' && ch2 == '0') {
                if (ch3 == '0' && ch4 == '0') {
                    System.out.println("1");
                    System.out.println("2 1");
                } else if (ch3 == '0' && ch4 == '1') {
                    System.out.println("2");
                    System.out.println("2 1");
                    System.out.println((n) + " " + (n - 1));

                } else if (ch3 == '1' && ch4 == '0') {
                    System.out.println("2");
                    System.out.println("2 1");
                    System.out.println((n -1) + " " + (n));
                } else if (ch3 == '1' && ch4 == '1') {
                    System.out.println("1");
                    System.out.println("1 2");
                }
            } else if (ch1 == '1' && ch2 == '1') {
                if (ch3 == '0' && ch4 == '0') {
                    System.out.println("0");
                } else if (ch3 == '0' && ch4 == '1') {
                    System.out.println("1");
                    System.out.println((n) + " " + (n - 1));
                } else if (ch3 == '1' && ch4 == '0') {
                     System.out.println("1");
                     System.out.println((n -1) + " " + (n));
                } else if (ch3 == '1' && ch4 == '1') {
                    System.out.println("2");
                    System.out.println("1 2");
                    System.out.println("2 1");
                }
            }

        }
    }
}

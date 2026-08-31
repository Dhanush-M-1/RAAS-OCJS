import java.io.*;
import java.util.*;

public class Codeforces {
    public static void main(String[] args) throws Exception {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        String given = in.nextLine();
        char gstarts = given.charAt(0), gends = given.charAt(1);

        int num = Integer.parseInt(in.nextLine().trim());
        String[] arr = new String[num];

        for (int idx = 0; idx < num; idx++) {
            arr[idx] = in.nextLine().trim();
        }

        if ((starts(gends, arr) && ends(gstarts, arr)) || (contains(given, arr)) || ((num == 1) && (arr[0].equals(given)))) {
            out.println("YES");
        } else {
            out.println("NO");
        }

        out.close();
    }

    public static boolean starts (char starts,  String[] arr) {
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx].charAt(0) == starts) {
                return true;
            }
        }
        return false;
    }

    public static boolean ends (char ends, String[] arr) {
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx].charAt(1) == ends) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains (String given, String[] arr) {
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx].equals(given)) {
                return true;
            }
        }
        return false;
    }

    public static PrintWriter out;

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
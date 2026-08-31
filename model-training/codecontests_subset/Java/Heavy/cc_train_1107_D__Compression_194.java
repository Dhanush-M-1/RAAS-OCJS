import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    boolean[][] a;
    void problem() {
        Map<Character, String> dm = new HashMap<>();
        dm.put('0', "0000");
        dm.put('1', "0001");
        dm.put('2', "0010");
        dm.put('3', "0011");
        dm.put('4', "0100");
        dm.put('5', "0101");
        dm.put('6', "0110");
        dm.put('7', "0111");
        dm.put('8', "1000");
        dm.put('9', "1001");
        dm.put('A', "1010");
        dm.put('B', "1011");
        dm.put('C', "1100");
        dm.put('D', "1101");
        dm.put('E', "1110");
        dm.put('F', "1111");

        int n = in.nextInt();
        a = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] s = in.nextToken().toCharArray();
            for (int j = 0; j < n / 4; j++) {
                for (int k = 0; k < 4; k++) {
                    a[i][j*4 + k] = (dm.get(s[j]).charAt(k) - 48) == 1;
                }
            }
        }

        TreeSet<Integer> td = new TreeSet<>();
        for (int i = 1; i <= sqrt(n) + 1; i++) {
            if (n % i == 0) {
                td.add(i);
                td.add(n/i);
            }
        }

        List<Integer> d = new ArrayList<>(td);
        for (int di = d.size() - 1; di >= 1; di--) {
            boolean res = true;
            int size = d.get(di);
            for (int i = 0; i < n; i = i + size) {
                for (int j = 0; j < n; j = j + size) {
                    res &= checkMatr(i, j, size);
                }
            }
            if (res) {
                out.println(size);
                return;
            }
        }

        out.println(1);
    }

    boolean checkMatr(int i1, int j1, int size) {
        boolean cur = a[i1][j1];
        for (int i = i1; i < i1 + size; i++) {
            for (int j = j1; j < j1 + size; j++) {
                if (cur != a[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    void run() {
        in = new FastScanner();
        out = new PrintWriter(System.out);
        problem();
        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

//        public FastScanner(String s) {
//            try {
//                br = new BufferedReader(new FileReader(s));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }

    FastScanner in;
    PrintWriter out;
}
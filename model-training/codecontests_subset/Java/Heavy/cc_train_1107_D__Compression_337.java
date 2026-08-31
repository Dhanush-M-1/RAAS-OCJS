import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static int[][] a;
    static int n;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        n = sc.nextInt();
        char[][] xx = new char[n][n];
        for (int i = 0; i < n; i++)
            xx[i] = hexToBin(sc.next()).toCharArray();
        a = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                a[i][j] = (xx[i - 1][j - 1] - '0') + a[i][j - 1] + a[i - 1][j] - a[i - 1][j - 1];
        ArrayList<Integer> divs = generateDivisors(n);
        int ans = 1;
        search:
        for (int x : divs) {
            int y = n / x;
            for (int i = 1; i + y - 1 <= n; i += y) {
                int i2 = i + y - 1;
                for (int j = 1; j + y - 1 <= n; j += y) {
                    int j2 = j + y - 1;
                    int sum = a[i2][j2] - a[i - 1][j2] - a[i2][j - 1] + a[i - 1][j - 1];
                    if (sum != 0 && sum != y * y) continue search;
                }
            }
            ans = Math.max(ans, y);
        }
        out.println(ans);
        out.flush();
        out.close();
    }

    static ArrayList<Integer> generateDivisors(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i != 0) continue;
            ans.add(i);
            if (n / i != i) ans.add(n / i);
        }
        Collections.sort(ans);
        return ans;
    }

    static String convert(char x) {
        switch (x) {
            case '0':
                return "0000";
            case '1':
                return "0001";
            case '2':
                return "0010";
            case '3':
                return "0011";
            case '4':
                return "0100";
            case '5':
                return "0101";
            case '6':
                return "0110";
            case '7':
                return "0111";
            case '8':
                return "1000";
            case '9':
                return "1001";
            case 'A':
                return "1010";
            case 'B':
                return "1011";
            case 'C':
                return "1100";
            case 'D':
                return "1101";
            case 'E':
                return "1110";
            case 'F':
                return "1111";
        }
        return "";
    }

    static String hexToBin(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            ans.append(convert(s.charAt(i)));
        return ans.toString();
    }

    public static boolean check(int xx) {
        int[][] test = new int[n / xx + 1][n / xx + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = (i + xx - 1) / xx;
                int y = (j + xx - 1) / xx;
                if (test[x][y] == 0) {
                    test[x][y] = a[i][j];
                    continue;
                }
                if (test[x][y] != a[i][j]) return false;

            }
        }
        return true;

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        public Scanner(String file) throws Exception {
            br = new BufferedReader(new FileReader(file));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

        public void waitForInput() throws InterruptedException {
            Thread.sleep(3000);
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

    }
}
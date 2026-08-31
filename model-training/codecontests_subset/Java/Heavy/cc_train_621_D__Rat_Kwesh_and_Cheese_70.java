import java.util.*;
import java.io.*;

public class CF341D {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    final long MOD = 1000L * 1000L * 1000L + 7;
    void solve() throws IOException {
        double x = nextDouble();
        double y = nextDouble();
        double z = nextDouble();

        String[] arr = {"x^y^z", "x^z^y", "(x^y)^z", "y^x^z", "y^z^x", "(y^x)^z", "z^x^y", "z^y^x", "(z^x)^y"};

        if(x > 1 || y > 1 || z > 1) {
            double[] values = new double[9];
            if(x <= 1) {
                values[0] = Double.NEGATIVE_INFINITY;
                values[1] = Double.NEGATIVE_INFINITY;
                values[2] = Double.NEGATIVE_INFINITY;
            }
            else {
                values[0] = z * Math.log(y) + Math.log(Math.log(x));
                values[1] = y * Math.log(z) + Math.log(Math.log(x));
                values[2] = Math.log(z) + Math.log(y) + Math.log(Math.log(x));
            }

            if(y <= 1) {
                values[3] = Double.NEGATIVE_INFINITY;
                values[4] = Double.NEGATIVE_INFINITY;
                values[5] = Double.NEGATIVE_INFINITY;
            }
            else {
                values[3] = z * Math.log(x) + Math.log(Math.log(y));
                values[4] = x * Math.log(z) + Math.log(Math.log(y));
                values[5] = Math.log(z) + Math.log(x) + Math.log(Math.log(y));
            }

            if(z <= 1) {
                values[6] = Double.NEGATIVE_INFINITY;
                values[7] = Double.NEGATIVE_INFINITY;
                values[8] = Double.NEGATIVE_INFINITY;
            }
            else {
                values[6] = y * Math.log(x) + Math.log(Math.log(z));
                values[7] = x * Math.log(y) + Math.log(Math.log(z));
                values[8] = Math.log(x) + Math.log(y) + Math.log(Math.log(z));
            }
            out(arr[findMax(values)]);

        }
        else if(x == 1 || y == 1 || z == 1) {
            if(x == 1) {
                out(arr[0]);
            }
            else if(y == 1) {
                out(arr[3]);
            }
            else {
                out(arr[6]);
            }
        }
        else {
            double[] values = new double[9];
            values[0] = z * Math.log(y) + Math.log(Math.log(1 / x));
            values[1] = y * Math.log(z) + Math.log(Math.log(1 / x));
            values[2] = Math.log(z) + Math.log(y) + Math.log(Math.log(1 / x));

            values[3] = z * Math.log(x) + Math.log(Math.log(1 / y));
            values[4] = x * Math.log(z) + Math.log(Math.log(1 / y));
            values[5] = Math.log(z) + Math.log(x) + Math.log(Math.log(1 / y));

            values[6] = y * Math.log(x) + Math.log(Math.log(1 / z));
            values[7] = x * Math.log(y) + Math.log(Math.log(1 / z));
            values[8] = Math.log(x) + Math.log(y) + Math.log(Math.log(1 / z));
            out(arr[findMin(values)]);
        }
    }
    public int findMax(double[] arr) {
        int res = 0;
        double tmp = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(tmp < arr[i]) {
                res = i;
                tmp = arr[i];
            }
        }
        return res;
    }
    public int findMin(double[] arr) {
        int res = 0;
        double tmp = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(tmp > arr[i]) {
                res = i;
                tmp = arr[i];
            }
        }
        return res;
    }
    void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    private void outln(Object o) {
        System.out.println(o);
    }
    private void out(Object o) {
        System.out.print(o);
    }
    public CF341D() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CF341D();
    }

    public long[] nextLongArr(int n) throws IOException{
        long[] res = new long[n];
        for(int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }
    public int[] nextIntArr(int n) throws IOException {
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }
    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }
    public String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}
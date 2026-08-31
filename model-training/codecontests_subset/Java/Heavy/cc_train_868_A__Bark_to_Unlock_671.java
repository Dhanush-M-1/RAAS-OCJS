
import java.io.*;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.beans.binding.StringBinding;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1], R = new int[n2 + 1];
        // int[] L1 = new int[n1 + 1], R1 = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = a[p + i];
            //  L1[i] = b[p + i];

        }
        for (int i = 0; i < n2; i++) {
            R[i] = a[q + 1 + i];
            // R1[i] = b[q + 1 + i];

        }
        L[n1] = R[n2] = INF;
        // L1[n1] = R1[n2] = INF;

        for (int k = p, i = 0, j = 0; k <= r; k++) {
            if (L[i] <= R[j]) {

                a[k] = L[i++];
                //  b[k] = L1[i++];

            } else {
                a[k] = R[j++];
                // b[k] = R1[j++];

            }
        }
    }

    static void mergeSort(int[] a, int[] b, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, b, p, q);
            mergeSort(a, b, q + 1, r);
            merge(a, b, p, q, r);
        }
    }

    static void merge(int[] a, int[] b, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1], R = new int[n2 + 1];
        int[] L1 = new int[n1 + 1], R1 = new int[n2 + 1];
        // int[] L2 = new int[n1 + 1], R2 = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = a[p + i];
            L1[i] = a[p + i];
            // L2[i] = a[p + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = a[q + 1 + i];
            R1[i] = a[q + 1 + i];
            //  R2[i] = a[q + 1 + i];
        }
        L[n1] = R[n2] = INF;
        L1[n1] = R1[n2] = INF;
        // L2[n1] = R2[n2] = INF;

        for (int k = p, i = 0, j = 0; k <= r; k++) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                b[k] = L1[i++];
                // c[k] = L2[i++];
            } else {
                a[k] = R[j];
                b[k] = R1[j++];
                // c[k] = R2[j++];
            }
        }
    }

    public static int[] sieve(int n) {
        int a[] = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            a[i] = 1;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (a[i] == 1) {
                for (int k = 2; i * k <= n; k++) {
                    a[i * k] = 0;
                }
            }
        }
        return a;
    }

    public static long sum(int a) {
        long su = 0;
        while (a > 0) {
            su += (long) a % 10;
            a /= 10;
        }
        return su;
    }

    public static int divi(int b) {
        int n = 0;
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (b % i == 0) {
                n = i;
                break;
            }
        }
        if (n == 0) {
            return b;
        }
        return n;
    }

    public static boolean prime(int n) {
        if (n == 1) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String reve(int a, int b, String s) {
        String q = "";
        for (int i = b; i >= a; i--) {
            q += s.charAt(i);
        }
        return q;
    }

    public static boolean isvowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
            return true;
        } else {
            return false;
        }
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int hole(int n) {
        int y = 0;
        if (n == 1) {
            return 0;
        }
        if (prime(n)) {
            return 1;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (prime(i)) {
                    y++;
                }
                if (prime(n / i) && i != (n / i)) {
                    y++;
                }
            }
        }
        return y;
    }

    static List<Integer> gd(int a, int b) {
        int m = (int) gcd(a, b);
        List<Integer> q = new ArrayList();
        for (int i = 1; i * i <= m; ++i) {
            if (m % i == 0) {
                q.add(i);
                if (i != m / i) {
                    q.add(m / i);
                }
            }
        }
        return q;
    }

    static boolean contain(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 0) {
                return true;
            }
        }
        return false;
    }

    static void decrease(int[] a) {
        for (int i = 1; i < a.length; i++) {
            a[i]--;
        }
    }

    static long power(StringBuilder s) {
        long c = 1, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'C') {
                c *= 2;
            } else {
                sum += c;
            }
        }
        return sum;
    }

    static long sum(long n) {
        return n * (n + 1) / 2;
    }

    static int divisors(int n) {
        Set<Integer> c = new HashSet();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                c.add(i);
                c.add((int) (n / i));
            }
        }
        return c.size();
    }

    static boolean cal(int val, int k, int t) {
        int res = val, p = 1;
        while (val / Math.pow(k, p) > 0) {
            res += val / Math.pow(k, p);
            p++;
        }
        return res >= t;
    }

    static int Last_Ocuu(List<Integer> a, int n) {
        int start = 1, end = (int) 10e9, mid;

        while (start <= end) {
            mid = (start + end) >> 1;
            if (mid == n) {
                return mid;
            } else if (mid > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }

    static void print(int a, String s) {

        if (a > 0) {
            //s+='*';
            System.out.println(s);
            print(a - 1, '*' + s);
        } else {
            return;
        }
    }

    static long max(int[] a) {

        long m = 0;
        int max = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] == a[i - 1]) {
                m++;
            }
        }
        if (m == 0) {
            m++;
        }
        return m;
    }

    static int summtion(int[] a) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s += a[i];
        }
        return s;
    }
    static boolean vv(int i,int j,int n,int m){
        if (i>=0&&i<n&&j<m&&j>=0) {
            return true;
        }
        return false;
    }
    static  boolean valid(char [] []a,int i,int j,int n,int m){
        char k=a[i][j];
        if (Character.isDigit(k)) {
            int co=0;
            if (vv(i, j+1, n, m)) {//
                if(a[i][j+1]=='*')co++;
            }
            if (vv(i+1, j, n, m)) {//
                if(a[i+1][j]=='*')co++;
            }
            if (vv(i+1, j+1, n, m)) {//
                if(a[i+1][j+1]=='*')co++;
            }
            if (vv(i-1, j, n, m)) {//
                if(a[i-1][j]=='*')co++;
            }
            if (vv(i, j-1, n, m)) {//
                if(a[i][j-1]=='*')co++;
            }
            if (vv(i-1, j-1, n, m)) {//
                if(a[i-1][j-1]=='*')co++;
            }
            if (vv(i-1, j+1, n, m)) {
                if(a[i-1][j+1]=='*')co++;
            }
            if (vv(i+1, j-1, n, m)) {
                if(a[i+1][j-1]=='*')co++;
            }
            if (co==Integer.parseInt(k+"")) {
                return true;
            }
            return false;
        }
        else if (k=='.') {
            if (vv(i, j+1, n, m)) {//
                if(a[i][j+1]=='*')return false;
            }
            if (vv(i+1, j, n, m)) {//
                if(a[i+1][j]=='*')return false;
            }
            if (vv(i+1, j+1, n, m)) {//
                if(a[i+1][j+1]=='*')return false;
            }
            if (vv(i-1, j, n, m)) {//
                if(a[i-1][j]=='*')return false;
            }
            if (vv(i, j-1, n, m)) {//
                if(a[i][j-1]=='*')return false;
            }
            if (vv(i-1, j-1, n, m)) {//
                if(a[i-1][j-1]=='*')return false;
            }
            if (vv(i-1, j+1, n, m)) {
                if(a[i-1][j+1]=='*')return false;
            }
            if (vv(i+1, j-1, n, m)) {
                if(a[i+1][j-1]=='*')return false;
            }
           
            
        }
         return true;
    }
    public static void main(String[] args) throws IOException, ParseException {
        Scanner in = new Scanner(System.in);
        PrintWriter or = new PrintWriter(System.out);
        char[] a= in.nextLine().toCharArray();
        int n = in.nextInt();
        String [] s= new String[n];
        for (int i = 0; i < n; i++) {
            s[i]=in.nextLine();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((s[i]+s[j]).contains(new String(a))) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
     or.flush();
    
    }
    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader fileReader) throws FileNotFoundException {
            br = new BufferedReader(fileReader);
        }

        public Scanner(InputStream s) throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++) {
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec) {
                        f *= 10;
                    }
                }
            }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

    }

}

class Pair implements Comparable<Pair> {

    int ind;
    int val;

    public Pair(int n, int p) {
        ind = n;
        val = p;
    }

    @Override
    public int compareTo(Pair o) {
        if (o.val == val) {
            return -1 * (o.ind - ind);
        }
        return (val - o.val);
    }

}

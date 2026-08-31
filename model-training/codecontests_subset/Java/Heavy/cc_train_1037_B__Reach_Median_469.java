//package CodeForces;

import java.io.*;
import java.util.*;
import javafx.util.Pair;

public class Main {

    public class Haha {
        /*                     _____                                                             ___
                /\      /\    |     | |   |    /\       /\      /\       /\      /\       /\    |   \     محمد أبوحسن*
               /  \    /  \   |     | |___|   /__\     /  \    /  \     /  \    /  \     /__\   |    \
              /    \  /    \  |     | |   |  /    \   /    \  /    \   /    \  /    \   /    \  |    /
             /      \/      \ |_____| |   | /      \ /      \/      \ /      \/      \ /      \ |___/
         */
    }

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

    public static class MyPair {

        int x;
        int y;

        public MyPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int Fibonacci(int n) {
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < a.length; i++) 
            a[i] = a[i - 1] + a[i - 2];
        return a[n];
    }

    public static boolean isprime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] addarr(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }

    public static int factt(int n) {
        if(n == 0) return 1;
        return n * factt(n-1);
    }

    public static long sumDigit(long n) {
        int a = 0;
        while (n != 0) {
            a += n % 10;
            n /= 10;
        }
        return a;
    }
   
    public static long pow(long n, long p){
        return p == 0 ? 1: n*pow(n, p-1);
    }
    
    public static long fastpow(long v, long p) {
        if (p == 0) {
            return 1;
        }
        if (p == 1) {
            return v;
        }
        long ans = fastpow(v, p / 2);
        if (p % 2 == 1) {
            return ans * ans * v;
        } else {
            return ans * ans;
        }
    }

    public static int LCS(String s1, String s2, int i, int j){
//        String s1 = sc.next();
//        String s2 = sc.next();
//        dp = new int[s1.length()][s2.length()];
//        System.out.println(LCS(s1, s2, s1.length()-1, s2.length()-1));
        if(i == -1 || j == -1)
            return 0;
        else if(dp[i][j] != 0)
            return dp[i][j];
        else if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + LCS(s1, s2, i-1, j-1);
        
        else
            return dp[i][j] = Math.max(LCS(s1, s2, i-1, j), LCS(s1, s2, i, j-1));
    }
    
    public static MyScanner sc = new MyScanner();
    public static int MOD = 1000000007;
    // __builtin_popcountll(n) <-- c++ // binary count(1) ex. 8 --> 0100 --> 1
    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    Random r = new Random();
    ArrayList<Integer> l = new ArrayList<>();
    public static int[][] dp;

    
    public static void main(String[] args) {
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        long c = 0;
        addarr(a, n);
        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
        for (int i = 0; i < n; i++) {
            if(a[i] < s && i >= n/2)
                c += s-a[i];
            else if(a[i] > s && i <= n/2)
                c += a[i]-s;
        }
        System.out.println(c);
    }
}
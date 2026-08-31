import java.util.*;
import java.io.*;
public class Red {
    static FastScanner f;
    static PrintWriter pw = new PrintWriter(System.out);
    static long mod = 1000_000_007;
    static long oo = Long.MAX_VALUE;
    static int ooo = Integer.MAX_VALUE;
    static double eps = 1e-12;

    public static void solve()throws IOException {
        int n = f.ni();
        String s = f.next();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int ans = 0;
        char ans1 = '?' , ans2 = '?';
        for (int i = 0; i < 26; ++i) {
            char a1 = alpha.charAt(i);
            for (int j = 0; j < 26; ++j) {
                char a2 = alpha.charAt(j);
                int curr = 0;
                for (int k = 0; k + 1 < s.length(); ++k) {
                    if (s.charAt(k) == a1 && s.charAt(k + 1) == a2) {
                        ++curr;
                    }
                }
                if (ans < curr) {
                    ans = curr;
                    ans1 = a1;
                    ans2 = a2;
                }
            }
        }
        p(ans1);
        p(ans2);
    }    
    
    public static void main(String args[])throws IOException {
        go();
        boolean test_cases = false;
        int t = test_cases ? f.ni() : 1;
        while (t --> 0) solve();
        pw.flush();
        pw.close(); 
    }

    public static void go()throws IOException {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            f = new FastScanner("");
        }
        else f = new FastScanner(System.in);
    }

    public static class FastScanner {
        StringTokenizer st;
        BufferedReader br;
 
        public FastScanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public FastScanner(String str) {
            try {
                br = new BufferedReader(new FileReader("inp.txt"));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
 
        public String next()throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
 
        public int ni() throws IOException {return Integer.parseInt(next());}
 
        public long nl() throws IOException {return Long.parseLong(next());}
 
        public String nextLine() throws IOException {return br.readLine();}

        public double nd() throws IOException {return Double.parseDouble(next());}
    }

    public static long mul(long a , long b) {
        return ((a % mod) * (b % mod)) % mod;
    }

    public static void sort(int a[]) {
        ArrayList<Integer> x = new ArrayList<>();
        for (int i : a) x.add(i);
        Collections.sort(x);
        for (int i = 0; i < a.length; ++i) a[i] = x.get(i);
    }
    
    public static void sort(long a[]) {
        ArrayList<Long> x = new ArrayList<>();
        for (Long i : a) x.add(i);
        Collections.sort(x);
        for (int i = 0; i < a.length; ++i) a[i] = x.get(i);
    }

    public static void sort(ArrayList<Integer> arr) {Collections.sort(arr);}

    public static void pn(Object o){pw.println(o);}
        
    public static void p(Object o){pw.print(o);}
        
    public static void pni(Object o){pw.println(o);pw.flush();}

    static int gcd(int x , int y) {
        if (y == 0) return Math.abs(x);
        return gcd(y , x % y);
    }
}
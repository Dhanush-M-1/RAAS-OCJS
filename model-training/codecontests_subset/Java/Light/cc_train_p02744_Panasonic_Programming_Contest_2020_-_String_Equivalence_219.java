import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    static public class pair {
        int u;
        int idx;
        int val;

        public pair(int x, int i) {
            u = x;
            idx = i;
            val = -1;
        }
    }



    static ArrayList<pair>[] adj;
    static int[] Arr, Arry;
    static int inf = (int) 1e9,n;
    static boolean[][] matrix;
    static long[][] memo;
    static long mod = 998244353;
    public static  boolean sub(String a,String b){
        for(int i=0;i<a.length();i++) {
            if (a.charAt(i) == b.charAt(i) || a.charAt(i) =='?' || b.charAt(i) == '?')
                continue;
            return false;
        }
        return true;
    }
    public static  boolean cont(String a,String b){
        int n=b.length();
        for(int i=0;i<a.length()-n;i++){
            if(sub(a.substring(i,i+n),b))
                return true;
        }
        return false;
    }
public static  int inter (String a,String b){
    int n=min(a.length(),b.length());
    if(cont(a, b)||cont(b, a))
        return n;
    while(n>0){
        if(sub(a.substring(a.length()-n),(b.substring(0,n))))
            return n;
        n--;
    }
    return 0;
}
static TreeSet<String>ts;
public static void backtrack(int idx,int upperBound,String str){
        if(idx==n){
            ts.add(str);
            return;
        }
        for(int i=0;i<=upperBound+1;i++){
            backtrack(idx+1, Math.max(upperBound, i),str+(char)('a'+i));
        }
}
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
         n=sc.nextInt();
         ts=new TreeSet<>();
        backtrack(0, -1,"");
        for (String str:ts)
            pw.println(str);
        pw.close();
    }

    public static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(s));

        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
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
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException, IOException {
            return br.ready();
        }

    }
}

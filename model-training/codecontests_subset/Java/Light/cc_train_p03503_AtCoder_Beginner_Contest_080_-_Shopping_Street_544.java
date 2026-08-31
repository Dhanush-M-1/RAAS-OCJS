import java.io.*;
import java.util.*;

public class Main {
    public static final long mod = (long)1e9+7;
    public static final long INF = Long.MAX_VALUE/10;
    public static final int inf = Integer.MAX_VALUE/10;

    static void solve(InputReader in, PrintWriter out){
        int n = in.ni();
        boolean[][] f = new boolean[n][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                f[i][j] = in.ni()==1;
            }
        }
        int[][] p = new int[n][11];
        for (int i = 0; i < n; i++) p[i] = in.ni(11);
        int ans = Integer.MIN_VALUE, sum = 0, count = 0;
        String format = "%".concat(String.valueOf(10)).concat("s"), s;
        for (int i = 1; i < (1 << 10); i++) {
            s = String.format(format, Integer.toString(i,2)).replace(' ', '0');
            sum = 0;
            for (int j = 0; j < n; j++) {
                count = 0;
                for (int k = 0; k < 10; k++) {
                    if(s.charAt(k)=='1'&&f[j][k]) count++;
                }
                sum += p[j][count];
            }
            ans = Math.max(ans, sum);
        }
        out.println(ans);
    }

    public static void main(String[] args) throws Exception{
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        solve(in, out);
        out.close();
    }
    public static class InputReader{
        private BufferedReader br;
        private StringTokenizer st;
        public InputReader(InputStream is){
            br = new BufferedReader(new InputStreamReader(is));
            st = null;
        }
        public String ns(){
            if(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
        public long nl(){
            return Long.parseLong(ns());
        }
        public int ni(){
            return Integer.parseInt(ns());
        }
        public Double nd(){
            return Double.parseDouble(ns());
        }
        public int[] ni(int n){
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }
        public long[] nl(int n){
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        }
        public double[] nd(int n){
            double[] a = new double[n];
            for (int i = 0; i < n; i++) {
                a[i] = nd();
            }
            return a;
        }
    }
}
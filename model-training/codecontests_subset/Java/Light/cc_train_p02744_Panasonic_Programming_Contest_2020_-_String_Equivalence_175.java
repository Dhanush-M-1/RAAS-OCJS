import java.io.*;
import java.util.*;

public class Main {
    public static final long mod = (long)1e9+7;
    public static final int inf = Integer.MAX_VALUE/10;
    public static ArrayList<String> list;
    public static int k;
    static void solve(InputReader in, PrintWriter out){
        k = in.ni();
        list = new ArrayList<>();
        dfs("a", 0);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            out.println(list.get(i));
        }
    }
    public static void dfs(String s, int a){
        if(s.length()==k){
            list.add(s);
            return;
        }else{
            for (int i = 0; i <= a+1; i++) {
                dfs(s.concat(String.valueOf((char)(i+'a'))), Math.max(a,i));
            }
        }
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
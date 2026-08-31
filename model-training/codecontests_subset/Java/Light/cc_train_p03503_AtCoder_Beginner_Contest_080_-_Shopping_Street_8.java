import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n=sc.nextInt();
        int[]f=new int[n];
        for(int i=0;i<n;++i)
            for(int j=0;j<10;++j)
                f[i]|=sc.nextInt()<<j;
        int[][]p=new int[n][11];
        for(int i=0;i<n;++i)
            for(int j=0;j<11;++j)p[i][j]=sc.nextInt();
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<1024;++i){
            int t=0;
            for(int j=0;j<n;++j)
                t+=p[j][Integer.bitCount(i&f[j])];
            ans=Math.max(ans,t);
        }
        out.println(ans);
        out.close();
    }
    // http://codeforces.com/blog/entry/7018
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
    //-----------MyScanner class for faster input----------
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
        String nextLine(){
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

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.flush();out.close();
    }
        static class TaskE {
          public void solve(int testNumber, InputReader in, PrintWriter out) {
              int n=in.nextInt(),m=in.nextInt(),k=in.nextInt();
              boolean is[]=new boolean[n];
              int l=0,p=-2,cnt=0;
              for(int i=0;i<m;i++){
               int x=in.nextInt();
               if(x==p+1){
                p=x;cnt++;
               }else{
                l=Math.max(l,cnt);p=x;cnt=1;
               }
               is[x]=true;
              }
              l=Math.max(l,cnt);
              long cost[]=new long[k+1];
              for(int i=1;i<=k;i++)cost[i]=in.nextLong();
              if(k<=l||is[0]){
               out.print("-1");return;
              }
              int close[]=new int[n];
              for(int i=1;i<n;i++){
               if(is[i])close[i]=close[i-1];
               else{
                close[i]=i;
               }
              }
              long ans=Long.MAX_VALUE;
              for(int i=l+1;i<=k;i++){
               int pst=0;long val=0;
               while(pst<n){
                pst=close[pst]+i;val+=cost[i];
               }
               ans=Math.min(ans,val);
              }
              out.print(ans);
          }
          //          int ja[][],from[],to[],c[];
    //              void make(int n,int m,InputReader in){
    //               ja=new int[n+1][];from=new int[m];to=new int[m];c=new int[n+1];
    //               for(int i=0;i<m;i++){
    //                from[i]=in.nextInt();to[i]=in.nextInt();
    //                c[from[i]]++;c[to[i]]++;
    //               }
    //               for(int i=1;i<=n;i++){
    //                ja[i]=new int[c[i]];c[i]=0;
    //               }
    //               for(int i=0;i<m;i++){
    //                ja[from[i]][c[from[i]]++]=to[i];
    //                ja[to[i]][c[to[i]]++]=from[i];
    //               }
    //              }
//            int[] radixSort(int[] f){ return radixSort(f, f.length); }
//    	int[] radixSort(int[] f, int n)
//    	{
//    		int[] to = new int[n];
//    		{
//    			int[] b = new int[65537];
//    			for(int i = 0;i < n;i++)b[1+(f[i]&0xffff)]++;
//    			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
//    			for(int i = 0;i < n;i++){
//                             to[b[f[i]&0xffff]++] = f[i];
//                            }
//    			int[] d = f; f = to;to = d;
//    		}
//    		{
//    			int[] b = new int[65537];
//    			for(int i = 0;i < n;i++)b[1+(f[i]>>>16)]++;
//    			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
//    			for(int i = 0;i < n;i++)to[b[f[i]>>>16]++] = f[i];
//    			int[] d = f; f = to;to = d;
//    		}
//    		return f;
//    	}
    
       }
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;
        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
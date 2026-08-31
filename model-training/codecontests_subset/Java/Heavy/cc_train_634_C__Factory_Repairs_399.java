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
         int fa[],fb[];
         void upda(int id,int val,int max){
          while(id<=max){
           fa[id]+=val;id+=id&-id;
          }
         }
         void updb(int id,int val,int max){
          while(id<=max){
           fb[id]+=val;id+=id&-id;
          }
         }
         int geta(int id){
          int ans=0;
          while(id>0){
           ans+=fa[id];id-=id&-id;
          }return ans;
         }
         int getb(int id){
          int ans=0;
          while(id>0){
           ans+=fb[id];id-=id&-id;
          }return ans;
         }
         public void solve(int testNumber, InputReader in, PrintWriter out) {
             int n=in.nextInt(),k=in.nextInt(),a=in.nextInt(),b=in.nextInt(),q=in.nextInt();
             int A[]=new int[n+1],B[]=new int[n+1];fa=new int[n+1];fb=new int[n+1];
             while(q-->0){
              int t=in.nextInt();
              if(t==1){
               int d=in.nextInt(),c=in.nextInt();
               upda(d,Math.min(A[d]+c,a)-A[d],n);A[d]=Math.min(A[d]+c,a);
               updb(d,Math.min(B[d]+c,b)-B[d],n);B[d]=Math.min(B[d]+c,b);
              }else{
               int p=in.nextInt();
               out.println(getb(p-1)+geta(n)-geta(p+k-1));
              }
             }
         }
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
import java.io.*;
import java.util.*;
public class Civilisation {
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
            LinkedList<Integer> ll[];
            int pa[],R[],D[];
            boolean visit[];
            void find(int a){
             if(pa[a]==a)return;
             else find(pa[a]);
             pa[a]=pa[pa[a]];
            }
            void m(int a,int b){
             find(a);find(b);
             int x=pa[a],y=pa[b];
             if(R[x]==R[y])++R[x];
             if(R[x]<R[y]){
              pa[x]=y;
             }else pa[y]=x;
            }
            int dfs(int u,int P){
             ListIterator it=ll[u].listIterator();
             visit[u]=true;int max1=0,max2=0;
             while(it.hasNext()){
              int v=(int)it.next();
              if(!visit[v]){
               int val=dfs(v,P)+1;
               if(val>max2){
                if(val>max1){
                 max2=max1;max1=val;
                }
                else max2=val;
               }
              }
             }D[P]=Math.max(D[P],max1+max2);
             return Math.max(max1,max2);
            }
         public void solve(int testNumber, InputReader in, PrintWriter out) {
               int n=in.nextInt(),m=in.nextInt(),q=in.nextInt();
               ll=new LinkedList[n+1];pa=new int[n+1];R=new int[n+1];
               visit=new boolean[n+1];D=new int[n+1];
               for(int i=0;i<n+1;i++){
                ll[i]=new LinkedList<>();
                pa[i]=i;
               }
               for(int i=0;i<m;i++){
                int a=in.nextInt(),b=in.nextInt();
                m(a,b);ll[a].add(b);ll[b].add(a);
               }
               for(int i=1;i<=n;i++){
                if(!visit[i]){
                 find(i);
                 dfs(i,pa[i]);
                }
               }
               while(q-->0){
                int t=in.nextInt();
                if(t==1){
                 int x=in.nextInt();find(x);out.println(D[pa[x]]);
                }else{
                 int x=in.nextInt(),y=in.nextInt();
                 find(x);find(y);int px=pa[x],py=pa[y];
                 if(pa[x]==pa[y])continue;
                 m(x,y);find(x);int fp=pa[x];
                 D[fp]=Math.max(Math.max(D[px],D[py]),(D[px]+1)/2+(D[py]+1)/2+1);
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
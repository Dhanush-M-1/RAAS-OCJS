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
          boolean visit[];ArrayList<Integer> al=new ArrayList<>();
          void upd(int u){
           visit[u]=true;al.add(u);
           for(int v:ja[u]){
            c[v]--;
           }
          }
          void cal(int u,int pa){ 
           for(int v:ja[u]){
            if(v==pa)continue;
            cal(v,u);
           }
           if(c[u]%2==0){
            dfs(u,pa);
           }
          }
          void dfs(int u,int pa){
           if(c[u]%2==0)upd(u);
           for(int v:ja[u]){
            if(!visit[v]&&v!=pa)
            dfs(v,u);
           }
          }
          public void solve(int testNumber, InputReader in, PrintWriter out) {
           int n=in.nextInt();
           make(n,in);
           visit=new boolean[n+1];
           cal(1,0);
//           System.out.println(al);
           int sz=al.size();
           if(sz!=n)out.print("NO");
           else{
            out.println("YES");
            for(int i=0;i<sz;i++)out.println(al.get(i));
           }
          }
             int ja[][];int from[],to[],c[];
             void make(int n,InputReader in){
              ja=new int[n+1][];from=new int[n+1];to=new int[n+1];c=new int[n+1];
              for(int i=1;i<=n;i++){
               int x=in.nextInt();if(x==0)continue;
               c[i]++;c[x]++;from[i]=x;to[i]=i;
              }
              for(int i=1;i<=n;i++){
               ja[i]=new int[c[i]];c[i]=0;
              }
              for(int i=1;i<=n;i++){
               if(from[i]==0)continue;
               ja[from[i]][c[from[i]]++]=to[i];
               ja[to[i]][c[to[i]]++]=from[i];
              }
             }
        int[] radixSort(int[] f){ return radixSort(f, f.length); }
	int[] radixSort(int[] f, int n)
	{
		int[] to = new int[n];
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(f[i]&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[f[i]&0xffff]++] = f[i];
			int[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(f[i]>>>16)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[f[i]>>>16]++] = f[i];
			int[] d = f; f = to;to = d;
		}
		return f;
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
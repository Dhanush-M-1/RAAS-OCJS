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
         int dfs(int u){
          int r=0,s=0;
          while(is.size()!=s){
           int v=is.getFirst();//System.out.println(u+" "+v+" "+is);
           if(not[u].contains(v)){
            ++s;is.removeFirst();is.addLast(v);continue;
           }
           is.removeFirst();s=0;r+=dfs(v);
          }return ++r;
         }
         
         HashSet<Integer> not[];
         ArrayDeque<Integer> is;
         public void solve(int testNumber, InputReader in, PrintWriter out) {
             int n=in.nextInt(),m=in.nextInt();
             not=new HashSet[n+1];is=new ArrayDeque<>();
             for(int i=1;i<=n;i++){
              not[i]=new HashSet<>();is.add(i);
             }
             for(int i=0;i<m;i++){
              int u=in.nextInt(),v=in.nextInt();
              not[u].add(v);not[v].add(u);
             }
             ArrayList<Integer> al=new ArrayList<>();
             while(!is.isEmpty()){
              int v=is.poll();//System.out.println(v+" v");
              al.add(dfs(v));
             }
             out.println(al.size());
             Collections.sort(al);
             for(int i=0;i<al.size();i++)out.print(al.get(i)+" ");
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
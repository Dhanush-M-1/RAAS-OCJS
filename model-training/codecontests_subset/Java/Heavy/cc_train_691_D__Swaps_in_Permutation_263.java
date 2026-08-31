
import java.io.*;
import java.util.*;
/**
 *
 * @author Sourav Kumar Paul
 */
public class SolveD {
    public static int comp[];
    public static ArrayList<Integer> adj[];
    public static void main(String[] args) throws IOException{
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
       int n = in.nextInt();
       int m = in.nextInt();
       int arr[] = new int[n];
       for(int i=0; i<n; i++)
           arr[i] = in.nextInt();
       adj = new ArrayList[n];
       for(int i=0; i<n; i++)
       {
           adj[i] = new ArrayList<>();
       }
       for(int i=0; i<m; i++)
       {
           int x = in.nextInt()-1;
           int y = in.nextInt()-1;
           adj[x].add(y);
           adj[y].add(x);
       }
       int k =0;
       comp = new int[n];
       Arrays.fill(comp,-1);
       for(int i=0; i<n; i++)
       {
           
           if(comp[i] == -1)
               dfs(i,k++);
       }
       ArrayList<Integer> parts[] = new ArrayList[k];
       for(int i =0; i<k; i++)
           parts[i]= new ArrayList<>();
       for(int i=0; i<n; i++)
       {
           parts[comp[i]].add(arr[i]);
       }
       for(int i=0; i<k; i++)
           Collections.sort(parts[i]);
       for(int i=0; i<n; i++)
       {
           //int x= parts[comp[i]].get(0);
           int x=parts[comp[i]].remove(parts[comp[i]].size()-1);
           arr[i] = x;
       }
       for(int i=0; i<n; i++)
           out.print(arr[i]+" ");
        out.flush();
        out.close();
    }

    private static void dfs(int start, int k) {
       comp[start] = k;
       for(int v: adj[start])
           if(comp[v] ==-1)
               dfs(v,k);
    }
    public static class Reader {
        public BufferedReader reader;
        public StringTokenizer st;

        public Reader(InputStreamReader stream) {
            reader = new BufferedReader(stream);
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public String nextLine() throws IOException{
            return reader.readLine();
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }

    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
 public class realfast implements Runnable {
    private static final int INF = (int) 1e9;
 
    public  void solve() throws IOException 
    {
  
    
         int n = readInt();
         int m = readInt();
         int arr[]= new int[n];
         for(int i=0;i<n;i++)
          arr[i]=readInt();
         ArrayList<Integer> gr[]= new ArrayList[n+1];
         for(int i=0;i<n+1;i++)
          gr[i]= new ArrayList<>();
         for(int i=0;i<m;i++)
         {
         	int u= readInt();
         	int v = readInt();

         	gr[u].add(v);
         }
         int ans =0;
         int cnt =1;
         boolean check[]= new boolean[n+1];
         check[arr[n-1]]=true;

         for(int i=n-2;i>=0;i--)
         {
           int cnt2 =0;
           for(int j=0;j<gr[arr[i]].size();j++)
           {
           	 int val = gr[arr[i]].get(j);
           	 if(check[val])
           	  cnt2++;
           }   	
           if(cnt2==cnt){
           	 ans++;
           }
           else
           {
           	 check[arr[i]]=true;
             cnt++;
           }
         }

         out.println(ans);
 
        
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        new Thread(null, new realfast(), "", 128 * (1L << 20)).start();
    }
 
    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter out;
 
    @Override
    public void run() {
        try {
            if (ONLINE_JUDGE || !new File("input.txt").exists()) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                reader = new BufferedReader(new FileReader("input.txt"));
                out = new PrintWriter("output.txt");
            }
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                // nothing
            }
            out.close();
        }
    }
 
    private String readString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
 
    @SuppressWarnings("unused")
    private int readInt() throws IOException {
        return Integer.parseInt(readString());
    }
 
    @SuppressWarnings("unused")
    private long readLong() throws IOException {
        return Long.parseLong(readString());
    }
 
    @SuppressWarnings("unused")
    private double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }
}
class edge implements Comparable<edge>{
    int u ;
    int v ;
    int val;
    edge(int u1, int v1 , int val1)
    {
       this.u=u1;
       this.v=v1;
       this.val=val1;
    }
    public int compareTo(edge e)
    {
        return this.val-e.val;
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;
 import java.util.*;
public  class realfast implements Runnable 
  {
    private static final int INF = (int) 1e9;
    long in= (long)Math.pow(10,9);
    long fac[]= new long[3000];
    public  void solve() throws IOException 
    {
        int n = readInt();
        int m = readInt();
        int pos[]= new int[n+1];
        int arr[]= new int[n+1];
        for(int i=1;i<=n;i++)
        {
            int a = readInt();
            arr[i]=a;
            pos[a]=i;
        }
        int s = arr[n];
        ArrayList<Integer> adj[] = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            adj[i]= new ArrayList<>();
          boolean check[]= new boolean [n+1];

        for(int i=0;i<m;i++)
        {
            int u = readInt();
            int v = readInt();
            adj[u].add(v);
            if(v==s)
            {
                check[u]=true;
            }
        }
        for(int i=1;i<=n;i++)
        {
            if(adj[i].size()>1)
            {
                 Collections.sort(adj[i]);
            }
        }
       
        


        for(int i=n-1;i>=1;i--)
        {
            if(check[arr[i]])
            {
                //out.println(i);
                int cal = arr[i];
                for(int j =i+1;j<=n;j++)
                {
                    int val = arr[j];
                    if(search(adj,cal,val))
                    {
                        arr[j]= cal;
                        arr[j-1]= val;
                    }
                    else
                        break;
                }
            }
        }

        int po=n;
        for(int i=1;i<=n;i++)
        {
            if(arr[i]==s)
            {
                po=i;
                break;
            }
        }


        out.println(n-po);



       
    }
    public boolean search(ArrayList arr[] , int i, int j  )
    {
           int left =0;
           int right = arr[i].size()-1;

           while(left<=right)
           {

              int mid = left + (right-left)/2;

              int val = (int)arr[i].get(mid);

               if(val==j)
                return true;

              if(val<j)
              {
                left=mid+1;
              }
              else
                right=mid-1;

           }
           return false;
    }
    public long pow(long n , long p,long m)
    {
         if(p==0)
            return 1;
        long val = pow(n,p/2,m);;
        val= (val*val)%m;
        if(p%2==0)
            return val;
        else
            return (val*n)%m;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    int val ;
    int color;
    
    edge(int u, int v)
    {
       this.val=u;
       this.color=v;
    }
    public int compareTo(edge e)
    {
        return this.val-e.val;
    }
}
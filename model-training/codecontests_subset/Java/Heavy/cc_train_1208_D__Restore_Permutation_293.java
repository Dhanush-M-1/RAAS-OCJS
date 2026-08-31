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
     long arr[]= new long[n];
     for(int i =0;i<n;i++)
      arr[i]=readLong();
    long seg[]=new long [4*n+4];
    long fin[]= new long[n];
    for(int i =1;i<=n;i++)
     add(seg,1,n,0,i);
    for(int i=n-1;i>=0;i--)
    {
     int left= 1;
     int right=n;
     int ans=n;
     while(left<=right)
     {
        int mid = left+(right-left)/2;
         long sum1 =sum(seg,1,n,0,mid);
         if(sum1>arr[i])
         {
             ans =mid;
             right=mid-1;
         }
         else
          left=mid+1;
     }
     fin[i]=ans; 
     del(seg,1,n,0,ans);  
    }
    for(int i=0;i<n;i++)
    out.print(fin[i]+" ");

    }
    public void add(long seg[], int left, int right, int index, int i)
    {
        if(i>right||i<left)
        return ;
        seg[index]=seg[index]+=i;
        if(left==right)
        {
         return ;     
        }
        int mid = left+(right-left)/2;
        if(i<=mid)
        add(seg,left,mid,2*index+1,i);
        else
        add(seg,mid+1,right,2*index+2,i);
    }
    public void del(long seg[], int left, int right, int index, int i)
    {
      if(left==right)
      {
          seg[index]= seg[index]-i;
          return ;
      }   
      int mid = left +(right-left)/2;
      seg[index]= seg[index]-i;
      if(i<=mid)
      del(seg,left,mid,2*index+1,i);
      else
      del(seg,mid+1,right,2*index+2,i);
    }
    public long sum(long seg[],int left, int right, int index, int i)
    {
        
        if(left>i)
        return 0;
        
        if(right<=i)
        return seg[index];

        if(left==right)
        return seg[index];

        int mid = left+(right-left)/2;

        return sum(seg,left,mid,2*index+1,i)+sum(seg,mid+1,right,2*index+2,i);
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
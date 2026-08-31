import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;
 import java.util.*;
 public class realfast implements Runnable 
  {
    private static final int INF = (int) 1e9;
    long in= 1000000007;
    long fac[]= new long[1000001];
    long inv[]=new long[1000001];
    public  void solve() throws IOException 
    {

        //int t = readInt();

        int n  = readInt();

        int m = readInt();
        
        int parent[]=new int[m+10];
        int extra[]=new int[m+10];

        for(int i =1;i<=m;i++)
        {
            parent[i]=i;
            extra[i]=-1;
        }

        boolean edge[]=new boolean[n+1];
        int solo[]=new int[m+1];  
        int count =0;     

        for(int i=1;i<=n;i++)
        {

            int k = readInt();

            if(k==1)
            {
                int u = readInt();
                int par = find(parent,u);
                if(extra[par]==-1)
                {
                    count++;
                    extra[par]=0;
                    edge[i]=true;
                }

            }
            else
            {
                int u = readInt();
                int v = readInt();
                if(union(parent,u,v,extra))
                {
                    count++;
                    edge[i]=true;
                }
            }
 
        }
        

        long val = pow(2,count,in);


        out.println(val+" "+count);

        for(int i=1;i<=n;i++)
        {
            if(edge[i])
                out.print(i+" ");

        }

        out.println();

        
       
      

    }
    public int find(int parent[], int i )
    {
        if(parent[i]==i)
            return i;

        parent[i]= find(parent,parent[i]);
        return parent[i];

    }
    public boolean union(int parent[] , int i, int j, int extra[])
    {
        int par1 = find(parent,i);
        int par2 = find(parent,j);
        if(par1==par2){
            return false;
        }
        else if(extra[par1]!=-1&&extra[par2]!=-1)
        return false;   
        else if(extra[par1]!=-1||extra[par2]!=-1)
        {
            extra[par1]=0;
            extra[par2]=0;
        
        }
         parent[par1]=par2;
         return true;

    }
    public boolean intersect(long s1 , long e1 , long s2, long e2)
    {
        if(e2<s1)
            return false;
        if(e1<s2)
            return false;
        return true;
    }
    
    public int value (int seg[], int left , int right ,int index, int l, int r)
    {
            
            if(left>right)
            {
              return -100000000;
            }
            if(right<l||left>r)
                return -100000000;
            if(left>=l&&right<=r)
                return seg[index];
            int mid = left+(right-left)/2;
            int val = value(seg,left,mid,2*index+1,l,r);
            int val2 = value(seg,mid+1,right,2*index+2,l,r);
            return Math.max(val,val2);

    }
   
    public int gcd(int a , int b )
    {
      if(a<b)
      {
        int t =a;
        a=b;
        b=t;
      }
      if(a%b==0)
        return b ;
      return gcd(b,a%b);
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
    int u ;
    int v;
    
    edge(int u, int v)
    {
       this.u=u;
       this.v=v;
    }
    public int compareTo(edge e)
    {
        return this.v-e.v;
    }
}
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

   int t = readInt();

   for(int f =0;f<t;f++)
   {
     int n = readInt();

     int m = readInt();

     long arr[]=new long[n];
     long x[]=new long[m];

     for(int i =0;i<n;i++)
        arr[i]= readInt();
     for(int i =0;i<m;i++)
        x[i]= readInt();
     long sum[]=new long[n];

     long max[]=new long[n];

     sum[0]=arr[0];
     for(int i=1;i<n;i++)
        sum[i]= sum[i-1]+arr[i];

     max[0]= sum[0];

     for(int i=1;i<n;i++)
     {
         max[i]=Math.max(max[i-1],sum[i]);

     }

     sum[n-1]=Math.min(sum[n-1],1000000000);


     for(int i =0;i<m;i++)
     {
         if(x[i]>max[n-1]&&sum[n-1]<=0)
            out.print("-1 ");
         else
         {
            if(sum[n-1]>0)
            {
              long tar = x[i];
              tar= tar -max[n-1];
              long left =0;
              long right=1000000000;
              long ans=right;
             while(left<=right)
             {
                long mid = left+(right-left)/2;

                long pal = (long)Math.pow(10,18);
                pal = sum[n-1]*mid;
                if(pal<tar)
                {
                    left=mid+1;
                }
                else
                {
                    ans= mid;
                    right=mid-1;
                }

             }
             //ans=ans*n;
            // out.println(" ans"+ ans);
             long de = x[i] - ans*sum[n-1];
             ans= ans*((long)n);
             int l=0;
             int r =n-1;
             int blow=n-1;
             while(l<=r)
             {
                int mid = l+(r-l)/2;

                if(max[mid]>=de)
                {
                    r=mid-1;
                    blow=mid;
                }
                else
                    l=mid+1;

             }
             ans= ans+ blow;

             out.print(ans+" ");
           }
           else
           {
             long de = x[i];
             long ans= 0;//ans*n;
             int l=0;
             int r =n-1;
             int blow=n-1;
             while(l<=r)
             {
                int mid = l+(r-l)/2;

                if(max[mid]>=de)
                {
                    r=mid-1;
                    blow=mid;
                }
                else
                    l=mid+1;

             }
             ans= blow;

             out.print(ans+" ");
           }

          

         }

     }


      out.println();

   }


      


      
       
    }

    public boolean search(long val )
    {

        long left =1;
        long right= 10000;

        while(left<=right)
        {
            long mid = left+(right-left)/2;

            long gal = mid*mid*mid;

            if(gal==val)
            {
                return true;
            }

            if(gal<val)
                left=mid+1;
             else
                right=mid-1;

        } 
        return false;

    }


    int modInverse(int a, int m)
    {
        int m0 = m;
        int y = 0, x = 1;
 
        if (m == 1)
            return 0;
 
        while (a > 1) {
            // q is quotient
            int q = a / m;
 
            int t = m;
 
            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;
 
            // Update x and y
            y = x - q * y;
            x = t;
        }
 
        // Make x positive
        if (x < 0)
            x += m0;
 
        return x;
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
    int f ;
    int e;
    int val;
    
    edge(int u, int v, int val)
    {
       this.f=u;
       this.e=v;
       this.val= val;
    }
    public int compareTo(edge e)
    {
        return this.e-e.e;
    }
}
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
public class Main extends Thread  {
    boolean[] prime;
    FastScanner sc;
    PrintWriter pw;
    long startTime = System.currentTimeMillis();
    final class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public long nlo() {
            return Long.parseLong(next());
        }

        public String next() {
            if (st.hasMoreTokens()) return st.nextToken();
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public String nli() {
            String line = "";
            if (st.hasMoreTokens()) line = st.nextToken();
            else try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (st.hasMoreTokens()) line += " " + st.nextToken();
            return line;
        }

        public double nd() {
            return Double.parseDouble(next());
        }
    }
    public Main(ThreadGroup t,Runnable r,String s,long d )
    {
        super(t,r,s,d);
    }
    public void run()
    {
        sc=new FastScanner();
        pw=new PrintWriter(System.out);
        solve();
        pw.flush();
        pw.close();
    }
    public static void main(String[] args)
    {
        new Main(null,null,"",1<<25).start();
    }


    /////////////------------------------------------//////////////
    ////////////------------------Main-Logic--------//////////////
    ///////////-------------------------------------//////////////
  
    public void solve() {
       String[] arr=new String[10];
       arr[0]="0000";arr[1]="0001";arr[2]="0010";arr[3]="0011";arr[4]="0100";
       arr[5]="0101";arr[6]="0110";arr[7]="0111";arr[8]="1000";arr[9]="1001";
       String[] brr=new String[6];
       brr[0]="1010";brr[1]="1011";brr[2]="1100";brr[3]="1101";brr[4]="1110";brr[5]="1111";
       int n=sc.ni();
       char[][] mrr=new char[n][];
       for(int i=0;i<n;i++)
       {
           StringBuilder res=new StringBuilder();
            String s=sc.next();
          for(int j=0;j<n/4;j++)
          {
           char ch=s.charAt(j);
           if(ch>='A')
           res.append(brr[ch-'A']);
           else
           res.append(arr[ch-'0']);
          }
           mrr[i]=res.toString().toCharArray();
       }
       int[][] dp=new int[n][n];
       int[] h1rr=new int[n];
        int[] v1rr=new int[n];
        Arrays.fill(v1rr,1);
        int[] vrr=new int[n];
       for(int i=0;i<n;i++)
            Arrays.fill(dp[i],1);
       for(int i=n-2;i>=0;i--)
        {
            Arrays.fill(vrr,1);Arrays.fill(h1rr,1);
            for(int j=n-2;j>=0;j--)
              {
                  if((mrr[i][j]==mrr[i+1][j])&&(mrr[i][j]==mrr[i][j+1])&&(mrr[i][j]==mrr[i+1][j+1]))
                      dp[i][j]=1+Math.min(h1rr[j+1],Math.min(v1rr[j],dp[i+1][j+1]));
                  if(mrr[i][j]==mrr[i+1][j])
                  vrr[j]=1+v1rr[j];
                  if(mrr[i][j]==mrr[i][j+1])
                    h1rr[j]=1+h1rr[j+1];
              }
              for(int j=0;j<n;j++)
              v1rr[j]=vrr[j];
        }
        int ans=1;
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                if(f(i,mrr,dp))
                ans=Math.max(ans,i);
                if((i!=(n/i))&&(f(n/i,mrr,dp)))
                ans=Math.max(ans,n/i);
            }
        }
         if(f(n,mrr,dp))
                ans=Math.max(ans,n);
        pw.println(ans);
    }
    public static boolean f(int x,char[][] arr,int[][] dp)
    {
        int n=arr.length;
        for(int i=0;x*i<n;i++)
        {
            for(int j=0;j*x<n;j++)
            {
                if(dp[i*x][j*x]<x)
                return false;
            }
        }
        return true;
    }
}
import java.util.*;
import java.io.*;
public class Main implements Runnable{
    FastScanner sc;
    PrintWriter pw;
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
    public static void main(String[] args) throws Exception
    {
        new Thread(null,new Main(),"codeforces",1<<28).start();
    }
    public void run()
    {
        sc=new FastScanner();
        pw=new PrintWriter(System.out);
        solve();
        pw.flush();
        pw.close();
    }
    public long gcd(long a,long b)
    {
        return b==0L?a:gcd(b,a%b);
    }
    public long ppow(long a,long b,long mod)
    {
        if(b==0L)
        return 1L;
        long tmp=1;
        while(b>1L)
        {
            if((b&1L)==1)
            tmp*=a;
            a*=a;
            a%=mod;
            tmp%=mod;
            b>>=1;
        }
        return (tmp*a)%mod;
    }
    public  int gcd(int x,int y)
    {
        return y==0?x:gcd(y,x%y);
    }
   
    //////////////////////////////////
    /////////////  LOGIC  ///////////
    ////////////////////////////////
    
    public void solve()
    {
        int n=sc.ni();
        int m=sc.ni();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.ni()-1;
        HashSet<Integer>[] set=new HashSet[n];
        for(int i=0;i<n;i++)
            set[i]=new HashSet();
        for(int i=0;i<m;i++)
        {
            int u=sc.ni()-1;
            int v=sc.ni()-1;
            set[v].add(u);
        }
        int[] map=new int[n];
        int ans=0;
        if(n==1)
        {
            pw.println(0);
            return;
        }
        for(int i=n-2;i>=0;i--)
        {
            boolean f=true;
            if(set[arr[n-1]].contains(arr[i]))
            {
                f=false;
                if(map[arr[i]]==(n-2-i-ans))
                    ans++;
                else
                    f=true;
            }
            if(f)
            {
                for(int y:set[arr[i]])
                    map[y]++;
            }
        }
        pw.println(ans);
    }
}
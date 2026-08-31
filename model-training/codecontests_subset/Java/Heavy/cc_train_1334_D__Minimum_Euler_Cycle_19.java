    import java.util.*;
    import java.io.*;
   public class Solution implements Runnable{
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
        public static void main(String[] args)
        {
            new Thread(null,new Solution(),"codeforces",1<<25).start();
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
       public void solve(){
           int t=sc.ni();
           while(t-->0)
           {
                long n=sc.nlo();
                long l=sc.nlo();
                long r=sc.nlo();
                long tt=r-l+1L;
                StringBuilder str=new StringBuilder();
                for(long i=1;i<n;i++)
                {
                    l-=(n-i)*2L;
                    if(l>0)
                    continue;
                    l+=(n-i)*2L;
                    if(l%2==0){
                        long j=l/2+i;
                    str.append(j+" ");
                tt--;}
                    tt=dop(i,l/2+1,n,tt,str);
                    break;
                }
                if(tt>0)
                str.append(1);
                pw.println(str);
           }
        }
        public long dop(long i,long p,long n,long t,StringBuilder str)
        {
            //pw.println(i+" "+p+" "+t);
            for(;i<n;i++)
            {
                for(long j=i+p;j<=n;j++)
                {
                    if(t>=2)
                    {str.append(i+" "+j+" ");t-=2L;}
                    else if(t==1)
                    {
                        str.append(i+" ");
                        t-=1;
                    }
                    if(t==0)
                    break;
                }
                p=1;
                if(t==0)
                break;
            }
            if(t==1)
           {t--; str.append(1);}
            return t;
        }
    }
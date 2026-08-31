import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
public class C455 
{
    static class Scanner
    {
        BufferedReader br;
        StringTokenizer tk=new StringTokenizer("");
        public Scanner(InputStream is) 
        {
            br=new BufferedReader(new InputStreamReader(is));
        }
        public int nextInt() throws IOException
        {
            if(tk.hasMoreTokens())
                return Integer.parseInt(tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return nextInt();
        }
        public long nextLong() throws IOException
        {
            if(tk.hasMoreTokens())
                return Long.parseLong(tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return nextLong();
        }
        public String next() throws IOException
        {
            if(tk.hasMoreTokens())
                return (tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return next();
        }
        public String nextLine() throws IOException
        {
            tk=new StringTokenizer("");
            return br.readLine();
        }
        public double nextDouble() throws IOException
        {
            if(tk.hasMoreTokens())
                return Double.parseDouble(tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return nextDouble();
        }
        public char nextChar() throws IOException
        {
            if(tk.hasMoreTokens())
                return (tk.nextToken().charAt(0));
            tk=new StringTokenizer(br.readLine());
            return nextChar();
        }
        public int[] nextIntArray(int n) throws IOException
        {
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=nextInt();
            return a;
        }
        public long[] nextLongArray(int n) throws IOException
        {
            long a[]=new long[n];
            for(int i=0;i<n;i++)
                a[i]=nextLong();
            return a;
        }
        public int[] nextIntArrayOneBased(int n) throws IOException
        {
            int a[]=new int[n+1];
            for(int i=1;i<=n;i++)
                a[i]=nextInt();
            return a;
        }
        public long[] nextLongArrayOneBased(int n) throws IOException
        {
            long a[]=new long[n+1];
            for(int i=1;i<=n;i++)
                a[i]=nextLong();
            return a;
        }
    
    
    }
    
    public static void main(String args[]) throws IOException
    {
        new Thread(null, new Runnable() {
            public void run() {
                try
                {
                    solve();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();
        
    }
    static int p[],r[],cen[],md[],mmd[];
    static int find(int x)
    {
        return p[x]==x?x:(p[x]=find(p[x]));
    }
    static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a==b)
            return;
        if(r[a]<r[b])
        {
            a^=b;b^=a;a^=b;
        }
        p[b]=a;
        if(r[a]==r[b])
            r[a]++;
        
        mmd[a]=Math.max(mmd[a],Math.max(mmd[b],1+md[a]+md[b]));
        if(md[b]>md[a])
            md[a]=md[b];
        else if(md[a]==md[b])
            md[a]++;
           
    }
    static boolean vis[];
    static int d[];
    static ArrayList<Integer> g[];
    static int dfs1(int node,int p,ArrayList<Integer> a)
    {
        vis[node]=true;
        int v=0;
        for(int x:g[node])
        {
            if(x!=p)
                v+=dfs1(x,node,a);
        }
        if(d[node]<=1)
            a.add(node);
        return v+1;
    }
    static void solve() throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int n=in.nextInt();
        int m=in.nextInt();
        int q=in.nextInt();
        p=new int[n+1];
        cen=new int[n+1];
        md=new int[n+1];
        mmd=new int[n+1];
        r=new int[n+1];
        for(int i=0;i<=n;i++)
            p[i]=i;
        g=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            g[i]=new ArrayList<>();
        d=new int[n+1];
        for(int i=0;i<m;i++)
        {
            int u=in.nextInt();
            int v=in.nextInt();
            g[u].add(v);
            g[v].add(u);
            d[u]++;
            d[v]++;
            union(u,v);
        }
        vis=new boolean[n+1];
        for(int i=1;i<=n;i++)
        {
            if(!vis[i])
            {
                ArrayList<Integer> pv=new ArrayList<>();
                int cnt=dfs1(i,0,pv);
                while(cnt>2)
                {
                    ArrayList<Integer> fg=new ArrayList<>();
                    for(int x:pv)
                    {
                        cnt--;
                        for(int nd:g[x])
                        {
                            d[nd]--;
                            if(d[nd]==1)
                                fg.add(nd);
                        }
                    }
                    pv=fg;
                }
                int cent=pv.get(0);
                rt=0;
                int mad=dfs(cent,0)-1;
                cen[find(cent)]=cent;
                md[find(cent)]=mad;
               
               
                mmd[find(cent)]=rt-1;
            }
        }
        for(int i=0;i<q;i++)
        {
            int t=in.nextInt();
            if(t==1)
            {
                int x=in.nextInt();
                out.println(mmd[find(x)]);
            }
            else
            {
                union(in.nextInt(),in.nextInt());
            }
        }
        
        out.close();
    }
    static int rt;
    static int dfs(int node,int p)
    {
        int m1=0,m2=0;
        for(int x:g[node])
            if(x!=p)
            {
                int mx=dfs(x,node);
                if(mx>=m1)
                {
                    m2=m1;
                    m1=mx;
                }
                else if(mx>=m2)
                    m2=mx;
               
            }
        rt=Math.max(rt,1+m1+m2);
        
                
        return 1+m1;
    }
    
}

import java.util.*;import java.io.*;import java.math.*;
public class Main
{
    public static void process()throws IOException
    {
        long x1=nl();
        long y1=nl();
        long x2=nl();
        long y2=nl();
        TreeMap<Long, Integer> map = new TreeMap<>();
        long src=(x1*(long)1e10)+y1;
        long dest=(x2*(long)1e10)+y2;
        ArrayList<Long>list=new ArrayList<>();
        list.add(src);
        map.put(src,1);
        list.add(dest);
        map.put(dest,2);
        int n=ni();
        int curr=3;
        while(n-->0)
        {
            long x=nl();
            long st=nl();
            long en=nl();
            for(long i=st;i<=en;i++)
            {
                if(map.get((x*(long)1e10)+i)==null)
                {
                    list.add((x*(long)1e10)+i);
                    map.put((x*(long)1e10)+i,curr++);
                }
            }
        }
        Graph g=new Graph(curr);
        int[]dir={1,0,-1};
        for(int i=0;i<list.size();i++)
        {
            long item=list.get(i);
            int ind1=map.get(item);
            long x=item/(long)1e10;
            long y=item%(long)1e10;
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                {
                    long item2=(x+dir[j])*(long)1e10+(y+dir[k]);
                    if(map.get(item2)!=null)
                    {
                        int ind2=map.get(item2);
                        g.addDirEdge(ind1,ind2);
                    }
                }
            }
        }
        pn(bfs(g,map.get(src),map.get(dest),list.size()));
    }
    static int bfs(Graph g,int src,int dest,int n)
    {
        int[]lev=new int[n+1];
        Arrays.fill(lev,n+10);
        lev[src]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty())
        {
            int x=q.poll();
            for(Integer v:g.adj[x])
            {
                if(lev[x]+1<lev[v])
                {
                    q.add(v);
                    lev[v]=lev[x]+1;
                }
            }
        }
        if(lev[dest]==n+10)
            return -1;
        else return lev[dest];
    }
    static class Graph
    {
        static ArrayList<Integer>adj[];
        boolean vis[];
        Graph(int n)
        {
            adj=new ArrayList[n+1];
            vis=new boolean[n+1];
            for(int i=0;i<n+1;i++)
                adj[i]=new ArrayList<>();
        }
        static void addEdge(int u,int v)
               {adj[u].add(v);adj[v].add(u);}
        static void addDirEdge(int u,int v)
            {adj[u].add(v);}
    }
    
    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        if(oj){sc=new AnotherReader();out=new PrintWriter(System.out);}
        else{sc=new AnotherReader(100);out=new PrintWriter("output.txt");}
        int t=1;
        // t=ni();
        while(t-->0) {process();}
        out.flush();out.close();  
    }

    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static int[] nai(int N)throws IOException{int[]A=new int[N];for(int i=0;i!=N;i++){A[i]=ni();}return A;}
    static long[] nal(int N)throws IOException{long[]A=new long[N];for(int i=0;i!=N;i++){A[i]=nl();}return A;}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}

/////////////////////////////////////////////////////////////////////////////////////////////////////////

    static class AnotherReader{BufferedReader br; StringTokenizer st;
    AnotherReader()throws FileNotFoundException{
    br=new BufferedReader(new InputStreamReader(System.in));}
    AnotherReader(int a)throws FileNotFoundException{
    br = new BufferedReader(new FileReader("input.txt"));}
    String next()throws IOException{
    while (st == null || !st.hasMoreElements()) {try{
    st = new StringTokenizer(br.readLine());}
    catch (IOException  e){ e.printStackTrace(); }}
    return st.nextToken(); } int nextInt() throws IOException{
    return Integer.parseInt(next());}
    long nextLong() throws IOException
    {return Long.parseLong(next());}
    double nextDouble()throws IOException { return Double.parseDouble(next()); }
    String nextLine() throws IOException{ String str = ""; try{
    str = br.readLine();} catch (IOException e){
    e.printStackTrace();} return str;}}
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
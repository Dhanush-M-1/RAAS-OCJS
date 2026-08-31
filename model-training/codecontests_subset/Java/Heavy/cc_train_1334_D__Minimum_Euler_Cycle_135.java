import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
//BigInteger A;
//A= BigInteger.valueOf(54);
//ArrayList<Integer> a=new ArrayList<>();
//TreeSet<Integer> ts=new TreeSet<>();
//HashMap<Integer,Integer> hm=new HashMap<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
public final class Practice
{
    static ArrayList<Integer> dfsorder;
    static int child[];
    //static int c=0;
    public static void dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int u)
    {
        vis[u]=true;
        dfsorder.add(u);
        child[u]=1;
        for(int i=0;i<adj.get(u).size();i++)
        {
            if(!vis[adj.get(u).get(i)])
            {
                dfs(adj,vis,adj.get(u).get(i));
                child[u]+=child[adj.get(u).get(i)];
            }
        }
    }
    public static void main(String[]args)throws IOException
    {
        int K=(int)Math.pow(10,9)+7;
        FastReader ob=new FastReader();
        int t=ob.nextInt();
        while(t-->0)
        {
            long n=ob.nextLong();
            long l=ob.nextLong();
            long r=ob.nextLong();
            ArrayList<Long> a=new ArrayList<>();
            long k=0;
            while(l>2*(n-1)&&n>0)
            {
                l-=2*(n-1);
                r-=2*(n-1);
                ++k;
                --n;
            }
            while(l<=2*(n-1)&&n>0)
            {
                for(long i=l;i<=Math.min(r,2*n-2);i++)
                {
                    if(i%2!=0)
                    a.add(1+k);
                    else
                    a.add((i/2)+1+k);
                }
                l=1;
                r-=2*(n-1);
                ++k;
                --n;
            }
            if(r==1)
            a.add(1l);
            for(int i=0;i<a.size();i++)
            System.out.print(a.get(i)+" ");
            System.out.println();
        }
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e)  {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    public String nextLine()
    {
        String s="";
        try {
        s=br.readLine();
        } catch (IOException e)  {
                e.printStackTrace();
            }
        return s;
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
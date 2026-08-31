//package sumo;
import java.io.*;
import java.util.*;

public class Tester {
	static TreeSet<Integer> tr[];
	static int k,n,m,cnt=0;
	static Queue<Integer> q;
	static TreeSet<Integer>glo;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FastReader s=new FastReader();
		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
		 n=s.nextInt();
	     m=s.nextInt();
		 k=s.nextInt();
		Edge e[]=new Edge[m+1];
		tr=new TreeSet[n+1];
		for(int j=1;j<=n;j++)
			tr[j]=new TreeSet<Integer>();
		 glo=new TreeSet<Integer>();
		for(int j=1;j<=n;j++)
			glo.add(j);
		int x,y;
		for(int j=1;j<=m;j++)
		{
			x=s.nextInt();
			y=s.nextInt();
			e[j]=new Edge(x,y);
			tr[x].add(y);
			tr[y].add(x);
		}
		int ans=0;
		for(int j=1;j<=n;j++)
		{
			if(tr[j].size()<k)
				reduce(j);	
		}
		/*
		for(int j=1;j<=n;j++)
		{
			if(tr[j].size()>=k)
				ans++;
		}*/
		//System.out.println(ans);
		int fri[]=new int[m+1];
		int ind;
		fri[m]=glo.size();
		ind=m-1;
		for(int j=m;j>1;j--)
		{
			x=e[j].x;
			y=e[j].y;
			//cnt=0;
			if(tr[x].contains(y) && tr[y].contains(x))
			{
				//System.out.println("hiii");
				tr[x].remove(y);
				tr[y].remove(x);
				if(glo.contains(x) && tr[x].size()<k)
					reduce(x);
				if(glo.contains(y) && tr[y].size()<k)
					reduce(y);
				fri[ind--]=glo.size();
				if(glo.size()==0)
					break;
				
			}
			else
			{
				//System.out.println("hello");
				fri[ind--]=glo.size();
			}
		//	System.out.println(glo.toString());
		}
		for(int j=1;j<=m;j++)
			log.write(fri[j]+"\n");
		log.flush();
		
	}
	public static void reduce(int x)
	{
		//cnt++;
		int get;glo.remove(x);
		while(tr[x].size()>0)
		{
			get=tr[x].first();
			tr[get].remove(x);
			tr[x].remove(get);
			if( glo.contains(get) && tr[get].size()<k)
				reduce(get);
		}
	
	}

}
class Edge
{
	int x;
	int y;
	public Edge(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                 InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}
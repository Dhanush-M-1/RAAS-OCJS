import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class zizo {
	
	static int[] dx = {0, 0, 1, -1 ,1,1,-1,-1};
	static int[] dy = {1, -1, 0, 0,-1,1,-1,1};
	
	public static void main(String[]args) throws IOException {
		Scanner zizo=new Scanner(System.in);
		PrintWriter wr=new PrintWriter(System.out);
		
		int x0=zizo.nextInt();
		int y0=zizo.nextInt();
		int x1=zizo.nextInt();
		int y1=zizo.nextInt();
		int n=zizo.nextInt();
		TreeMap<Integer, TreeSet<Integer>>m=new TreeMap<>();
		for(int i=0;i<n;i++) {
			int row =zizo.nextInt();
			int l=zizo.nextInt();
			int r=zizo.nextInt();
			if(!m.containsKey(row))m.put(row, new TreeSet<>());
			for(int j=l;j<=r;j++) {
				m.get(row).add(j);
			}
		}
		Queue<Edge>q=new LinkedList<>();
		TreeMap<Integer, TreeSet<Integer>>visited=new TreeMap<>();
		q.add(new Edge(x0,y0,0));
		long r=-1;
		while(!q.isEmpty()) {
			Edge u=q.poll();
			//System.out.println(u.x+" "+u.y+" "+u.cost);
			if(u.x==x1&&u.y==y1) {
				r=u.cost;
				break;
			}
			for(int i=0;i<8;i++) {
				int x=u.x+dx[i];
				int y=u.y+dy[i];
				if(m.get(x) != null && m.get(x).contains(y) && (visited.get(x) == null ||  !(visited.get(x).contains(y)))) {
					//System.out.println("efe");
					if(visited.get(x)==null)visited.put(x,new TreeSet<>());
					visited.get(x).add(y);
					q.add(new Edge(x,y,u.cost+1));
				}	
			}
		}
		wr.println(r);
		wr.flush();wr.close();
	}
}

class Edge{
	int x,y;long cost;
	Edge(int a,int b,long c){x=a;y=b;cost=c;}
}


class Scanner 
{
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public String next() throws IOException 
	{
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public double nextDouble() throws IOException
	{
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if(x.charAt(0) == '-')
		{
			neg = true;
			start++;
		}
		for(int i = start; i < x.length(); i++)
			if(x.charAt(i) == '.')
			{
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			}
			else
			{
				sb.append(x.charAt(i));
				if(dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg?-1:1);
	}

	public boolean ready() throws IOException {return br.ready();}
}
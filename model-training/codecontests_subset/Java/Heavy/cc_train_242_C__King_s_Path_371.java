import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.concurrent.PriorityBlockingQueue;

public class B {
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter wr = new PrintWriter(System.out);
		int x0=sc.nextInt()-1;
		int y0=sc.nextInt()-1;
		int x1=sc.nextInt()-1;
		int y1=sc.nextInt()-1;
		int n=sc.nextInt();
		TreeMap<cell, Integer>map=new TreeMap<>();
		for(int i=0;i<n;i++) {
			int row=sc.nextInt()-1;int l=sc.nextInt()-1;int r=sc.nextInt()-1;
			for(int j=l;j<=r;j++) {
				map.put(new cell(row, j), -1);
			}
		}
		int dist=-1;
		Queue<cell>q=new LinkedList<>();
		cell start=new cell(x0, y0);
		q.add(start);
		map.put(start, 0);
		int dx[]= {1,-1,0,0,1,1,-1,-1};
		int dy[]= {0,0,1,-1,1,-1,-1,1};
		
		while(!q.isEmpty()) {
			cell o=q.poll();
			
			int d=map.get(o);
			if(o.x==x1 && o.y ==y1) {
				dist=d;break;
			}
			for(int  i=0;i<8;i++) {
				int X=o.x+dx[i];
				int Y=o.y+dy[i];
				cell nxt=new cell(X,Y);
				if(map.getOrDefault(nxt, 0)==-1) {
					
					q.add(nxt);
					map.put(nxt, d+1);
				}
			}
			
		}
		System.out.println(dist);
		
		wr.close();
	
	
	}
	
}
class cell implements Comparable<cell>{
	int x,y;
	cell(int x,int y){
		this.x = x;
		this.y = y;
		
	}
	@Override
	public int compareTo(cell o) {
		// TODO Auto-generated method stub
		return o.x-x!=0?o.x-x:o.y-y;
	}
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

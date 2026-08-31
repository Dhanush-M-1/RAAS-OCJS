import java.io.*;

import java.util.*;

public class C {
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int x0=sc.nextInt(),y0=sc.nextInt(),x1=sc.nextInt(),y1=sc.nextInt();
		TreeMap<Point,Integer> map=new TreeMap();
		int n=sc.nextInt();
		while(n-->0)
		{
			int r=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt();
			for(int i=a;i<=b;i++)
				map.put(new Point(r,i),-1);
		}
		Point start=new Point(x0,y0);
		map.put(start, 0);
		int []di= {1,-1,0,0,1,1,-1,-1};
		int []dj= {0,0,1,-1,1,-1,-1,1};
		
		Queue<Point> q=new LinkedList();
		q.add(start);
		while(!q.isEmpty())
		{
			Point curr=q.poll();
			
			int i=curr.r;
			int j=curr.c;
			int d=map.get(curr);
			if(i==x1 && j==y1)
			{
				System.out.println(d);
				return;
			}
			
			for(int k=0;k<di.length;k++)
			{
				int ii=i+di[k];
				int jj=j+dj[k];
				Point nxt=new Point(ii,jj);
				if(map.getOrDefault(nxt, 0)==-1)
				{
					map.put(nxt,d+1);
					q.add(nxt);
				}
					
			}
		}
		System.out.println(-1);
		
		pw.close();
		
	}
	static class Point implements Comparable<Point>
	{
		int r,c;
		Point(int a,int b)
		{
			r=a;c=b;
		}
		
		public int compareTo(Point other) {
			if(r!=other.r)
				return r-other.r;
			else
				return c-other.c;
		}
		
	}
	static class Scanner 
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
		
		
		
		public boolean ready() throws IOException {return br.ready();}


	}
}
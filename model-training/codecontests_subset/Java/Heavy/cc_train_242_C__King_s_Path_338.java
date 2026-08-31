//package CodeForces;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Problem_242C {
	static HashSet<Point>hs;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		hs=new HashSet<>();
		Point start=new Point(sc.nextInt(), sc.nextInt());
		Point finish=new Point(sc.nextInt(), sc.nextInt());
		int n=sc.nextInt();
		while(n-->0)
		{
			int x=sc.nextInt(),s=sc.nextInt(),e=sc.nextInt();
			for(int i=s;i<=e;i++)
				hs.add(new Point(x, i));
		}
		pw.println(dijkstra_grid(start, finish));
		pw.close();
	}
	public static boolean valid(int i,int j)
	{
		return i<=(int)1e9 && i>=0 && j<=(int)1e9 && j>=0;		
	}
	public static int dijkstra_grid(Point s,Point e)
	{
		Queue<Point>q=new LinkedList<>();
		int[] dx= {-1,1,0,0,1,-1,-1,1};
		int[] dy= {0,0,-1,1,1,-1,1,-1};
		HashMap<Point, Integer>dist=new HashMap<>();
//		for(int []a:dist)
//			Arrays.fill(a, (int)1e9);
//		dist[i][j]=0;
		q.add(s);
		dist.put(s, 0);
		while(!q.isEmpty())
		{
			Point cur=q.poll();
			int ci=cur.x,cj=cur.y;
			for(int k=0;k<8;k++)
			{
				int x=ci+dx[k],y=cj+dy[k];
				Point nxt=new Point(x, y);
				if(valid(x,y)&& hs.contains(nxt) && dist.get(cur)+1<dist.getOrDefault(nxt,(int)1e9))//we are not checking about visited we check if it is block
				{
					q.add(nxt);
					dist.put(nxt, dist.get(cur)+1);
//					qi.add(x);
//					qj.add(y);
//					grid[x][y]='X';
//					dist[x][y]=dist[ci][cj]+1;
				}
			}
//			System.out.println(dist);
		}
		return dist.getOrDefault(e, -1);
	}
	static class Graph
	{
		char[][]grid;
		boolean[]visited;
		int size;
		@SuppressWarnings("unchecked")
		public Graph(int size)
		{
			this.size=size;
			grid=new char[size][size];
			for(int i=0;i<size;i++)
				Arrays.fill(grid[i], 'X');
			visited=new boolean[size];
		}
		public void add(int r,int s,int e)
		{
			for(int i=s;i<=e;i++)
				grid[r][i]='.';
		}
		//Float_Fill
		public void dfs2(int i,int j)
		{ 
			int[] dx= {-1,1,0,0,1,-1,-1,1};
			int[] dy= {0,0,-1,1,1,-1,1,-1};
			grid[i][j]='X';// Visited
			for(int k=0;k<4;k++)
			{
				int x=i+dx[k],y=j+dy[k];
				if(valid(x,y)&&grid[x][y]!='X')
					dfs2(x,y);
			}
				
		}
		public boolean valid(int i,int j)
		{
			return i<size && i>=0 && j<size && j>=0;		
		}
		public int dijkstra_grid(int i,int j,int end_i,int end_j)
		{
			Queue<Integer>qi=new LinkedList<>(),qj=new LinkedList<>();
			qi.add(i);qj.add(j);
			grid[i][j]='X';
			int[] dx= {-1,1,0,0,1,-1,-1,1};
			int[] dy= {0,0,-1,1,1,-1,1,-1};
			int dist[][]=new int[size][size];
			for(int []a:dist)
				Arrays.fill(a, (int)1e9);
			dist[i][j]=0;
			while(!qi.isEmpty())
			{
				int ci=qi.poll(),cj=qj.poll();
				for(int k=0;k<4;k++)
				{
					int x=ci+dx[k],y=cj+dy[k];
					if(valid(x,y)&& grid[x][y]!='X' && dist[ci][cj]+1<dist[x][y])//we are not checking about visited we check if it is block
					{
						qi.add(x);
						qj.add(y);
//						grid[x][y]='X';
						dist[x][y]=dist[ci][cj]+1;
					}
				}
			}
			return dist[end_i][end_j];
//			for(int[]a:dist)
////				System.out.println(Arrays.toString(a));
//				printRow(a);
		}
	}
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean hasnext() throws IOException {
			return br.ready();
		}

	}
}

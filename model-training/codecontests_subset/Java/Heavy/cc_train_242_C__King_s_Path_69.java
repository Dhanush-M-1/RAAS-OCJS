import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int x0 , y0 , x1 , y1 , n , size;
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {1,1,0,-1,-1,-1,0,1};
	static HashMap<Integer,HashSet<Integer>> nodes;
	
	static int bfs()
	{
		HashMap<Integer, Integer> xToIdx = new HashMap<Integer, Integer>();
		
		int idx = 1;
		
		HashMap<Integer, Integer>[] dist = new HashMap[size];
		for (int i = 0; i < dist.length; i++) 
		{
			dist[i] = new HashMap<Integer, Integer>();
			
		}
		
		xToIdx.put(x0, 0);	
		
		
		dist[0].put(y0, 0);
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x0,y0));
		
		while(!q.isEmpty())
		{
			Pair cur = q.poll();
			int x = cur.x , y = cur.y;
			int nd = dist[xToIdx.get(x)].get(y) + 1;
			for (int i = 0; i < dx.length; i++) 
			{
				int nx = x+dx[i] , ny = y + dy[i];
				if(!available(nx, ny))continue;


				if(xToIdx.containsKey(nx))
				{
					int ind = xToIdx.get(nx);
					if(dist[ind].containsKey(ny))
					{
						int d = dist[ind].get(ny);
						if(nd<d)
						{
							dist[ind].put(ny, nd);
							q.add(new Pair(nx,ny));
						}
					}
					else
					{
						dist[ind].put(ny, nd);
						q.add(new Pair(nx,ny));
					}
				}
				else
				{
					xToIdx.put(nx, idx);
					
					dist[idx++].put(ny, nd);
					q.add(new Pair(nx,ny));
				}
			}
		}
		if(!xToIdx.containsKey(x1))
			return -1;
		return dist[xToIdx.get(x1)].get(y1);
	}
	
	static boolean available(int x,int y){return nodes.containsKey(x) && nodes.get(x).contains(y);}
	
	static class Pair {
		int x,y;
		public Pair(int a ,int b) {x = a; y = b;}
	}
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner((System.in));
		x0 = sc.nextInt();
		y0 = sc.nextInt();
		x1 = sc.nextInt(); 
		y1 = sc.nextInt();
		
		n = sc.nextInt();
		
		nodes = new HashMap<Integer, HashSet<Integer>>();
		size = 0;
		
		for (int i = 0; i < n; i++) 
		{
			int r = sc.nextInt() , a = sc.nextInt() , b = sc.nextInt();
			if(!nodes.containsKey(r))
				nodes.put(r, new HashSet<Integer>());			
			for(int j = a; j <=b;j++)
			{
				if(!nodes.get(r).contains(j))
					size++;
				nodes.get(r).add(j);
			}
		}
		
		System.out.println(bfs());
	}
	
	
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(s));
		}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public String nextLine() throws IOException {return br.readLine();}		
		public long nextLong() throws IOException {return Long.parseLong(next());}		
		public double nextDouble() throws IOException {return Double.parseDouble(next());}	
		public boolean ready() throws IOException {return br.ready();}
	}

}
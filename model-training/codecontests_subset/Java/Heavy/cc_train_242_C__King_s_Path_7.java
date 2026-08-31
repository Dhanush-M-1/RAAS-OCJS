import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class C242 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int y0 = sc.nextInt(), x0 = sc.nextInt(), y1 = sc.nextInt(), x1 = sc.nextInt();
		
		int n = sc.nextInt();
		
		TreeMap<Integer, TreeSet<Integer>> graph = new TreeMap<>();
		TreeMap<Integer, TreeSet<Integer>> visited = new TreeMap<>();
		
		while(n-->0)
		{
			int row = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt();
			
			if(!graph.containsKey(row))
				graph.put(row, new TreeSet<>());
			
			TreeSet<Integer> set = graph.get(row);
			for(int i = l;i<=r;i++)
				set.add(i);
		}
		
		int steps = -1;
		
		//System.out.println(graph);
		Queue<Cell> q = new LinkedList<>();
		q.add(new Cell(x0,y0,0));
		
		visited.put(y0, new TreeSet<>());
		visited.get(y0).add(x0);
		
		int[] x = {-1,0,1,-1,1,-1,0,1};
		int[] y = {-1,-1,-1,0,0,1,1,1};
		
		while(!q.isEmpty())
		{
			Cell cur = q.poll();
			
			
			
			if(cur.x==x1&cur.y==y1)
			{
				steps = cur.d;
				break;
			}
			
			for(int i = 0;i<8;i++)
			{
				//System.out.println((cur.x+x[i])+" "+(cur.y+y[i])+" "+(graph.containsKey(cur.y+y[i])&&graph.get(cur.y+y[i]).contains(cur.x+x[i])));
				if((!visited.containsKey(cur.y+y[i])||!visited.get(cur.y+y[i]).contains(cur.x+x[i]))&(graph.containsKey(cur.y+y[i])&&graph.get(cur.y+y[i]).contains(cur.x+x[i])))
				{
					if(!visited.containsKey(cur.y+y[i]))
						visited.put(cur.y+y[i], new TreeSet<>());
					
					visited.get(cur.y+y[i]).add(cur.x+x[i]);
					
					q.add(new Cell(cur.x+x[i],cur.y+y[i],cur.d+1));
				}
			}
			
		}
		
		System.out.println(steps);
		
	}
	static class Cell{
		int x,y,d;
		Cell(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
		public String toString(){
			return x+" "+y;
		}
	}
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {	br = new BufferedReader(new InputStreamReader(s));}

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
}

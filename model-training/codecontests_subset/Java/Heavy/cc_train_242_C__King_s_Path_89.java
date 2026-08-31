
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class King_s_Path_CF149_Div2 {
	static Scanner sc;
	static PrintWriter out;
	// in a Grid I want to move from point to a point in shortest path and only specific cells are allowed
	// I will save the allowed cells
	static TreeSet<Pair> allowed;
	static TreeMap<Pair,Integer> len;
	static Queue<Pair> q;
	
	public static void main(String[] args) throws Exception{
		sc =new Scanner(System.in);
		
		allowed = new TreeSet<Pair>();
		len = new TreeMap<Pair,Integer>();
		q = new LinkedList<Pair>();
		int x1=sc.nextInt(),y1=sc.nextInt(),x2=sc.nextInt(),y2=sc.nextInt();
		int segs = sc.nextInt();
		while(segs-->0)
		{
			int r=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt();
			for(int i=a;i<=b;i++)
				allowed.add(new Pair(r,i));
		}
		
		Pair start = new Pair(x1,y1);
		Pair end = new Pair(x2,y2);
		len.put(start, 0);
		q.add(start);
				//n, ne, e, se, s, sw, w, nw
		int[] dx = {-1,-1,0,1,1,1,0,-1};
		int[] dy = {0,1,1,1,0,-1,-1,-1};
		
		while(!q.isEmpty())
		{
			Pair u = q.poll();
			int x =u.x,y =u.y;
			
			for(int i=0;i<8;i++)
			{
				int nx = x+dx[i],ny = y+dy[i];
				Pair v = new Pair(nx,ny);
				
				if(!allowed.contains(v) || /*visited*/ len.containsKey(v))
					continue;
				
				if(v.compareTo(end)==0)
				{
					System.out.println(len.get(u)+1);
					return;
				}
				
				q.add(v);
				len.put(v, len.get(u)+1);
			}
		}
		System.out.println(-1);
	}
	
	static class Pair implements Comparable<Pair>{

		int x,y;
		public Pair(int a,int b) {
			x=a;y=b;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.x==o.x)
				return this.y-o.y;
			return this.x-o.x;
		}
		
		
	}
	static class Scanner{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}
		public Scanner(FileReader file) {
			br = new BufferedReader(file);
		}
		public String next() throws IOException {
			while(st == null || !st.hasMoreTokens())
			{
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}
		public String nextLine() throws IOException {
			return br.readLine();
		}
		public int nextInt()throws IOException{
			return Integer.parseInt(next());
		}
		public double nextDouble()throws IOException{
			return Double.parseDouble(next());
		}
		public char nextChar()throws IOException{
			return next().charAt(0);
		}
		public long nextLong()throws IOException{
			return Long.parseLong(next());
		}
		public boolean ready() throws IOException {
			return br.ready();
		}
		public void waitForInput() throws InterruptedException {
			Thread.sleep(5000);
		}
	}
}

import java.io.*;
import java.math.BigInteger;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;
public class Problem2 {
	static Scanner sc=new Scanner(System.in);
	static final double EPS = 1e-9;
	static ArrayList<Integer> adj[];
	static boolean railway[][];
	static int dx[] = {1,1,0,-1,-1,-1, 0, 1};
	static int dy[] = {0,1,1, 1, 0,-1,-1,-1};
	static  TreeSet<Pair> set;
	public static void main(String[] args) throws IOException, InterruptedException {
		 PrintWriter out=new PrintWriter(System.out);
		 int x0=sc.nextInt();
		 int y0=sc.nextInt();
		 int x1=sc.nextInt();
		 int y1=sc.nextInt();
		 int n=sc.nextInt();
		 set=new TreeSet<Pair>();
		 while(n-->0) {
			 int r=sc.nextInt();
			 int a=sc.nextInt();
			 int b=sc.nextInt();
			for(int i=a;  i<=b ; i++) {
				set.add(new Pair(r,i));
			} 
		 }
		 map=new TreeMap<>();
		 Queue<Pair> q = new LinkedList<Pair>();
		 q.add(new Pair(x0, y0));
		map.put(new Pair(x0,y0),0);				

			while(!q.isEmpty())
			{
				Pair p=q.poll();
				for(int i=0 ; i<8 ;i++) {
					int x=dx[i];
					int y=dy[i];
					int x2=p.u+x;
					int y2=p.v+y;
					if(x1==p.u && y1== p.v) {
						System.out.println(map.get(p));
						return;
					}
						
					
					if(valid(x2,y2)) {
						q.add(new Pair(x2,y2));
						map.put(new Pair(x2, y2), map.getOrDefault(p,0)+1);
					
					}
				}
						
			}
			System.out.println(-1);

		 
		 
	}
	static  TreeMap<Pair,Integer> map;
	static int cap=(int) 1e9;
	private static boolean valid(int x2, int y2) {
		if(x2<cap&&y2<cap&&x2>0&&y2>0&&set.contains(new Pair(x2, y2))&&!map.containsKey(new Pair(x2, y2))) {
			return true;
		}
		return false;
	}
	static class Pair implements Comparable<Pair>{
		int u;
		int v;
		public Pair(int u1,int v1) {
			u=u1;
			v=v1;
		}

		public int compareTo(Pair p) {
			if (u - p.u == 0)
				return v - p.v;
			return u- p.u;
		}
	}
	static int n1;
	static  boolean visited[];
	
	static final int INF = (int)1e9;	//don't increase, avoid overflow
	static ArrayList<Edge>[] edgejList;
	
/**	static int dijkstra(int S, int T)	//O(E log E)
	{
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist[S] = 0;
		pq.add(new Edge(S, 0));						//may add more in case of MSSP (Mult-Source)
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();
			if(cur.node == T)						//remove if all computations are needed
				return dist[T];
			if(cur.w > dist[cur.node])			//lazy deletion
				continue;
			for(Edge nxt: edgeList[cur.node])
				if(cur.w + nxt.w < dist[nxt.node])
					pq.add(new Edge(nxt.node, dist[nxt.node] = cur.w+ nxt.cost ));
		}
		return -1;
	}**/
	
	static Edge[] edgeList;
	static int V;

	static int kruskal()		//O(E log E)
	{
		int mst = 0;
		Arrays.sort(edgeList);
		UnionFind uf = new UnionFind(V);

		for(Edge e: edgeList)
			if(uf.union(e.node, e.v))
				mst += e.w;
		return mst;
	}

	static class Edge implements Comparable<Edge>
	{
		int node, v, w;

		Edge(int a, int b, int c) {	node= a; v = b; w = c; }

		public int compareTo(Edge e) { return w - e.w; }
	}

	static class UnionFind {                                              
		int[] p, rank;

		UnionFind(int N) 
		{
			p = new int[N];
			rank = new int[N];
			for (int i = 0; i < N; i++) 
				p[i] = i;
		}

		int findSet(int x) { return p[x] == x ? x : (p[x] = findSet(p[x])); }

		boolean union(int x, int y) 
		{ 
			x = findSet(x);
			y = findSet(y);
			if(x == y)
				return false;

			if (rank[x] > rank[y]) 
				p[y] = x;
			else
			{	
				p[x] = y;
				if(rank[x] == rank[y])
					++rank[y]; 
			} 
			return true;
		}
	}
	static int numPF(int N)
	{
		int ans = 0, idx = 0, p = primes.get(0);
		while(p * p <= N)
		{
			while(N % p == 0) { N /= p; ++ans; }
			p = primes.get(++idx);
		}
		if(N != 1)
			++ans;
		return ans;
	}
	static ArrayList<Integer> div=new ArrayList<>();

	static boolean Limit(int b, int e)	
	{
		return b + EPS < Math.pow(2, 64.0 / e);
	}
	static int numDivs(int N)
	{
		int ans = 0;
		for(int i = 1; i * i <= N; ++i)
			if(N % i == 0)
			{
				++ans;
				
				if(N / i != i) 
					++ans;
				
			}
		return ans;
	}
	static boolean isPrime(int N)
	{
		if(N <= 1e6)
			return !isComposite[N];
		for(int p: primes)
			if(p * p > N)
				break;
			else if(N % p == 0)
				return false;
		return true;
	}
	static ArrayList<Integer> primes;
	static TreeSet<Integer> primes1;
	static HashMap<Integer,Integer> prime;
	static boolean[] isComposite;
	static int primus[]=new int[664579];
	static void sieve(int N)	// O(N log log N) 
	{
		isComposite = new boolean[N+1];					
		isComposite[0] = isComposite[1] = true;			// 0 indicates a prime number
		primes = new ArrayList<Integer>();
		primes1=new TreeSet<>();
		int nxt = 0;
        for (int i = 2; i <= N; ++i) 					//can loop till i*i <= N if primes array is not needed O(N log log sqrt(N)) 
			if (isComposite[i] == false) 					//can loop in 2 and odd integers for slightly better performance
			{
				primes.add(i); 
				primes1.add(i);
				primus[nxt++] = i;
				if(1l * i * i <= N)
					for (int j = i * i; j <= N; j += i)	// j = i * 2 will not affect performance too much, may alter in modified sieve
						isComposite[j] = true;
			}   
	}

static	 class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}

	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public int[] nextIntArr(int n) throws IOException {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextInt();
		return arr;
	}

	public long[] nextLongArr(int n) throws IOException {
		long[] arr = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextLong();
		return arr;
	}

	public long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public boolean ready() throws IOException {
		return br.ready();
	}
	public void waitForInput() throws InterruptedException {Thread.sleep(2000);}
}
	
}
 class Dsu {
	int[] p, rank, setSize;
	int numSets;

	public Dsu(int N) 
	{
		
		numSets = N;
		p = new int[N];
		rank = new int[N];
		setSize = new int[N];
		Arrays.fill(setSize, 1);
		for (int i = 0; i < N; i++) 
			p[i] = i; 
	
	}

	public int findSet(int v) { 
		if (v == p[v])
        return v;
		
    return findSet(p[v]);
	}

	public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

	public void unionSet(int i, int j) 
	{ 
		if (isSameSet(i, j)) 
			return;
		numSets--; 
		int x = findSet(i), y = findSet(j);
		if(setSize[x] > setSize[y]) { 
		p[y] = x;
		setSize[x] += setSize[y]; 
		}
		else
		{	p[x] = y;
		setSize[y] += setSize[x];
		} 
	}

	public int numDisjointSets() { return numSets; }

	public int sizeOfSet(int i) { return setSize[findSet(i)]; }
}




 
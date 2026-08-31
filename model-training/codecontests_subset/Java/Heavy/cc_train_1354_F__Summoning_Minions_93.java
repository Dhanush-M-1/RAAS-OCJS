import java.io.*;
import java.util.*;
public class gym{
	static class Edge {
		int to, f, cap, cost, rev;

		Edge(int to, int cap, int cost, int rev) {
		        this.to = to;
		        this.cap = cap;
		        this.cost = cost;
		        this.rev = rev;
		}
	}

		public static void addEdge(List<Edge>[] graph, int s, int t, int cap, int cost) {
		        graph[s].add(new Edge(t, cap, cost, graph[t].size()));
		        graph[t].add(new Edge(s, 0, -cost, graph[s].size() - 1));
		}

		static void bellmanFord(List<Edge>[] graph, int s, int[] dist) {
		        int n = graph.length;
		        Arrays.fill(dist, Integer.MAX_VALUE);
		        dist[s] = 0;
		        boolean[] inqueue = new boolean[n];
		        int[] q = new int[n];
		        int qt = 0;
		        q[qt++] = s;
		        for (int qh = 0; (qh - qt) % n != 0; qh++) {
		                int u = q[qh % n];
		                inqueue[u] = false;
		                for (int i = 0; i < graph[u].size(); i++) {
		                        Edge e = graph[u].get(i);
		                        if (e.cap <= e.f)
		                                continue;
		                        int v = e.to;
		                        int ndist = dist[u] + e.cost;
		                        if (dist[v] > ndist) {
		                                dist[v] = ndist;
		                                if (!inqueue[v]) {
		                                        inqueue[v] = true;
		                                        q[qt++ % n] = v;
		                                }
		                        }
		                }
		        }
		}

		public static long[] minCostFlow(List<Edge>[] graph, int s, int t, int maxf) {
		        int n = graph.length;
		        int[] prio = new int[n];
		        int[] curflow = new int[n];
		        int[] prevedge = new int[n];
		        int[] prevnode = new int[n];
		        int[] pot = new int[n];

		        bellmanFord(graph, s, pot); // bellmanFord invocation can be skipped if edges costs are non-negative
		        long flow = 0;
		        long flowCost = 0;
		        while (flow < maxf) {
		                PriorityQueue<Long> q = new PriorityQueue<>();
		                q.add((long) s);
		                Arrays.fill(prio, Integer.MAX_VALUE);
		                prio[s] = 0;
		                boolean[] finished = new boolean[n];
		                curflow[s] = Integer.MAX_VALUE;
		                while (!finished[t] && !q.isEmpty()) {
		                        long cur = q.remove();
		                        int u = (int) (cur & 0xFFFF_FFFFL);
		                        int priou = (int) (cur >>> 32);
		                        if (priou != prio[u])
		                                continue;
		                        finished[u] = true;
		                        for (int i = 0; i < graph[u].size(); i++) {
		                                Edge e = graph[u].get(i);
		                                if (e.f >= e.cap)
		                                        continue;
		                                int v = e.to;
		                                int nprio = prio[u] + e.cost + pot[u] - pot[v];
		                                if (prio[v] > nprio) {
		                                        prio[v] = nprio;
		                                        q.add(((long) nprio << 32) + v);
		                                        prevnode[v] = u;
		                                        prevedge[v] = i;
		                                        curflow[v] = Math.min(curflow[u], e.cap - e.f);
		                                }
		                        }
		                }
		                if (prio[t] == Integer.MAX_VALUE)
		                        break;
		                for (int i = 0; i < n; i++)
		                        if (finished[i])
		                                pot[i] += prio[i] - prio[t];
		                int df = Math.min(curflow[t], maxf - (int)flow);
		                flow += df;
		                for (int v = t; v != s; v = prevnode[v]) {
		                        Edge e = graph[prevnode[v]].get(prevedge[v]);
		                        e.f += df;
		                        graph[v].get(e.rev).f -= df;
		                        flowCost += (long)df * e.cost;
		                }
		        }
		        return new long[] {flow, flowCost};
		}
	static void main() throws Exception{
		int n=sc.nextInt(),k=sc.nextInt();
		int[][]in=new int[n][];
		for(int i=0;i<n;i++){
			in[i]=new int[] {sc.nextInt(),sc.nextInt(),i+1};
		}
		int V=2*n+2;
		int s=V-2,t=V-1;
		List<Edge>[]adj=new LinkedList[V];
		for(int i=0;i<V;i++)adj[i]=new LinkedList<Edge>();
		for(int pos=0;pos<n;pos++) {
			for(int i=0;i<n;i++) {
				if(pos<k) {//will not be deleted
					
					addEdge(adj, pos, i+n, 1, -(in[i][0]+(in[i][1]*pos)));
				}
				else {
					addEdge(adj, pos, i+n, 1, -(in[i][1]*(k-1)));
				}
			}
		}
		for(int i=0;i<n;i++) {
			addEdge(adj, i+n, t, 1, 0);
		}
		for(int pos=0;pos<n;pos++) {
			addEdge(adj, s, pos, 1, 0);
		}
		minCostFlow(adj, s, t, n);
		
		pw.println(k+(n-k)*2);
		for(int pos=0;pos<k-1;pos++) {
			int choosen=-1;
			for(Edge e:adj[pos]) {
				if(e.f==1) {
					choosen=e.to-n+1;
				}
			}
			pw.print(choosen+" ");
		}
		for(int pos=k;pos<n;pos++) {
			int choosen=-1;
			for(Edge e:adj[pos]) {
				if(e.f==1) {
					choosen=e.to-n+1;
				}
			}
			pw.print(choosen+" "+(-choosen)+" ");
		}
		int choosen=-1;
		for(Edge e:adj[k-1]) {
			if(e.f==1) {
				choosen=e.to-n+1;
			}
		}
		pw.println(choosen);
	}
	public static void main(String[] args) throws Exception{
		pw=new PrintWriter(System.out);
		sc = new MScanner(System.in);
		int tc=sc.nextInt();
		while(tc-->0)main();
		pw.flush();
	}
	static PrintWriter pw;
	static MScanner  sc;
	static class MScanner {
		StringTokenizer st;
		BufferedReader br;
		public MScanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}
 
		public MScanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}
 
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int[] intArr(int n) throws IOException {
	        int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        return in;
		}
		public long[] longArr(int n) throws IOException {
	        long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        return in;
		}
		public int[] intSortedArr(int n) throws IOException {
	        int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        shuffle(in);
	        Arrays.sort(in);
	        return in;
		}
		public long[] longSortedArr(int n) throws IOException {
	        long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        shuffle(in);
	        Arrays.sort(in);
	        return in;
		}
		public Integer[] IntegerArr(int n) throws IOException {
	        Integer[]in=new Integer[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        return in;
		}
		public Long[] LongArr(int n) throws IOException {
	        Long[]in=new Long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        return in;
		}
		public String nextLine() throws IOException {
			return br.readLine();
		}
 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
 
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
 
		public char nextChar() throws IOException {
			return next().charAt(0);
		}
 
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public boolean ready() throws IOException {
			return br.ready();
		}
 
		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
	static void shuffle(int[]in) {
		for(int i=0;i<in.length;i++) {
			int idx=(int)(Math.random()*in.length);
			int tmp=in[i];
			in[i]=in[idx];
			in[idx]=tmp;
		}
	}
	static void shuffle(long[]in) {
		for(int i=0;i<in.length;i++) {
			int idx=(int)(Math.random()*in.length);
			long tmp=in[i];
			in[i]=in[idx];
			in[idx]=tmp;
		}
	}
}

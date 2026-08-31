import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class E {

	
	static int N;
	static int M;
	static int H;
	static center ar[];
	static int cli[][];
	static ArrayList<Integer> adj[];
	
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		N = in.nextInt();
		M = in.nextInt();
		H = in.nextInt();
		ar = new center[N];
		cli = new int[2][M];
		for(int i = 0; i < N; i++) ar[i] = new center();
		
		for(int i = 0; i < N; i++) {
			ar[i].hour = in.nextInt();
		}
		for(int i = 0; i < M; i++) {
			int p1 = in.nextInt()-1;
			int p2 = in.nextInt()-1;
			cli[0][i]=p1;
			cli[1][i]=p2;			
			ar[p1].clients.add(i);
			ar[p2].clients.add(i);
		}
		boolean hasOut[] = new boolean[N];
		adj = new ArrayList[N];
		for(int i = 0; i < N; i++) adj[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			int nextHour = ar[i].hour+1;
			if(nextHour==H)nextHour=0;
			
			for(Integer c : ar[i].clients) {
				int other = cli[0][c] != i ? cli[0][c] : cli[1][c];
				if(ar[other].hour == nextHour) {
					adj[i].add(other);
					hasOut[i] = true;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(hasOut[i]== false) {
				out.println(1+"\n"+(i+1));
				out.close();
				return;
			}
		}
		
		tarjan t = new tarjan();
		ArrayList<ArrayList<Integer>> scc = t.getSCComponents(adj);

		int best = Integer.MAX_VALUE;
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(ArrayList<Integer> comp : scc) {
			boolean good = true;
			for(Integer node : comp) {
				for(Integer next : adj[node]) {
					if(t.scc[next] != t.scc[node]) {
						good=false;
						break;
					}
				}
				if(good==false)break;
			}
			
			if(good) {
				if(comp.size() < best) {
					best = comp.size();
					res = comp;
				}
			}
		}
		
		out.println(best);
		for(Integer val : res) out.print((val+1)+" ");
		out.close();
		
		
	}
	
	static boolean vis[];
	static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		q.add(start);
		int prev[] = new int[N];
		
	}
	
	static class center{
		int hour;
		ArrayList<Integer> clients;
		public center() {
			clients = new ArrayList<Integer>();
		}
	}

	
	static class tarjan{
	    int V;   //Vertices
	    int preCount;
	    int[] low;
	    boolean[] visited;      
	    ArrayList<Integer>[] graph;	//EdgeList
	    ArrayList<ArrayList<Integer>> sccComp;
	    Stack<Integer> stack;
	    int[] scc;
	    int curSCC;
	    //Get SCC components of an edge list
	    public ArrayList<ArrayList<Integer>> getSCComponents(ArrayList<Integer>[] graph) {
		scc = new int[graph.length];
		curSCC = 0;
		V = graph.length;
		this.graph = graph;
		low = new int[V];
		visited = new boolean[V];
		stack = new Stack<Integer>();
		sccComp = new ArrayList<>();

		for (int v = 0; v < V; v++)
		      if (!visited[v])
			dfs(v);

		return sccComp;
	    }

	    public void dfs(int v) {
		low[v] = preCount++;
		visited[v] = true;
		stack.push(v);
		int min = low[v];
		for (int w : graph[v]) {
		    if (!visited[w])
			dfs(w);
		    if (low[w] < min) 
			min = low[w];
		}
		if (min < low[v])  { 
		    low[v] = min; 
		    return; 
		}        
		ArrayList<Integer> component = new ArrayList<Integer>();
		int w;
		do{
		    w = stack.pop();
		    component.add(w);
		    low[w] = V;  
		    scc[w] = curSCC;
		} while (w != v);
		sccComp.add(component);
		curSCC++;
	    }    
	}
	
	
	
	
static class FastScanner{
	BufferedReader br;
	StringTokenizer st;
	public FastScanner(String s) {
		try{
			br = new BufferedReader(new FileReader(s));
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public FastScanner(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	String nextToken()	{
		while(st == null ||!st.hasMoreElements()){
			try {
			st = new StringTokenizer(br.readLine());}
			catch(IOException e) {
				e.printStackTrace();
			}			
		}
		return st.nextToken();
	}
	
	int nextInt() {
		return Integer.parseInt(nextToken());
	}
	long nextLong() {
		return Long.parseLong(nextToken());
	}
	double nextDouble() {
		return Double.parseDouble(nextToken());
	}
	String next() {
		return nextToken();
	}
	
}

}

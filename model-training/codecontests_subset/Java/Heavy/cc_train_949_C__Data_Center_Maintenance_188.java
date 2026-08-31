import java.io.*;
import java.util.*;

public class E950{

    int[] u;

	ArrayDeque<Integer>[] adj;
	
	private void solve() throws Exception {
        int n = nextInt();
        adj = new ArrayDeque[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayDeque<Integer>();
        int m = nextInt();
        int h = nextInt();
        u = new int[n];
        for(int i = 0; i < n; i++) u[i] = nextInt();
        for(int i = 0; i < m; i++) {
            int c1 = nextInt()-1;
            int c2 = nextInt()-1;
            if((u[c1]+1)%h == u[c2]) adj[c1].addLast(c2);
            if((u[c2]+1)%h == u[c1]) adj[c2].addLast(c1);
        }
		dfs();
		size = new int[componentCount];
		for(int i = 0; i < n; i++) size[comp[i]]++;
		outDegree = new int[n];
		for(int i = 0; i < n; i++) for(int j : adj[i]) if(comp[i] != comp[j]) outDegree[comp[i]]++;
		int best = n;
		int bestIdx = 0;
		for(int i = 0; i < componentCount; i++) if(outDegree[i] == 0 && size[i] < best) {
			bestIdx = i;
			best = size[i];
		}
		out.println(best);
		for(int i = 0; i < n; i++) if(comp[i] == bestIdx) out.print((i+1)+" ");
		out.println();
	}
	

	int[] size;
	int[] outDegree;


    int N;
    ArrayDeque<Integer> stack;
    boolean[] stacked;
    int[] d;
    int[] low;
    int componentCount;
    int[] comp;


    void dfs(){
		N = 1;
		stack = new ArrayDeque<Integer>();
		int n = adj.length;
		stacked = new boolean[n];
		d = new int[n];
		low = new int[n];
		comp = new int[n];
		componentCount = 0;
		for(int i = 0; i < n; i++) if(d[i] == 0) visit(i);
	}

	void visit(int u){
		stack.addLast(u);
		stacked[u] = true;
		d[u] = N++;
		low[u] = d[u];
		for(int v:adj[u]){
			if(d[v] == 0){
				visit(v);
				low[u] = Math.min(low[u], low[v]);
			}else if(stacked[v]) low[u] = Math.min(low[u], d[v]);
		}
		if(low[u] == d[u]) {
            while(true) {
                int v = stack.removeLast();
                comp[v] = componentCount;
                stacked[v] = false;
                if(v == u) break;
            }
            componentCount++;
		}
	}
    

	public static void main(String[] args) {
		(new E950()).run();
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer tokenizer;

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
			out = new PrintWriter(System.out);
			solve();
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	private float nextFloat() throws IOException {
		return Float.parseFloat(nextToken());
	}

	private String nextLine() throws IOException {
		return new String(in.readLine());
	}

	private String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(in.readLine());
		}
		return tokenizer.nextToken();
	}


}
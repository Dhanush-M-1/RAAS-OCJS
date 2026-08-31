import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
 
public class Main {
    public static double PI = Math.acos(-1.0);
    public static double eps = 1e-6;	
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        public String next() {
            while(tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
    public static int maxn = (int) (2e5 + 5);
    
    public static class Edge {
        int nxt;
        int to;
        Edge(int _nxt, int _to) {
            nxt = _nxt;
            to = _to;
        }
    }

    public static Edge[] E = new Edge[maxn*2];
    public static int[] head =  new int[maxn];
    public static int[] lnxt =  new int[maxn];
    public static int[] llst =  new int[maxn];
    public static int fst;
    public static int Etot;
    public static int Ctot;
    public static int[] C = new int[maxn];
    public static int[] q = new int[maxn];
    public static int lf;
    public static int rt;
    public static boolean[] vis = new boolean[maxn];
    public static int[] cnt = new int[maxn];
    public static int[] col = new int[maxn];
    public static void addEdge(int u, int v) {
        E[Etot] = new Edge(head[u], v);
        head[u] = Etot++;
    }
    public static void bfs(int x, int n) {
    	lf = rt = 0;
    	q[rt++] = x;
    	col[Ctot] = 0;
    	vis[x] = true;
    	if(x == fst) {
			fst = lnxt[fst];
		} else {
			if(lnxt[x] != -1) llst[lnxt[x]] = llst[x];
			if(llst[x] != -1) lnxt[llst[x]] = lnxt[x];
		}
    	while(lf < rt) {
    		int now = q[lf++];
    		++col[Ctot];
    		for(int i = head[now]; i != -1; i = E[i].nxt) {
    			int to = E[i].to;
    			++cnt[to];
    		}
    		int id = fst;
    		while(id != -1) {
    			if(!vis[id] && cnt[id] == 0) {
    				vis[id] = true;
    				q[rt++] = id;
    				if(id == fst) {
    	    			fst = lnxt[fst];
    	    			if(fst != -1) llst[fst] = -1;
    	    		} else {
    	    			if(lnxt[id] != -1) llst[lnxt[id]] = llst[id];
    	    			if(llst[id] != -1) lnxt[llst[id]] = lnxt[id];
    	    		}
    			}
    			id = lnxt[id];
    		}
    		for(int i = head[now]; i != -1; i = E[i].nxt) {
    			int to = E[i].to;
    			--cnt[to];
    		}
    	}
    	++Ctot;
    }
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = in.nextInt();
        int m = in.nextInt()	;
        llst[1] = -1;
        lnxt[n] = -1;
        Etot = Ctot = lf = rt = 0;
        fst = 1;
        for(int i = 1; i <= n; ++i) {
            head[i] = -1;
            vis[i] = false;
            cnt[i] = 0;
            if(i > 1) llst[i] = i - 1;
            if(i < n) lnxt[i] = i + 1;
        }
        for(int i = 0; i < m; ++i) {
            int u = in.nextInt();
            int v = in.nextInt();
            addEdge(u, v);
            addEdge(v, u);
        }
        for(int i = 1; i <= n; ++i) {
        	if(vis[i]) continue;
        	bfs(i, n);
        }
        Arrays.sort(col, 0, Ctot);
        out.println(Ctot);
//        out.flush();
        for(int i = 0; i < Ctot; ++i) {
        	if(i > 0) out.print(" ");
//            out.flush();
        	out.print(col[i]);
//            out.flush();
        }
        out.println();
        out.flush();
        // Scanner in = new Scanner(System.in);
        // in.close();
    }
}
		  		 						  	  	  		   		 	
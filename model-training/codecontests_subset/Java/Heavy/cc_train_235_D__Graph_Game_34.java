//package round146;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class D {
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	
	void solve()
	{
		int n = ni();
		int[] from = new int[n];
		int[] to = new int[n];
		for(int i = 0;i < n;i++){
			from[i] = ni();
			to[i] = ni();
		}
		
		int[][] g = packU(n, from, to);
		
		int[][] cc = cluster(g);
		int[] clus = cc[0];
		int[][] pars = parents(g, clus);
		int[] par = pars[0];
		int[] dep = pars[2];
		int[] ring = cc[1];
		int[] iring = new int[n];
		Arrays.fill(iring, -1);
		for(int i = 0;i < ring.length;i++)iring[ring[i]] = i;
		
		int[][] sp = sparseParents(par);
		
		double e = 0;
		for(int i = 0;i < n;i++){
			for(int j = i+1;j < n;j++){
				if(clus[i] == clus[j]){
					if(clus[i] == 0){
						int minor = Math.min(iring[i], iring[j]);
						int major = Math.max(iring[i], iring[j]);
						int d1 = major - minor;
						int d2 = ring.length - d1;
						e += 1./(d1+1) + 1./(d2+1) - 1./ring.length;
					}else{
						int lca = lca(i, j, sp, dep);
						e += 1. / (dep[i]+dep[j]-2*dep[lca]+1);
					}
				}else{
					if(clus[j] == 0 && ancestor(i, dep[i], sp) == j){
						e += 1. / (dep[i]+1);
					}else if(clus[i] == 0 && ancestor(j, dep[j], sp) == i){
						e += 1. / (dep[j]+1);
					}else{
						int ai = ancestor(i, dep[i], sp);
						int aj = ancestor(j, dep[j], sp);
						int minor = Math.min(iring[ai], iring[aj]);
						int major = Math.max(iring[ai], iring[aj]);
						int d1 = major - minor;
						int d2 = ring.length - d1;
	//					tr(i, j, ai, aj, d1, d2, dep[i], dep[j]);
						e += 1./(d1+dep[i]+dep[j]+1) + 1./(d2+dep[i]+dep[j]+1) - 1./(dep[i]+dep[j]+d1+d2);
					}
				}
			}
		}
		out.printf("%.12f\n", e*2+n);
	}

	public static int lca(int a, int b, int[][] spar, int[] depth)
	{
		if(depth[a] < depth[b]){
			b = ancestor(b, depth[b]-depth[a], spar);
		}else if(depth[a] > depth[b]){
			a = ancestor(a, depth[a]-depth[b], spar);
		}
		
		int low = -1;
		int high = depth[a];
		while(high - low > 1){
			int x = (low + high) / 2;
			if(ancestor(a, x, spar) == ancestor(b, x, spar)){
				high = x;
			}else{
				low = x;
			}
		}
		return ancestor(a, high, spar);
	}
	
	protected static int ancestor(int a, int m, int[][] spar)
	{
		for(int i = 0;m > 0 && a != -1;m>>>=1,i++){
			if(m%2==1)a = spar[i][a];
		}
		return a;
	}
	
	public static int[][] sparseParents(int[] par)
	{
		int n = par.length;
		int m = Integer.numberOfTrailingZeros(Integer.highestOneBit(n-1))+1;
		int[][] pars = new int[m][n];
		pars[0] = par;
		for(int j = 1;j < m;j++){
			for(int i = 0;i < n;i++){
				pars[j][i] = pars[j-1][i] == -1 ? -1 : pars[j-1][pars[j-1][i]];
			}
		}
		return pars;
	}
	
	public static int[][] cluster(int[][] g)
	{
		int n = g.length;
		int[] clus = new int[n];
		Arrays.fill(clus, -1);
		
		int[] cy = dfs(g, 2, -1, new int[n], new int[n], 0);
		if(cy == null)return null;
		
		// BFS
		int[] q = new int[n];
		int p = 0;
		for(int i = 0;i < cy.length;i++){
			q[p++] = cy[i];
			clus[cy[i]] = 0;
		}
		
		int x = 1;
		for(int r = 0;r < p;r++){
			int nc = clus[q[r]] == 0 ? x++ : clus[q[r]];
			for(int e : g[q[r]]){
				if(clus[e] == -1){
					clus[e] = nc;
					q[p++] = e;
				}
			}
		}
		
		return new int[][]{clus, cy};
	}
	
	public static int[] dfs(int[][] g, int cur, int pre, int[] flag, int[] hist, int dep)
	{
		flag[cur] = dep+1;
		hist[dep] = cur;
		for(int e : g[cur]){
			if(e != pre && flag[e] != -1){
				if(flag[e] >= 1){
					return Arrays.copyOfRange(hist, flag[e]-1, dep+1);
				}else{
					int[] res = dfs(g, e, cur, flag, hist, dep+1);
					if(res != null)return res;
				}
			}
		}
		flag[cur] = -1;
		return null;
	}
	
	public static int[][] parents(int[][] g, int[] clus)
	{
		int n = g.length;
		int[] par = new int[n];
		Arrays.fill(par, -1);
		int[] q = new int[n];
		int[] depth = new int[n];
		
		int p = 0;
		for(int i = 0;i < n;i++){
			if(clus[i] == 0){
				int root = i;
				q[p] = root;
				depth[root] = 0;
				par[root] = -1;
				for(int r = p++;r < p;r++){
					int cur = q[r];
					for(int nex : g[cur]){
						if(par[cur] != nex && clus[nex] != 0){
							q[p++] = nex;
							par[nex] = cur;
							depth[nex] = depth[cur] + 1;
						}
					}
				}
			}
		}
		
		return new int[][] {par, q, depth};
	}
	
	static int[][] packU(int n, int[] from, int[] to) {
		int[][] g = new int[n][];
		int[] p = new int[n];
		for(int f : from)
			p[f]++;
		for(int t : to)
			p[t]++;
		for(int i = 0;i < n;i++)
			g[i] = new int[p[i]];
		for(int i = 0;i < from.length;i++){
			g[from[i]][--p[from[i]]] = to[i];
			g[to[i]][--p[to[i]]] = from[i];
		}
		return g;
	}
	
	void run() throws Exception
	{
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception
	{
		new D().run();
	}
	
	public int ni()
	{
		try {
			int num = 0;
			boolean minus = false;
			while((num = is.read()) != -1 && !((num >= '0' && num <= '9') || num == '-'));
			if(num == '-'){
				num = 0;
				minus = true;
			}else{
				num -= '0';
			}
			
			while(true){
				int b = is.read();
				if(b >= '0' && b <= '9'){
					num = num * 10 + (b - '0');
				}else{
					return minus ? -num : num;
				}
			}
		} catch (IOException e) {
		}
		return -1;
	}
	
	public long nl()
	{
		try {
			long num = 0;
			boolean minus = false;
			while((num = is.read()) != -1 && !((num >= '0' && num <= '9') || num == '-'));
			if(num == '-'){
				num = 0;
				minus = true;
			}else{
				num -= '0';
			}
			
			while(true){
				int b = is.read();
				if(b >= '0' && b <= '9'){
					num = num * 10 + (b - '0');
				}else{
					return minus ? -num : num;
				}
			}
		} catch (IOException e) {
		}
		return -1;
	}
	
	public String ns()
	{
		try{
			int b = 0;
			StringBuilder sb = new StringBuilder();
			while((b = is.read()) != -1 && (b == '\r' || b == '\n' || b == ' '));
			if(b == -1)return "";
			sb.append((char)b);
			while(true){
				b = is.read();
				if(b == -1)return sb.toString();
				if(b == '\r' || b == '\n' || b == ' ')return sb.toString();
				sb.append((char)b);
			}
		} catch (IOException e) {
		}
		return "";
	}
	
	public char[] ns(int n)
	{
		char[] buf = new char[n];
		try{
			int b = 0, p = 0;
			while((b = is.read()) != -1 && (b == ' ' || b == '\r' || b == '\n'));
			if(b == -1)return null;
			buf[p++] = (char)b;
			while(p < n){
				b = is.read();
				if(b == -1 || b == ' ' || b == '\r' || b == '\n')break;
				buf[p++] = (char)b;
			}
			return Arrays.copyOf(buf, p);
		} catch (IOException e) {
		}
		return null;
	}
	
	
	double nd() { return Double.parseDouble(ns()); }
	boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	void tr(Object... o) { if(!oj)System.out.println(Arrays.deepToString(o)); }
}

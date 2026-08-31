import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		new Task().solve();
	}
}

@SuppressWarnings("unchecked")
class Task {
	InputReader in = new InputReader(System.in);
	PrintWriter out = new PrintWriter(System.out);

	List<Integer> adj[] ;
	int[] father , dis ; 
	int maxPos , maxDep ;
	
	void dfs(int u , int fa , int dep , int root){
		father[u] = root ; 
		if(maxDep < dep){
			maxDep = dep ;
			maxPos = u ;
		}
		for(int v : adj[u]){
			if(v == fa) continue ;
			dfs(v , u , dep+1 , root) ;
		}
	}
	
	int getFather(int u){
		if(u == father[u]) return u ;
		return father[u] = getFather(father[u]) ;
	}
	
	void solve(){
		int n = in.nextInt() ;
		int m = in.nextInt() ;
		int q = in.nextInt() ;
		adj = new List[n+1] ;
		//Arrays.fill(adj , new ArrayList<Integer>()) ;
		for(int i = 1 ; i <= n ; i++)
			adj[i] = new ArrayList<Integer>() ; 
		father = new int[n+1] ;
		dis = new int[n+1] ;
		for(int i = 1 ; i <= n ; i++) father[i] = i ; 
		while(m -- > 0){
			int u = in.nextInt() ;
			int v = in.nextInt() ;
			adj[u].add(v) ;
			adj[v].add(u) ;
			u = getFather(u) ;
			v = getFather(v) ;
			if(u != v) father[u] = v ;
		}
		for(int i = 1 ; i <= n ; i++){
			if(father[i] == i){
				maxDep = 0 ; 
				maxPos = i ;
				dfs(i , -1 , 0 , i) ;
				maxDep = 0 ;
				dfs(maxPos , -1 , 0 , maxPos) ;
			    dis[getFather(i)] = maxDep ;
			}
		}
		while(q-- > 0){
			if(in.nextInt() == 1){
				out.println(dis[getFather(in.nextInt())])  ;
			}
			else{
				int u = getFather(in.nextInt()) ;
				int v = getFather(in.nextInt()) ;
				if(u != v){
					father[u] = v ;
					dis[v] = Math.max(Math.max(dis[v] , dis[u]) , (dis[u]+1)/2 + (dis[v]+1)/2 + 1) ;
				}
			}
		}
		out.flush() ;  
	}

}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = new StringTokenizer("");
	}

	private void eat(String s) {
		tokenizer = new StringTokenizer(s);
	}

	public String nextLine() {
		try {
			return reader.readLine();
		} catch (Exception e) {
			return null;
		}
	}

	public boolean hasNext() {
		while (!tokenizer.hasMoreTokens()) {
			String s = nextLine();
			if (s == null)
				return false;
			eat(s);
		}
		return true;
	}

	public String next() {
		hasNext();
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}

	public BigInteger nextBigInteger() {
		return new BigInteger(next());
	}

}

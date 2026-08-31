import java.io.*;
import java.util.*;

public class Main {

	public static class FastReader {
		BufferedReader br;
		StringTokenizer root;
		
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (root == null || !root.hasMoreTokens()) {
				try {
					root = new StringTokenizer(br.readLine());
				} catch (Exception addd) {
					addd.printStackTrace();
				}
			}
			return root.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception addd) {
				addd.printStackTrace();
			}
			return str;
		}
	}
	
	public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
	
	public static FastReader sc = new FastReader();
 
	static int mod = (int) (1e9+7),MAX=(int) (3e5);
	static List<Integer>[] edges ;
	public static int[] maxdepth,dp;
	 public static int diameter;
	public static void main(String[] args) {
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    int q = sc.nextInt();
	    edges = new ArrayList[n+1];
	    DSU dsu = new DSU(n+1);
	    maxdepth = new int[n+1];
	    for(int i=0;i<edges.length;++i) edges[i] = new ArrayList<>();
	    for(int i=1;i<=m;++i) {
	    	int u = sc.nextInt();
	    	int v = sc.nextInt();
	    	edges[u].add(v);
	    	edges[v].add(u);
	    	dsu.unite(u, v);
	    }
	    Map<Integer,Integer> map = new HashMap<>();
	    for(int i=1;i<=n;++i) {
	    	int root = dsu.findRoot(i);
	    	if(!map.containsKey(root)) {
	    	   diameter = 0;
	    	   dfs(root,-1);
	    	   map.put(root,diameter);
	       }
	    }
	    while(q-->0) {
	    	int t = sc.nextInt();
	    	if(t == 1) {
	    		int v = sc.nextInt();
	    		out.println(map.get(dsu.findRoot(v)));
	    	}else {
	    		int x = sc.nextInt();
	    		int y = sc.nextInt();
	    		int rootx = dsu.findRoot(x);
	    		int rooty = dsu.findRoot(y);
	    		if(rootx == rooty) continue;
	    		int diax = map.get(rootx);
	    		int diay = map.get(rooty);
	    		int dia = Math.max(diax,diay);
	    		dia = Math.max(dia,(diax+1)/2 + (diay+1)/2 + 1);
	    		dsu.unite(x, y);
	    		map.put(dsu.findRoot(x),dia);
	    	}
	    }
		out.close();
	}

	private static void dfs(int v, int par) {
		int max1 = 0, max2 = 0;
		for(int child : edges[v]) {
			if(child != par) {
				dfs(child,v);
				if(maxdepth[child]+1 >= max1) {
					max2 = max1;
					max1 = maxdepth[child]+1;
				}else if(maxdepth[child]+1 > max2) {
					max2 = maxdepth[child]+1;
				}
			}
		}
		maxdepth[v] = max1;
		diameter = Math.max(diameter, max1+max2);
	}
	
    static class DSU {
        int n;
        int[] parent, size;

        public DSU(int v) {
            n = v;
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findRoot(int curr) {
            if(curr == parent[curr]) return curr;
            return parent[curr] = findRoot(parent[curr]);
        }

        public boolean unite(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if(rootA == rootB) return true;
            if(size[rootA] > size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
            else {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
            return false;
        }  

    }

}

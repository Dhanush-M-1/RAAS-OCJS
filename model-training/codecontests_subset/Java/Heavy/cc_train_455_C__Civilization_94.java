import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution{
	
	static int[] d;
	static ArrayList<Integer>[] g;
	static int fv = -1;
	static int max = -1;
	static boolean query = false;
	
	
    public static void main(String[] args) throws IOException {
    	
		
    	FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
    		
    	int tt = 1;
    	while(tt-->0) {
    		
    		int n = fs.nextInt(), m = fs.nextInt(), q = fs.nextInt();
    		UnionFind dsu = new UnionFind(n);
    		
    		g = new ArrayList[n];
    		for(int i=0;i<n;i++) g[i] = new ArrayList<Integer>();
    		
    		for(int i=0;i<m;i++) {
    			int u = fs.nextInt()-1, v = fs.nextInt()-1;
    			dsu.union(u, v);
    			g[u].add(v);
    			g[v].add(u);
    		}
    		
    		d = new int[n];
    		Arrays.fill(d, -1);
    		
    		for(int i=0;i<n;i++) {
    			if(d[dsu.find(i)]==-1) {
    				fv = -1;
    				max = -1;
    				dfs1(i, -1, 0);
    				d[dsu.find(i)] = dfs2(fv, -1);
    			}
    		}
    		
    		query = true;
    		while(q-->0) {
    			
    			int type = fs.nextInt();
    			if(type==1) {
    				int x = fs.nextInt()-1;
    				out.println(d[dsu.find(x)]);
    			}
    			else {
    				int x = fs.nextInt()-1, y = fs.nextInt()-1;
    				dsu.union(x, y);
    			}
    			
    			
    			
    		}
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	}
    	
    	out.close();
    		
    	
    	
    }
    
    
    static void dfs1(int v,int p, int dist) {
    	if(dist>max) {
    		max = dist;
    		fv = v;
    	}
    	for(int u: g[v]) {
    		if(u==p) continue;
    		dfs1(u, v, dist+1);
    	}
    }
    
    static int dfs2(int v,int p) {
    	int max = 0;
    	for(int u: g[v]) {
    		if(u==p) continue;
    		max = Math.max(max, dfs2(u, v) + 1);
    	}
    	return max;
    }
    
    
    
    static class UnionFind{
    	int[] parent;
    	int[] size;
    	
    	UnionFind(int n){
    		parent = new int[n];
    		for(int i=0;i<n;i++) parent[i] = i;
    		size = new int[n];
    	}
    	
    	int find(int v) {
    		if(parent[v]==v) return v;
    		return parent[v] = find(parent[v]);
    	}
    	
    	void union(int a, int b) {
    		a = find(a);
    		b = find(b);
    		if(a==b) return;
    		if(size[a]>size[b]) {
    			int temp = a; a = b; b = temp;
    		}
    		parent[a] = b;
    		size[b] += size[a];
    		if(query) {
    			int newd = (d[a]+1)/2 + (d[b]+1)/2 + 1;
        		d[b] = Math.max(d[b], d[a]);
        		d[b] = Math.max(d[b], newd);
    		}
    	}
    }
    
    
    
    
    static final Random random=new Random();
    
    static <T> void shuffle(T[] arr) {
    	int n = arr.length;
    	for(int i=0;i<n;i++	) {
    		int k = random.nextInt(n);
    		T temp = arr[k]; arr[k] = arr[i]; arr[i] = temp;
    	}
    }
    
    	
    static void ruffleSort(int[] a) {
    	int n=a.length;//shuffle, then sort 
    	for (int i=0; i<n; i++) {
    		int oi=random.nextInt(n); int temp=a[oi];
    		a[oi]=a[i]; a[i]=temp;
    	}
    	Arrays.sort(a);
    }
    
    static void ruffleSort(long[] a) {
    	int n=a.length;//shuffle, then sort 
    	for (int i=0; i<n; i++) {
    		int oi=random.nextInt(n); long temp=a[oi];
    		a[oi]=a[i]; a[i]=temp;
    	}
    	Arrays.sort(a);
    }
   
  
    
    static void reverse(int[] arr, int l, int r) {
    	for(int i=l;i<l+(r-l)/2;i++){
    		int temp = arr[i]; arr[i] = arr[r-i+l-1]; arr[r-i+l-1] = temp;
    	}
    }
    
    static void reverse(long[] arr, int l, int r) {
    	for(int i=l;i<l+(r-l)/2;i++){
    		long temp = arr[i]; arr[i] = arr[r-i+l-1]; arr[r-i+l-1] = temp;
    	}
    }
    
    
    static <T> void reverse(T[] arr, int l, int r) {
    	for(int i=l;i<l+(r-l)/2;i++) {
    		T temp = arr[i]; arr[i] = arr[r-i+l-1]; arr[r-i+l-1] = temp;
    	}
    }
    	
    	
    static class FastScanner{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer("");
     
    	public String next(){
    		while(!st.hasMoreElements()){
    			try{
    				st = new StringTokenizer(br.readLine());
    			} catch(IOException e){
    				e.printStackTrace();
    			}
    		}
    		return st.nextToken();
    	}
    		
    	public String nextLine() throws IOException {
    		return br.readLine();
    	}
    		
    	public int nextInt(){
    		return Integer.parseInt(next());
    	}
     
    	public int[] readArray(int n){
    		int[] a = new int[n];
    		for(int i=0;i<n;i++)
    			a[i] = nextInt();
    		return a;
    	}
    		
    	public long nextLong() {
    		return Long.parseLong(next());
    	}
    		
    	public char nextChar() {
    		return next().toCharArray()[0];
    	}
    }
   	
}

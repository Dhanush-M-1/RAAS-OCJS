//Author: net12k44
import java.io.*;
import java.util.*;
//public
class Main{//}

static class Node{
	int length, level;
	Node parent;
	ArrayList<Node> adj;
	
	void add(Node i){ adj.add(i); }
	
	//Return best Node in subtree root this
	Node dfs(Node parent, int level, boolean undo){
		Node best = this;
		this.parent = parent; this.level = level;
		for(Node next: adj) if (next.parent==null){
			Node candidate = next.dfs(parent, level+1, undo);
			if (best.level < candidate.level)
				best = candidate;		
		}
		if (undo) this.parent = null;
		return best;
	}
	
	void getMaxLength(){
		Node best = dfs(this, 0, true);
		best = best.dfs(this, 0, false);
		
		this.parent = null;
		length = best.level;
	}
	
	Node(){
		length = level = 0;
		parent = null;	
		adj = new ArrayList<Node>();
	}
	
	Node getRoot(){
		if (parent == null) return this;
		parent = parent.getRoot();
		return parent;	
	}
	
	int getHalfLength(){
		return length/2 + length%2;	
	}
	
	void unite(Node other){
		Node left = this.getRoot();
		Node right = other.getRoot();		
		if (left == right) return;
		
		right.parent = left;
		left.length = Math.max( 
			right.getHalfLength() + left.getHalfLength() + 1,
			Math.max( right.length, left.length )
		);	
		
	}
}

private void solve() {
	int n = in.nextInt(), m = in.nextInt(), q = in.nextInt();
	//ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
	Node[] a = new Node[n+1];	//1-base array
	for(int i = 1; i <= n; ++i) a[i] = new Node();
	while (m-- > 0){
		int i = in.nextInt(), j = in.nextInt();
		a[i].add(a[j]); a[j].add(a[i]);	
	}	
	for(int i = 1; i <= n; ++i) 
		if (a[i].parent == null) a[i].getMaxLength();
	
	while (q-- > 0){
		int type = in.nextInt();
		if (type == 1) {
			int k = in.nextInt();
			out.println( a[k].getRoot().length );
		}
		else {
			int i = in.nextInt(), j = in.nextInt();
			a[i].unite(a[j]);		
		}			
	}
	
}
	
public static void main (String[] args) throws java.lang.Exception {		
	long startTime = System.currentTimeMillis();

	out = new PrintWriter(System.out);
	new Main().solve();	
	//out.println((String.format("%.2f",(double)(System.currentTimeMillis()-startTime)/1000)));
	out.close();
}
static PrintWriter out;
static void println(int[] a){
	for(int i = 0; i < a.length; ++i){
		if (i != 0) out.print(' ');
		out.print(a[i]);
	}
	out.println();
}
static class in {
	static BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) ) ;
	static StringTokenizer tokenizer = new StringTokenizer("");				
	static String next() {		
		while ( !tokenizer.hasMoreTokens() )
			try { tokenizer = new StringTokenizer( reader.readLine() ); }
			catch (IOException e){
				throw new RuntimeException(e);			
			}		
		return tokenizer.nextToken();
	}
	static int nextInt() { return Integer.parseInt( next() ); }			
}
//////////////////////////////////////////////////
}//
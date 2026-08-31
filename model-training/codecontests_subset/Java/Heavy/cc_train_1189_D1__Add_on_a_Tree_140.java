import java.util.*;
public class Graph{
	int V;
	ArrayList<Integer>[] adj;
	
	Graph(int v){
		V=v;
		adj=new ArrayList[V+1];
		for(int i=1;i<V+1;i++) {
			adj[i]=new ArrayList<>();
		}
		
	}
	void addEdge(int a,int b) {
		adj[a].add(b);
		adj[b].add(a);
	}
	void check() {
		int three=0;
		int leaf=0;
		int ans=1;
		for(int i=1;i<adj.length;i++) {
			if(adj[i].size()==2) {
				ans=0;
				break;
			}
			if(adj[i].size()==1) {
				leaf++;
			}
			if(adj[i].size()>=3) {
				three++;
			}
		}
		if(ans==0) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
		
	}
	public static void main(String[] args) {
		Scanner ip=new Scanner(System.in);
		int n=ip.nextInt();
		Graph g=new Graph(n);
		for(int i=1;i<n;i++) {
			int p=ip.nextInt();
			int c=ip.nextInt();
			g.addEdge(p,c);	
		}
		if(n==2) {
			System.out.println("YES");
		}else {
		g.check();
		}
		
		
	}
}
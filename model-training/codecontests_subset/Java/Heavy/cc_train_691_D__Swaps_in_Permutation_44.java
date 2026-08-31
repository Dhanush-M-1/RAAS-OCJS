import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swapsPermut {
	static String [] nn;
	static int [] ns;
	public static void generate(ArrayList<Integer> pos){
		int [] elem=new int[pos.size()];
		for (int i = 0; i < pos.size(); i++) {
		
			elem[i]=Integer.parseInt(nn[pos.get(i)]);
		}
		Arrays.sort(elem);
		int out=0;
//	Collections.sort(pos);
		for (int i = 0; i < elem.length; i++) {
			nn[pos.get(pos.size()-i-1)]=elem[i]+" ";
		}
	}
public static void main(String[] args) throws IOException {
	BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(in.readLine());
	int n=Integer.parseInt(st.nextToken());
	int m=Integer.parseInt(st.nextToken());
	nn=in.readLine().split(" ");
	ArrayList<Integer> [] pairs=new ArrayList[n+1];
	DisjointSets ds=new DisjointSets(n);
	for (int i = 0; i < m; i++) {
		st=new StringTokenizer(in.readLine());
		int p1=Integer.parseInt(st.nextToken());
		int p2=Integer.parseInt(st.nextToken());
        ds.union(p1-1, p2-1);
//		pairs[p1].add(p2);
//	pairs[p2].add(p1);
	}
	ds.updateAll();
	ArrayList<Integer>[] groups=ds.groups;
	for (int i = 0; i < groups.length; i++) {
		generate(groups[i]);
	}
	for (int i = 0; i < nn.length; i++) {
		System.out.print(nn[i]);
	}
}
}

/*
 * Strongly Connected Components (Directed Graphs) - Tarjan's Algorithm (DFS Variant)
 */
 class StronglyConnectedComponents1 {

	static ArrayList<Integer>[] adjList;
	static int V, counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static Stack<Integer> stack;
		
	
	static void tarjanSCC()	 	//O(V + E)
	{
		for(int i = 0; i < V; ++i)
			if(dfs_num[i] == 0)
				tarjanSCC(i);
	}
	
	static void tarjanSCC(int u)
	{
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);
		
		for(int v: adjList[u])
		{
			if(dfs_num[v] == 0)
				tarjanSCC(v);
			if(!inSCC[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);	
		}
		if(dfs_num[u] == dfs_low[u])
		{
			//SCC found
			SCC++;
			while(true)
			{
				int v = stack.pop();
				inSCC[v] = true;
				if(v == u)
					break;
			}
		}	
	}	
}
 class DisjointSets {
		int representative[];
		int rank[];
		static int biggest=0;
         ArrayList<Integer> groups[];
		public DisjointSets(int n) {
//			System.out.println(n);
			//n++;
			representative = new int[n];
			rank = new int[n];
			groups=new ArrayList[n];
			
			for (int i = 0; i < representative.length; i++){
				groups[i]=new ArrayList<Integer>();
				representative[i] = i;}
			Arrays.fill(rank, 1);
		}

		int findSet(int x) {
			if (x == representative[x])
				return x;
			return representative[x] = findSet(representative[x]);
		}
		void update(){

		int counter=0;
			for(int j=0;j<representative.length;j++){

			for(int i=0;i<representative.length;i++){
				if(representative[j]==representative[i])
					counter++;
				}
					if(biggest<counter){
						biggest=counter;
					}
					counter=0;
			}
		}
		int different(){
			HashSet<Integer> hs=new HashSet<Integer>();
			for (int i = 1; i < representative.length; i++) {
			if(representative[representative[i]]!=representative[i])
				continue;
				hs.add(representative[i]);
			}
			return hs.size();
		}
		void updateAll(){
			for (int i = 0; i < representative.length; i++) {
				representative[i]=findSet(i);
			    groups[representative[i]].add(i);
			}
			
		}
		void union(int x, int y) {

			int x1 = findSet(x);
			int y1 = findSet(y);
			if (x1 != y1)
				if (rank[x1] > rank[y1]) {
					representative[y1] = x1;
				} else if (rank[x1] < rank[y1]) {
					representative[x1] = y1;
				} else {
					representative[x1] = y1;
					
					rank[y1]++;
					}
					
		}

	}

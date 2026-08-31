import java.util.*;
import java.io.*;
public class Solution1{

	static class Road{
		int u,v;
		Road(int u,int v){
			this.u=u;
			this.v=v;
		}
		public String toString(){
			return u+" "+v;
		}
	}

	public static void dfs(int root, int parent, LinkedList<Integer> adj[], boolean visited[], HashSet<String> extra){

		visited[root]=true;
		for(int item:adj[root])
			if(item!=parent){
				if(visited[item]){
					if(!extra.contains(root+" "+item) && !extra.contains(item+" "+root))
						extra.add(root+" "+item);
				}
				else
					dfs(item, root, adj, visited, extra);
			}
	}

	public static void main(String args[])throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());

		LinkedList<Integer> adj[]=new LinkedList[n+1];

		for(int i=0;i<=n;i++)
			adj[i]=new LinkedList<>();

		for(int i=0;i<n-1;i++){
			String input[]=br.readLine().split("\\s");
			int u=Integer.parseInt(input[0]),
				v=Integer.parseInt(input[1]);

			adj[u].add(v);
			adj[v].add(u);
		}

		
		boolean visited[]=new boolean[n+1];
		HashSet<String> extra=new HashSet<>();
		ArrayList<Integer> forest=new ArrayList<>();

		for(int i=1;i<=n;i++)
			if(!visited[i]){
				dfs(i, 0, adj, visited, extra);
				forest.add(i);
			}

		System.out.println(extra.size());
		//System.out.println(extra);
		int i=1;
		for(String item:extra){
			System.out.println(item+" "+forest.get(i-1)+" "+forest.get(i));
			i+=1;
		}
		
	}
}
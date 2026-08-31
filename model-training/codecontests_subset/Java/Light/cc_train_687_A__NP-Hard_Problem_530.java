
import java.util.*;

public class A687 {
	static List<Integer>[] graph, res;
	static int[] color;
	static int n, m;
	public static void main(String [] args) {
		
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		
		color = new int[n+1];
		graph = new List[n+1];
		res = new List[2];
		
		for(int i = 1 ; i <= n ; i++) 
			graph[i] = new ArrayList<>();
		for(int i = 0 ; i < 2 ; i++)
			res[i] = new ArrayList<>();
		for(int i = 0 ; i < m ; i++) {
			int u = in.nextInt();
			int v = in.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i = 1 ; i <= n ; i++) {
			if(color[i] == 0) {
				if(graph[i].isEmpty())
					continue;
				if(dfs(i, 2)) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		for(int i = 0 ; i < 2 ; i++) {
			System.out.println(res[i].size());
			for(int x : res[i]) 
				System.out.print(x + " ");
				System.out.println();
		}
		
		
	}
	private static boolean dfs(int root, int paint) {
		// TODO Auto-generated method stub
		color[root] = paint;
		res[paint - 1].add(root);
		for(int child : graph[root]) {
			if(color[child] == 0 && dfs(child, 3 - paint)) 
				return true;
			if(color[child] != 3 - paint) 
				return true;
		}
		return false;
	}
}

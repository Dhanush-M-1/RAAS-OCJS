import java.io.*;
import java.util.*;

public class DestructionOfTree {
	
	static ArrayList<Integer>[] e;
	static boolean[] relaxed, vis;
	static PrintWriter pw;
	public static void main(String[] args) throws Exception{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int n = Integer.parseInt(f.readLine());
		
		if(n % 2 == 0) {
			pw.println("NO");
			pw.close();
			System.exit(0);
		}
		
		pw.println("YES");
		e = new ArrayList[n];
		relaxed = new boolean[n];
		vis = new boolean[n];
		for(int i = 0;i<n;i++) {
			e[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		for(int i = 1;i<=n;i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(x != 0) {
				e[i - 1].add(x-1);
				e[x - 1].add(i-1);
			}
		}
		
		dfs(0, -1);
		
		print(0);
		
		pw.close();
	}
	
	static boolean dfs(int x, int p) {
		
		if(e[x].size() == 1 && e[x].get(0) == p) {
			return false;
		}
		
		int counter = 0;
		for(int n: e[x]) {
			if(n != p) {
				if(!dfs(n,x)) {
					counter ++;
				}
			}
		}
		if((x == 0 && counter % 2 == 0) || (x != 0 && counter % 2 == 1)) {
			pw.println(x+1);
			relaxed[x] = true;
			return true;
		}
		else {
			return false;
		}
	}
	
	static void print(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		if(!relaxed[x]) pw.println(x+1);
		vis[x] = true;
		
		while(!q.isEmpty()) {
			int y = q.poll();
			
			for(int n: e[y]) {
				if(!vis[n]) {
					if(!relaxed[n]) pw.println(n+1);
					q.add(n);
					vis[n] = true;
				}
			}
		}
	}
	

}

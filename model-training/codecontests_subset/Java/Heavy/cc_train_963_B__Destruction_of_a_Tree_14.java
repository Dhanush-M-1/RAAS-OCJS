

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class P963B {

static Scanner in = new Scanner(System.in);
	
	static HashMap<Integer, ArrayList<Integer>> g;
	
	static int n;
	
	static boolean ans=true;
	
	static Stack<Integer> st = new Stack<>();
	
	static StringBuilder sb = new StringBuilder();
	
	static int[] size;
	
	public static void main(String[] args) {
		n = in.nextInt();
		g = new HashMap<>();
		
		size = new int[n];
		
		for(int i=0; i<n; i++) g.put(i, new ArrayList<>());
		
		int root=0;
		
		for(int i=0; i<n; i++) {
			int u = i;
			int v = in.nextInt()-1;
			if (v==-1) {
				root=i;
				continue;
			}
			g.get(u).add(v);
			g.get(v).add(u);
			
		}

		dfs(root, -1, 0);
		
		System.out.println(st.isEmpty()?"YES":"NO");
		
		if (st.isEmpty())
			System.out.println(sb);
		
		
	}
	
	public static boolean dfs(int v, int pv, int d) {
		
		long degree=pv==-1?0:1;
		
		size[v]=1;
		
		for(int u: g.get(v)) {
			if (u==pv) continue;
			
			boolean del=dfs(u, v, d+1);
			
			if (!del) size[v]+=size[u];
			
			if (!del) degree++;
			
		}
		
		if (degree%2!=0) {
			st.push(v);
		} else {
			//deleted then delete all its children
			sb.append((v+1)+"\n");
			int count=0;
			while(!st.isEmpty()) {
				sb.append((st.pop()+1)+"\n");
				count++;
				if (count==size[v]-1) break;
			}
		}
		
		return degree%2==0;
	}

}
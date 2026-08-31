import java.util.*;
import java.io.*;


public class Main {

	static ArrayList<ArrayList<Integer>> g=new ArrayList<ArrayList<Integer>>();
	static boolean ans=true;
	static int[] set;

	public static void dfs(int cur, boolean[] vis) {
		if (!ans) {
			return;
		}
		vis[cur]=true;
		for (int i=0;i<g.get(cur).size();i++) {
			int neighbor=g.get(cur).get(i);
			if (vis[neighbor]) {
				if (set[cur]==set[neighbor]) {
					ans=false;
					return;
				}
			}
			else {
				set[neighbor]=(set[cur]==1)?2:1;
				dfs(neighbor, vis);
			}
		}
	}

	public static void main(String []args){
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		for (int i=0;i<N;i++) {
			g.add(new ArrayList<>());
		}
		int M=scan.nextInt();
		for (int i=0;i<M;i++) {
			int u=scan.nextInt()-1;
			int v=scan.nextInt()-1;
			g.get(u).add(v);
			g.get(v).add(u);
			
		}
		boolean[] vis=new boolean[N];
		set=new int[N];
		for (int i=0;i<N;i++) {
			if (!vis[i]) {
				set[i]=1;
				dfs(i, vis);
			}
		}
		int cnt1=0;
		int cnt2=0;
		for (int i: set) {
			if (i==1) cnt1+=1;
			else if(i==2) cnt2+=1;
		}
		if (ans) {
			System.out.println(cnt1);
			for (int i=0;i<N;i++) {
				if (set[i]==1) System.out.print((i+1)+" ");
			}
			System.out.println();
			System.out.println(cnt2);
			for (int i=0;i<N;i++) {
				if (set[i]==2) System.out.println((i+1)+" ");
			}
		}
		else {
			System.out.println(-1);
		}


	}
}
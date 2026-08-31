
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class dahell {

	static int[]v;
	static int[]in;
	static LinkedList<Integer>[]adj;
	static TreeSet<Integer>[]reach;
	public static void dfs(int x,int set) {
		v[x]=set;
		reach[set].add(x);
		for(int i:adj[x]) {
			if(v[i]==-1) {
				dfs(i,set);
			}
		}
	}
	public static void bfs(Queue<Integer> q,int set) {
		while(!q.isEmpty()) {
			int x=q.poll();
			v[x]=set;
			reach[set].add(x);
			for(int i:adj[x]) {
				if(v[i]==-1) {
					q.add(i);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		in=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			in[i]=Integer.parseInt(st.nextToken())-1;
		}
		adj=new LinkedList[n];
		for(int i=0;i<n;i++) {
			adj[i]=new LinkedList<Integer>();
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			adj[in[x]].add(in[y]);
			adj[in[y]].add(in[x]);
		}
		v=new int[n];reach=new TreeSet[n];
		int set=0;
		for(int i=0;i<n;i++) {
			v[i]=-1;
		}
		for(int i=0;i<n;i++) {
			if(v[in[i]]==-1) {
				Queue<Integer>q=new LinkedList<Integer>();
				reach[set]=new TreeSet<Integer>();
				q.add(in[i]);
				bfs(q,set);
				set++;
			}
		}

		for(int i=0;i<n;i++) {
				pw.print((reach[v[in[i]]].pollLast()+1)+" ");

		}
		pw.close();
		pw.flush();

	}


}

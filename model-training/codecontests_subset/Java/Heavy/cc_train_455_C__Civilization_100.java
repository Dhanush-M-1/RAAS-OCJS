import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class C {
	public static int Fu[];
	public static int dist[];
	public static int n;
	public static boolean vis[];
	public static boolean dvis[];
	public static int FuFind(int v){
		if(Fu[v] < 0){
			return v;
		}
		else{
			return (Fu[v] = FuFind(Fu[v]));
		}
	}
	public static void FuJoin(int v, int w){
		v = FuFind(v);
		w = FuFind(w);
		if(v==w){
			return;
		}
		if(Fu[v] > Fu[w]){
			int temp = v;
			v = w;
			w = temp;
		}
		Fu[v] += Fu[w];
		dist[v] = Math.max((dist[v]+1)/2 + (dist[w]+1)/2 + 1, Math.max(dist[v], dist[w]));
		Fu[w] = v;
	}
	public static void FuInit(){
		for(int i = 1; i <= n; i++){
			Fu[i] = -1;
		}
	}
	public static void main(String[] args) throws Exception{
		n = readInt();
		Fu = new int[n+1];
		FuInit();
		dist = new int[n+1];
		vis = new boolean[n+1];
		dvis = new boolean[n+1];
		int m = readInt();
		int q = readInt();
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= n; i++){
			g.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < m; i++){
			int a = readInt();
			int b = readInt();
			g.get(a).add(b);
			g.get(b).add(a);
			FuJoin(a,b);
		}
		for(int i = 1; i< n+1; i++){
			if(!vis[i]){
				ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
				int cur = i;
				ad.add(cur);
				vis[i] = true;
				while(!ad.isEmpty()){
					cur = ad.poll();
					for(int j = 0; j <g.get(cur).size(); j++){
						if(!vis[g.get(cur).get(j)]){
							vis[g.get(cur).get(j)] = true;
							ad.add(g.get(cur).get(j));
						}
					}
				}
				dist[FuFind(i)] =bfs(cur, g);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++){
			int a = readInt();
			if(a == 1){
				sb.append(dist[FuFind(readInt())] + "\n");
			}
			else{
				int b = readInt();
				int c = readInt();
				FuJoin(b, c);
			}
		}
		System.out.print(sb);
	}
	private static int bfs(int s, ArrayList<ArrayList<Integer>> g) {
		ArrayDeque<Pair> ad = new ArrayDeque<Pair>();
		ad.add(new Pair(s, 0));
		Pair cur = new Pair(s, 0); 
		dvis[s] = true;
		while(!ad.isEmpty()){
			cur = ad.poll();
			for(int j = 0; j <g.get(cur.ind).size(); j++){
				if(!dvis[g.get(cur.ind).get(j)]){
					dvis[g.get(cur.ind).get(j)] = true;
					ad.add(new Pair(g.get(cur.ind).get(j), cur.depth+1));
				}
			}
		}
		return cur.depth;
	}
	
	static class Pair{
		int ind = 0;
		int depth = 0;
		Pair(int a, int b){
			ind = a;
			depth = b;
		}
	}
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer(" ");
	static String readString() throws Exception{
		while(!st.hasMoreTokens()){
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}
	static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
	static long readLong() throws Exception {
		return Long.parseLong(readString());
	}
}

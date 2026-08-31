import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

	static class Scanner{
		BufferedReader br=null;
		StringTokenizer tk=null;
		public Scanner(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		public String next() throws IOException{
			while(tk==null || !tk.hasMoreTokens()) {
				String cad = br.readLine();
				if (cad == null)
					return null;
				tk=new StringTokenizer(cad);
			}
			return tk.nextToken();
		}
		public int nextInt() throws NumberFormatException, IOException{
			return Integer.valueOf(next());
		}
		public long nextLong() throws NumberFormatException, IOException{
			return Long.valueOf(next());
		}
		public double nextDouble() throws NumberFormatException, IOException{
			return Double.valueOf(next());
		}
	}
	
	static class Node {
		int id;
		int color;
		int dist;
		int incoming;
		ArrayList<Integer> e;
		ArrayList<Integer> w;
		public Node(int id) {
			this.id = id;
			color = -1;
			e = new ArrayList<Integer>();
			w = new ArrayList<Integer>();
			dist = -1;
			incoming = 0;
		}
	}
	
	static boolean dfs(int id, int dist) {
		if (a[id].color == 0)
			return false;
		if (a[id].color == 1)
			return dist == a[id].dist;
		a[id].color = 0;
		a[id].dist = dist;
		for(int i = 0; i < a[id].e.size(); i++) {
			int next = a[id].e.get(i);
			int w = a[id].w.get(i);
			if (!dfs(next, dist + w))
				return false;
		}
		a[id].color = 1;
		return true;
	}
	
	static int N, M;
	static Node[] a;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		Scanner sc = new Scanner();
		N = sc.nextInt();
		M = sc.nextInt();
		a = new Node[N];
		for(int i = 0; i < N; i++)
			a[i] = new Node(i);
		for(int i = 0; i < M; i++) {
			int L = sc.nextInt() - 1;
			int R = sc.nextInt() - 1;
			int D = sc.nextInt();
			a[L].e.add(R);
			a[L].w.add(D);
			a[R].incoming++;
		}
		for(int i = 0; i < N; i++) {
			if (a[i].incoming == 0 && !dfs(i, 0)) {
				System.out.println("No");
				return;
			}
		}
		for(int i = 0; i < N; i++) {
			if (a[i].color == -1) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}
}

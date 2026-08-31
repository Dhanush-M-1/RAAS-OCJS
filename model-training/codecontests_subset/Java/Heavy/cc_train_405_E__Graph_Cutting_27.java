import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;
import static java.util.Arrays.fill;
import static java.lang.Math.*;


public class Main {

	public static void main(String[] args) {
		if((new File("input.txt")).exists())
			try {
				System.setIn(new FileInputStream("input.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		new Thread(null, new Runnable() {
			@Override
			public void run() {
				try {
					new Main().run();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "th1", 1 << 24).start();
	}
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
	void run() throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		in.close();
		out.close();
	}

	MultiList g, tree;

	int time = 1;
	int used[];
	int tick = 1;
	int tin[];
	
	
	void solve() throws IOException{
		int n = nextInt();
		int m = nextInt();
		
		used = new int[n];
		tin = new int[n];

		g = new MultiList(n, 2 * m);
		tree = new MultiList(n, m + 1);
		
		for(int i = 0; i < m; i++){
			int v = nextInt() - 1;
			int nv = nextInt() - 1;
			g.add(v, nv);
			g.add(nv, v);
		}
		
		if(buildTree(0, -1) != 1){
			out.println("No solution");
		} else {
			for(int v = 0; v < n; v++){
				for(int j = tree.head[v]; j != 0; j = tree.next[j]){
					int nv1 = tree.vert[j] + 1;
					j = tree.next[j];
					int nv2 = tree.vert[j] + 1;
					out.println(nv1 + " " + (v + 1) + " " + nv2);
				}
			}
		}
		
		
		
	}
 
	int buildTree(int v, int pv){
		used[v] = tick; 
		tin[v] = time++;
		int cnt = 0;
		for(int j = g.head[v]; j != 0; j = g.next[j]){
			int nv = g.vert[j];
			if(pv == nv) continue;
			if(used[nv] == tick && tin[v] > tin[nv]){
				cnt++;
				tree.add(v, nv);
			}
			if(used[nv] != tick && buildTree(nv, v) == 1){
				cnt++;
				tree.add(v, nv);
			}
		}
		if((cnt & 1) == 1){
			tree.add(v, pv);
		}
		return (cnt & 1) ^ 1;
	}
	
	
	
	
	
	class MultiList{
		int[] head, vert, next;
		int cnt;
		public MultiList(int h, int s){
			s++;
			head = new int[h];
			vert = new int[s];
			next = new int[s];
			cnt = 1;
		}
		void add(int h, int v){
			vert[cnt] = v;
			next[cnt] = head[h];
			head[h] = cnt++;
		}
	}
	
	
	public String nextToken() throws IOException{
		while(!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	public int nextInt() throws IOException{
		return Integer.parseInt(nextToken());
	}
	public long nextLong() throws IOException{
		return Long.parseLong(nextToken());
	}
	public double nextDouble() throws IOException{
		return Double.parseDouble(nextToken());
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class C {
	
	static class Scanner{
		BufferedReader br=null;
		StringTokenizer tk=null;
		public Scanner(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		public String next() throws IOException{
			while(tk==null || !tk.hasMoreTokens())
				tk=new StringTokenizer(br.readLine());
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
	
	static class Pair implements Comparable<Pair>{
		int id;
		int key;
		public Pair(int i, int k){
			id = i;
			key = k;
		}
		@Override
		public int compareTo(Pair o) {
			return this.key - o.key;
		}
	}
	
	static int N, M;
	static int[] W;
	static int[] B;
	static int global;
	
	static int contains(ArrayList<Pair> a, int id){
		for(int i = 0; i < a.size(); i++)
			if (a.get(i).id == id)
				return i;
		return -1;
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		Scanner sc = new Scanner();
		N = sc.nextInt();
		M = sc.nextInt();
		W = new int[N];
		for(int i = 0; i < N; i++)
			W[i] = sc.nextInt();
		B = new int[M];
		for(int i = 0; i < M; i++)
			B[i] = sc.nextInt() - 1;
		ArrayList<Pair> a = new ArrayList<Pair>();
		int lifted = 0;
		global = 0;
		for(int i = 0; i < M; i++){
			int cur = B[i];
			int idx = contains(a, cur);
			if (idx >= 0){
				for(int j = idx + 1; j < a.size(); j++)
					lifted += W[a.get(j).id];
				a.get(idx).key = global;
				global++;
				Collections.sort(a);
			}
			else{
				for(int j = 0; j < a.size(); j++)
					lifted += W[a.get(j).id];
				a.add(new Pair(cur, global));
				global++;
				Collections.sort(a);
			}
		}
		System.out.println(lifted);
	}

}

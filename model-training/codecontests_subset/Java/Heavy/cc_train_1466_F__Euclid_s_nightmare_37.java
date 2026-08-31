import java.io.*;
import java.util.*;

public class Main{
	static final long MOD = (long) (1e9 + 7);

	public static void main(String[] args){
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int m = in.nextInt();
		int n = in.nextInt();
		long[] p = new long[(int) 1e6];
		int S = 0;
		Arrays.fill(p, -1);
		p[0] = 1;
		for(int i = 1; i < 1e6; i++){
			p[i] = (p[i - 1] << 1) % MOD;
		}
		DisjointSet ds = new DisjointSet(n + 1);
		List<Integer> sets = new ArrayList<>();
		for(int i = 0; i < m; i++){
			int k = in.nextInt();
			int a = in.nextInt() - 1;
			int b = (k == 1) ? n : in.nextInt() - 1;
			if(ds.find(a) != ds.find(b)){
				ds.merge(a, b);
				sets.add(i + 1);
				S++;
			}
		}
		long T = 1;
		for(int i = 0; i < n + 1; i++){
			int setSize = ds.size(i);
			if(setSize == 1) continue;
			if(ds.find(i) != i) continue;
			T = (T * (long) p[setSize - 1]) % MOD;
		}
		out.println(T + " " + S);
		OutHelper.println(out, sets);
		out.close();
	}


	static private class DisjointSet{
		private int[] p;
		private int[] rank;
		private int[] size;

		DisjointSet(int n){
			p = new int[n];
			rank = new int[n];
			size = new int[n];
			for(int i = 0; i < n; i++){
				p[i] = i;
				rank[i] = 1;
				size[i] = 1;
			}
		}

		int find(int i){
			if(p[i] == i) return i;
			return p[i] = find(p[i]);
		}

		void merge(int i, int j){
			i = find(i);
			j = find(j);
			if (i == j) return;
			if(rank[i] > rank[j]){
				int tmp = i;
				i = j;
				j = tmp;
			}
			p[j] = i;
			if(rank[i] == rank[j]) rank[i]++;
			size[i] += size[j];
		}

		int size(int i){
			return size[find(i)];
		}
	}


	private static class FastScanner{
		private BufferedReader reader;

		private StringTokenizer tokenizer;

		public FastScanner(InputStream stream){
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public FastScanner(InputStreamReader stream){
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine(){
			try{
				return reader.readLine();
			} catch(IOException e){
				e.printStackTrace();
				return null;
			}
		}

		public String next(){
			while(tokenizer == null || !tokenizer.hasMoreTokens()){
				try{
					tokenizer = new StringTokenizer(reader.readLine());
				} catch(IOException e){
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt(){
			return Integer.parseInt(next());
		}

		public long nextLong(){
			return Long.parseLong(next());
		}

		public double nextDouble(){
			return Double.parseDouble(next());
		}
	}

	static class OutHelper{

		static <T> void println(PrintWriter out, List<T> t){
			out.print(t.get(0));
			for(int i = 1; i < t.size(); i++){
				out.print(" " + t.get(i));
			}
			out.println();
		}
	}
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SwapsPerm {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i=0; i<n; i++)
		{
			a[i] = sc.nextInt();
		}
		
		UnionFind uf = new UnionFind(n);
		
		for(int i=0; i<m; i++)
		{
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			
			uf.unionSet(x, y);
		}
		
		
		ArrayList<Integer> sets[] = new ArrayList[n];
		
		for(int i=0; i<n; i++)
			sets[i] = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++)
			sets[uf.findSet(i)].add(a[i]);
		
		for(int i=0; i<sets.length; i++){
			Collections.sort(sets[i]);
			Collections.reverse(sets[i]);
		}
		
		int idx[] = new int[n];
		int res[] = new int[n];
		
		for(int i=0; i<n; i++)
		{
			int curSet = uf.findSet(i);
			res[i] = sets[curSet].get(idx[curSet]++);
		}
		
		PrintWriter out = new PrintWriter(System.out);
		
		for(int x : res)
			out.print(x + " ");
		out.println();
		
		out.flush();
	}
	
	static class UnionFind {
		
		int[] p,rank,setSize;
		int numSets;
		
		public UnionFind(int N)
		{
			p = new int[N];
			rank = new int[N];
			setSize = new int[N];
			
			for(int i=0; i<N; i++)
				p[i] = i;
			
			numSets = N;
			Arrays.fill(setSize, 1);
		}
		
		public int findSet(int i)
		{
			if(p[i] == i)
				return i;
			
			int root = findSet(p[i]);
			p[i] = root; // Path compression
			return root;
		}
		
		public boolean isSameSet(int i, int j)
		{
			return findSet(i) == findSet(j);
		}
		
		public void unionSet(int i, int j)
		{
			int x = findSet(i);
			int y = findSet(j);
			if(x == y)
				return;
			
			if(rank[x] > rank[y]){
				p[y] = x;
				setSize[x] += setSize[y];
			}
			else{
				p[x] = y;
				setSize[y] += setSize[x];
			}
			
			if(rank[x] == rank[y])
				rank[y]++;
			
			numSets--;
		}
		
		public int numSets()
		{
			return numSets;
		}
		
		public int setSize(int i)
		{
			return setSize[findSet(i)];
		}
		
	}
	
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}

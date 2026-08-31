
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SwapsInPermutation_691D {
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		UnionFind uf = new UnionFind(n);
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		for(int i=0;i<m;i++)
		{
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			uf.unionSet(a, b);
		}
		
		ArrayList<Integer> sets[] = new ArrayList[n];
		
		for(int i=0;i<n;i++)
			sets[i] = new ArrayList<>();
		
		for(int i=0;i<n;i++)
			sets[uf.findSet(i)].add(arr[i]);
		
		for(int i=0;i<n;i++)
			Collections.sort(sets[i]);
		
		int[] pointers = new int[n];
		for(int i=0;i<n;i++)
			pointers[i] = sets[i].size()-1;
		int[] ans = new int[n];
		for(int i=0;i<n;i++)
			ans[i] = sets[uf.findSet(i)].get(pointers[uf.findSet(i)]--);
		PrintWriter pw = new PrintWriter(System.out);
		for(int x : ans)
			pw.print(x+" ");
		pw.flush();
	}
	static class UnionFind {                                              
		int[] p, rank, setSize;
		int numSets;
		public UnionFind(int N) 
		{
			p = new int[N];
			rank = new int[N];
			setSize = new int[N];
			numSets = N;
			for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
		}
		public int findSet(int i) 
		{ 
			if (p[i] == i) return i;
			else return p[i] = findSet(p[i]);
		}
		public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
		public void unionSet(int i, int j) 
		{ 
			if (isSameSet(i, j)) 
				return;
			numSets--; 
			int x = findSet(i), y = findSet(j);
			if (rank[x] > rank[y]) 
			{ 
				p[y] = x;
				setSize[x] += setSize[y]; 
			}
			else
			{	
				p[x] = y;
				setSize[y] += setSize[x];
				if(rank[x] == rank[y])
					rank[y]++; 
			} 
		}
		public int numDisjointSets() { return numSets; }
		public int sizeOfSet(int i) { return setSize[findSet(i)]; }
	}
	static class Scanner{
		StringTokenizer st;BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public String next() throws IOException 
		{while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());return st.nextToken();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public long nextLong() throws IOException {return Long.parseLong(next());}
		public String nextLine() throws IOException {return br.readLine();}
		public double nextDouble() throws IOException {return Double.parseDouble(next());}
		public boolean ready() throws IOException {return br.ready();}
	}
}

import java.io.*;
import java.util.*;

public class T {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] p = new int [n];
		
		for(int i = 0 ; i < n ; i++)
			p[i] = sc.nextInt();
		
		DSU uf = new DSU(n);
		
		while(m-->0)
		{
			
			int u = sc.nextInt()  - 1;
			int v = sc.nextInt()  - 1 ;
			
			
			uf.union(u, v);
		}
		
		ArrayList<Integer>[] sets = new ArrayList[uf.sets];
		
		for(int i = 0 ; i < uf.sets ; i++)
			sets[i] = new ArrayList<>();
		
		
		for(int i = 0 ; i < n ; i++)
			sets[uf.findSets(i)].add(i);
			
		
		for(int i = 0 ; i < uf.sets ; i++)
		{
			ArrayList<Integer> set = sets[i];
			
			Collections.shuffle(set);
			Collections.sort(set);
			
			
			int [] values = new int [set.size()];
			
			for(int j = 0 ; j < set.size() ; j++)
				values[j] = -p[set.get(j)];
			
			Arrays.sort(values);
			
			for(int j = 0 ; j < set.size() ; j++)
				p[set.get(j)] = -values[j];
			
		}
		
		StringBuilder st = new StringBuilder();
		
		for(int x : p)
			st.append(x).append(" ");
		
		System.out.println(st);

	}

	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
	
	static class DSU {
		
		int [] rank , p ;
		int sets ;
		public DSU(int n)
		{
			rank = new int [n];
			p = new int [n];
			for(int i = 0 ;i<n;i++)
				p[i] = i;
			
			sets = n ;
		}
		
		int findSets (int x) {
			return (p[x] == x) ? x :( p[x] = findSets( p[x])) ; 
		}
		
		boolean isSameSets(int x , int y )
		{
			return findSets(x) == findSets(y);
		}
		
		
		void union(int x , int y)
		{
			if(!isSameSets(x, y))
			{
				int i = findSets(x);
				int j = findSets(y);
				if(rank[i] >rank[j])
					p[j] = i ;
				else {
					p[i] = j;
					
					if(rank[i] == rank[j])
						rank[j]++;
					
				}
				
				
				
			}
			
		}



	}

}

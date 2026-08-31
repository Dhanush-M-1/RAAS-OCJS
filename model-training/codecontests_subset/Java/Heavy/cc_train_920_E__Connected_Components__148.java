import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class A {

	static HashSet<Integer>[]notAdj;
	static TreeSet<Integer> unvisited;
	
	static int dfs(int u) {
		unvisited.remove(u);
		int ans=1;
		if(unvisited.isEmpty())
			return 1;
		Integer v=unvisited.first();
		while(v!=null) {
			
			
			if(!notAdj[u].contains(v))
				ans+=dfs(v);
			v=unvisited.higher(v);
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n=sc.nextInt(),m=sc.nextInt();
		notAdj=new HashSet[n];
		ArrayList<Integer>sizes=new ArrayList();
		unvisited=new TreeSet();
		for(int i=0;i<n;i++)
		{
			unvisited.add(i);
			notAdj[i]=new HashSet();
		}
		while(m-->0)
		{
			int u=sc.nextInt()-1,v=sc.nextInt()-1;
			notAdj[u].add(v);
			notAdj[v].add(u);
		}
		for(int i=0;i<n;i++)
			if(unvisited.contains(i))
				sizes.add(dfs(i));
		out.println(sizes.size());
		Collections.sort(sizes);
		for(int x:sizes)
			out.print(x+" ");
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File((s))));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}
}
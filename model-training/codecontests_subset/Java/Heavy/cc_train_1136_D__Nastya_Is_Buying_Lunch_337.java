import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int n=sc.nextInt(),m=sc.nextInt();
		int []p=new int [n];
		ArrayList<Integer>[]adj=new ArrayList[n];
		for(int i=0;i<n;i++) {
			p[i]=sc.nextInt()-1;
			adj[i]=new ArrayList();
		}
		int []a=new int [m],b=new int [m];
		boolean []special=new boolean[n];
		for(int i=0;i<m;i++) {
			a[i]=sc.nextInt()-1;
			b[i]=sc.nextInt()-1;
			adj[a[i]].add(b[i]);
			if(b[i]==p[n-1])
				special[a[i]]=true;
		}
		int ans=0;
		HashSet<Integer> seen=new HashSet();
		for(int i=n-2;i>=0;i--) {
			int x=p[i];
			boolean add=true;
			if(special[x]) {
				int cnt=0;
				for(int v:adj[x])
					if(seen.contains(v))
						cnt++;
				if(cnt==seen.size()) {
					ans++;
					add=false;
				}
			}
			if(add)
				seen.add(x);
		}
		out.println(ans);
		out.close();

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

	}
}
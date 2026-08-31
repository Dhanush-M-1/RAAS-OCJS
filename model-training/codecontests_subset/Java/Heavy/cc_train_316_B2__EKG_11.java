import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Classy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int offset = 0;
		int[] array = new int[N];
		DisjointSet DJ = new DisjointSet(N);
		for(int a=0;a<N;a++){
			int thing = sc.nextInt()-1;
			array[a]=thing;
			if(thing==-1)continue;
			DJ.union(a, thing);
		}
		int SK = K;
		K--;
		while(true){
			if(array[K]==-1)break;
			else K = array[K];
			offset++;
		}
		HashSet<Integer> HS = new HashSet<Integer>();
		HS.add(DJ.find(SK-1));
		LinkedList<Integer> LL = new LinkedList<Integer>();
		for(int a=0;a<N;a++){
			int p = DJ.find(a);
			if(HS.contains(p))continue;
			LL.add(DJ.size(p));
			HS.add(p);
		}
		boolean[] here = new boolean[10001];
		here[0]=true;
		for(Integer x : LL){
			for(int y = here.length-x;y>=0;y--){
				if(here[y])
					here[y+x]=true;
			}
		}
		for(int a=0;a<here.length;a++){
			if(here[a])out.println(a+1+offset);
		}
		
		out.close();
	}
	static class DisjointSet {
		int[] p, r, z;
		boolean sized;
		DisjointSet(int s) {
			sized = false;
			p = new int[s];
			r = new int[s];
			z = new int[s];
			for (int i = 0; i < s; i++)
				p[i] = i;

		}
		
		void union(int x, int y) {
			int a = find(x);
			int b = find(y);
			if (a == b)
				return;
			if (r[a] == r[b])
				r[p[b] = a]++;
			else
				p[a] = p[b] = r[a] < r[b] ? b : a;
		}

		int find(int x) {
			return p[x] = p[x] == x ? x : find(p[x]);
		}
		
		int size(int x) {
			if(sized)return z[find(x)];
			sized = true;
			for(int a=0;a<p.length;a++){
				z[find(a)]++;
			}
			return z[find(x)];
		}

	}



	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		
		public FastScanner(InputStream in) throws Exception{
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer(br.readLine().trim());
		}
		public int numTokens() throws Exception {
			if(!st.hasMoreTokens()){
				st = new StringTokenizer(br.readLine().trim());
				return numTokens();
			}
			return st.countTokens();
		}
		public boolean hasNext() throws Exception{
			if(!st.hasMoreTokens()){
				st = new StringTokenizer(br.readLine().trim());
				return hasNext();
			}
			return true;
		}
		public String next() throws Exception {
			if(!st.hasMoreTokens()){
				st = new StringTokenizer(br.readLine().trim());
				return next();
			}
			return st.nextToken();
		}
		public double nextDouble() throws Exception{
			return Double.parseDouble(next());
		}
		public float nextFloat() throws Exception{
			return Float.parseFloat(next());
		}
		public long nextLong() throws Exception{
			return Long.parseLong(next());
		}
		public int nextInt() throws Exception{
			return Integer.parseInt(next());
		}
		public String nextLine() throws Exception{
			return br.readLine();
		}
	}


}

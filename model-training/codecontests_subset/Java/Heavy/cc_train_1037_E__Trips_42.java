import java.io.*;
import java.util.*;

public class Trips {
	public static void main(String[] args) {
		FastScanner scan=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int n=scan.nextInt(), m=scan.nextInt();
		k=scan.nextInt();
		deg=new int[n];
		a=new ArrayList[n];
		for(int i=0;i<n;i++) a[i]=new ArrayList<>();
		int[] u=new int[m], v=new int[m];
		for(int i=0;i<m;i++) {
			u[i]=scan.nextInt()-1;
			v[i]=scan.nextInt()-1;
			a[u[i]].add(new edge(i,v[i]));
			a[v[i]].add(new edge(i,u[i]));
			deg[u[i]]++;
			deg[v[i]]++;
		}
		left=n;
		ind=m;
//		System.out.println(Arrays.toString(deg));
		bad=new boolean[n];
		for(int i=0;i<n;i++) {
			if(deg[i]<k&&!bad[i]) {
				go(i);
//				System.out.println(Arrays.toString(deg));
//				System.out.println(left);
//				System.out.println(Arrays.toString(bad));
			}
		}
		int[] res=new int[m];
		res[m-1]=left;
		for(ind=m-1;ind>0;ind--) {
			if(!bad[v[ind]]) deg[u[ind]]--;
			if(!bad[u[ind]]) deg[v[ind]]--;

			if(!bad[v[ind]]&&deg[v[ind]]<k) {
				go(v[ind]);
			}

			if(!bad[u[ind]]&&deg[u[ind]]<k) {
				go(u[ind]);
			}
			res[ind-1]=left;
			//			System.out.println(Arrays.toString(deg));
		}
		for(int i:res) out.println(i);
		out.close();
	}
	static int left,ind;
	static boolean[] bad;
	static int[] deg;
	static ArrayList<edge>[] a;
	static int k;

	public static void go(int at) {
		bad[at]=true;
		ArrayDeque<Integer> q=new ArrayDeque<>();
		left--;
		q.offer(at);
		while(!q.isEmpty()) {
			int c=q.poll();
			for(edge nxt:a[c]) {
				if(nxt.id>=ind) continue;
				if(!bad[nxt.v]&&--deg[nxt.v]<k) {
					q.offer(nxt.v);
					bad[nxt.v]=true;
					left--;
				}
			}
		}
	}
	static class edge {
		int id,v;
		edge(int id, int v) {
			this.id=id;
			this.v=v;
		}
	}
	/*
	5 4 2
	1 2
	2 3
	3 4
	4 5
	*/
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
			} catch (Exception e){e.printStackTrace();}
		}

		public String next() {
			if (st.hasMoreTokens())	return st.nextToken();
			try {st = new StringTokenizer(br.readLine());}
			catch (Exception e) {e.printStackTrace();}
			return st.nextToken();
		}

		public int nextInt() {return Integer.parseInt(next());}

		public long nextLong() {return Long.parseLong(next());}

		public double nextDouble() {return Double.parseDouble(next());}

		public String nextLine() {
			String line = "";
			if(st.hasMoreTokens()) line = st.nextToken();
			else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
			while(st.hasMoreTokens()) line += " "+st.nextToken();
			return line;
		}
	}
}
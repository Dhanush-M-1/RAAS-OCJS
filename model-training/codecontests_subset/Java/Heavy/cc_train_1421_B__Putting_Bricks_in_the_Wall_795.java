// package oct2020;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class cf_subs {
	static FastReader scn = new FastReader();
	static OutputStream out = new BufferedOutputStream(System.out);
	static long MOD = (long)1e9+7;
	static int n,dirs[][]= {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean cfg[][];
	static char[][] g;
	static HashSet<String> vis;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println(1l<<35);
		int tc = scn.nextInt();
//		System.out.println(1l<<31);
		while(tc-->0) {
			n = scn.nextInt();
			g = new char[n][n];
			for(int i=0;i<n;i++) {
				g[i]=scn.next().toCharArray();
			}
//			HashSet<String> res = new HashSet<>();
//			vis = new HashSet<>();
//			cfg = new boolean[n][n];
//			dfs(0,0,0);
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<n;j++) {
//					System.out.print(cfg[i][j]?1:0);
//				}
//				System.out.println();
//			}
//			if(cfg[0][1]) {
//				res.add("1 2");
//			}
//			if(cfg[1][0]) {
//				res.add("2 1");
//			}
//			cfg = new boolean[n][n];
//			dfs(0,0,1);
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<n;j++) {
//					System.out.print(cfg[i][j]?1:0);
//				}
//				System.out.println();
//			}
//			if(cfg[0][1]) {
//				res.add("1 2");
//			}
//			if(cfg[1][0]) {
//				res.add("2 1");
//			}
//			out.write((res.size()+"\n").getBytes());
//			for(String s: res) {
//				out.write((s+"\n").getBytes());
//			}
			int a = g[0][1]-'0',b = g[1][0]-'0',c = g[n-1][n-2]-'0',d = g[n-2][n-1]-'0';
			if(a==b) {
				if(c==d) {
					if(a!=c) {
						out.write("0\n".getBytes());
					}else {
						out.write("2\n".getBytes());
						out.write("1 2\n".getBytes());
						out.write("2 1\n".getBytes());
					}
				}else {
					out.write("1\n".getBytes());
					if(c==a) {
						out.write((n+" "+(n-1)+"\n").getBytes());
					}else {
						out.write((n-1+" "+(n)+"\n").getBytes());
					}
				}
			}else {
				if(c==d) {
					if(a==c) {
						out.write("1\n".getBytes());
						out.write("1 2\n".getBytes());
					}else {
						out.write("1\n".getBytes());
						out.write("2 1\n".getBytes());
					}
				}else {
					out.write("2\n".getBytes());
					if(a==d) {
						out.write("1 2\n".getBytes());
						out.write((n+" "+(n-1)+"\n").getBytes());
					}else {
						out.write("1 2\n".getBytes());
						out.write((n-1+" "+n+"\n").getBytes());
					}
				}
			}
		}
		out.close();
	}
	static void dfs(int i, int j, int c){
		if(i==n-1&&j==n-1) {
			cfg[i][j]=true;
			return;
		}
		vis.add(i+" "+j);
		for(int k=0;k<dirs.length;k++) {
			if(i+dirs[k][0]>=0&&i+dirs[k][0]<n&&j+dirs[k][1]>=0&&j+dirs[k][1]<n&&(g[i+dirs[k][0]][j+dirs[k][1]]==(char)(c+'0')||g[i+dirs[k][0]][j+dirs[k][1]]=='F')&&!vis.contains((i+dirs[k][0]+" "+(j+dirs[k][1])))){
				dfs(i+dirs[k][0],j+dirs[k][1],c);
				if(cfg[i+dirs[k][0]][j+dirs[k][1]]) {
					cfg[i][j]=true;
				}
			}
		}
		vis.remove(i+" "+j);
	}
//	static class Page implements Comparable<Page>{
//		int pno;
//		ArrayList<String> strs;
//		ArrayList<Page> kids;
//		public Page(int pno) {
//			this.pno=pno;
//			this.strs = new ArrayList<>();
//			this.kids = new ArrayList<>();
//		}
//		public int compareTo(Page o) {
//			return this.pno-o.pno;
//		}
//	}
//	static void dijkstra(int s) {
//		int v = s;
//		Arrays.fill(d[v], Integer.MAX_VALUE);
//		d[s][s]=0;
//		TreeSet<Pair<Integer,Integer>> pq = new TreeSet<>();
//		pq.add(new Pair<Integer,Integer>(d[s][s],s));
//		while(!pq.isEmpty()) {
////			System.out.println(pq);
//			int u= pq.pollFirst().second;
//			
//			for(Pair<Integer,Integer> p: g[u]) {
//				if(d[s][p.first]>d[s][u]+p.second) {
//					pq.remove(new Pair<Integer, Integer>(d[s][p.first],p.first));
//					d[s][p.first]=d[s][u]+p.second;
//					pq.add(new Pair<Integer,Integer>(d[s][p.first],p.first));
//				}
//			}
//		}
//	}
	static class Interval implements Comparable<Interval>{
		int l,r;
		public Interval(int l,int r) {
			this.l = l;
			this.r = r;
		}
		public int compareTo(Interval o){
			if(this.l==o.l) {
				return this.r-o.r;
			}
			return this.l-o.l;
		}
	}
	static class Edge implements Comparable<Edge>{
		int u,v,w;
		public Edge(int u, int v, int w) {
			this.u=u;this.v =v;this.w =w;
		}
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
		public String toString() {
			return "["+u+','+v+','+w+']';
		}
	}
	static class Pair<S extends Comparable<S>,T extends Comparable<T>> implements Comparable<Pair<S,T>>{
		S first;
		T second;
		public Pair() {
			this.first=null;
			this.second =null;
		}
		public Pair(S first) {
			this.first = first;
			this.second =null;
		}
		public Pair(S first, T second) {
			this.first = first;
			this.second = second;
		}
		public int compareTo(Pair<S,T> o) {
			if(this.first.compareTo(o.first)==0) {
				return this.second.compareTo(o.second);
			}
			return this.first.compareTo(o.first);
		}
		public String toString() {
			return "{"+this.first.toString()+","+this.second.toString()+"}";
		}
	}
	static int log(long N) {
		// TODO Auto-generated method stub
		return 63- Long.numberOfLeadingZeros(N);
	}
	static int lowerBound(int[] a, int x,int lf,int rg) {
		int l = lf-1, r = rg+1;
		while (r - l > 1) {
			int c = (l + r) / 2;
			if (a[c] < x) {
				//if (a[c] > x) {
				l = c;
			} else {
				r = c;
			}
		}
		return r;
	}
	static int upperBound(int[] a, int x,int lf,int rg) {
		int l = lf-1, r = rg+1;
		while (r - l > 1) {
			int c = (l + r) / 2;
			if (a[c] <= x) {
				l = c;
			} else {
				r = c;
			}
		}
		return r;
	}
 
	static int lowerBound(long[] a, long x) {
		int l = -1, r = a.length;
		while (r - l > 1) {
			int c = (l + r) / 2;
			if (a[c] < x) {
				l = c;
			} else {
				r = c;
			}
		}
		return r;
	}
 
	static int upperBound(long[] a, long x) {
		int l = -1, r = a.length;
		while (r - l > 1) {
			int c = (l + r) / 2;
			if (a[c] <= x) {
				l = c;
			} else {
				r = c;
			}
		}
		return r;
	}
 
	static int lowerBound(double[] a, double x) {
		int l = -1, r = a.length;
		while (r - l > 1) {
			int c = (l + r) / 2;
			if (a[c] < x) {
				l = c;
			} else {
				r = c;
			}
		}
		return r;
	}
 
	static int upperBound(double[] a, double x) {
		int l = -1, r = a.length;
		while (r - l > 1) {
			int c = (l + r) / 2;
			if (a[c] <= x) {
				l = c;
			} else {
				r = c;
			}
		}
		return r;
	}
 
	static <T> int lowerBound(List<T> ls, T x) throws RuntimeException {
		if (ls.size() == 0)
			return -1;
		if (ls.get(0) instanceof Integer) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Integer) t1).compareTo((Integer) t2) >= 0 ? 1 : -1);
		} else if (ls.get(0) instanceof Long) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Long) t1).compareTo((Long) t2) >= 0 ? 1 : -1);
		} else if (ls.get(0) instanceof Double) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Double) t1).compareTo((Double) t2) >= 0 ? 1 : -1);
		} else {
			System.err.println(
					String.format("%s:Arey Maa chudi padi hai", Thread.currentThread().getStackTrace()[1].getMethodName()));
			throw new RuntimeException();
		}
	}
 
	static <T> int upperBound(List<T> ls, T x) throws RuntimeException {
		if (ls.size() == 0)
			return -1;
		if (ls.get(0) instanceof Integer) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Integer) t1).compareTo((Integer) t2) > 0 ? 1 : -1);
		} else if (ls.get(0) instanceof Long) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Long) t1).compareTo((Long) t2) > 0 ? 1 : -1);
		} else if (ls.get(0) instanceof Double) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Double) t1).compareTo((Double) t2) > 0 ? 1 : -1);
		} else {
			System.err.println(
					String.format("%s:Arey Maa chudi padi hai", Thread.currentThread().getStackTrace()[1].getMethodName()));
			throw new RuntimeException();
		}
	}
 
	static <T> int rupperBound(List<T> ls, T x) throws RuntimeException {
		if (ls.size() == 0)
			return -1;
		if (ls.get(0) instanceof Integer) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Integer) t1).compareTo((Integer) t2) < 0 ? 1 : -1);
		} else if (ls.get(0) instanceof Long) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Long) t1).compareTo((Long) t2) < 0 ? 1 : -1);
		} else if (ls.get(0) instanceof Double) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Double) t1).compareTo((Double) t2) < 0 ? 1 : -1);
		} else {
			System.err.println(
					String.format("%s:Arey maa chudi padi hai", Thread.currentThread().getStackTrace()[1].getMethodName()));
			throw new RuntimeException();
		}
	}
 
	static <T> int rlowerBound(List<T> ls, T x) {
		if (ls.size() == 0)
			return -1;
		if (ls.get(0) instanceof Integer) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Integer) t1).compareTo((Integer) t2) <= 0 ? 1 : -1);
		} else if (ls.get(0) instanceof Long) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Long) t1).compareTo((Long) t2) <= 0 ? 1 : -1);
		} else if (ls.get(0) instanceof Double) {
			return ~Collections.binarySearch(ls, x, (t1, t2) -> ((Double) t1).compareTo((Double) t2) <= 0 ? 1 : -1);
		} else {
			System.err.println(
					String.format("%s:Arey maa chudi padi hai", Thread.currentThread().getStackTrace()[1].getMethodName()));
			throw new RuntimeException();
		}
	}
	public static int[] merge(int[] one,int[] two){
		int[] res = new int[one.length+two.length];
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i<one.length&&j<two.length){
			if(one[i]<two[j]){
				res[k] = one[i];
				i++;
				k++;
			}
			else{
				res[k] = two[j];
				j++;
				k++;
			}
		}
		
		if(i==one.length){
			while(j<two.length){
				res[k] = two[j];
				j++;
				k++;
			}
		}
		else{
			while(i<one.length){
				res[k] = one[i];
				k++;
				i++;
			}
		}
		return res;
	}
	public static int[] mergesort(int[] arr, int l, int r){
		if(l==r){
			int[] br = new int[1];
			br[0] = arr[l];
			return br;
		}
		int mid = (l+r)/2;
		int[] fh = mergesort(arr,l,mid);
		int[] sh = mergesort(arr,mid+1,r);
		
		return merge(fh,sh);
	}
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }

}

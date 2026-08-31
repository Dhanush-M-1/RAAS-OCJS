import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
the last 0 in the sequence must be the 1 in the permutation
cuz there cannot be any 0's after it, cuz they would be at least 1
so take the 1 and then subtract 1 from every element after
then 2 must be the last 0
and so on

find last 0 with segtree and binary search log^2(n)
and do the range updates in segtree log(n)
*/

public class manthan19d {
	public static void main(String[] args) {
		FastScanner scan=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int n=scan.nextInt();
		node root=new node(1,n);
		for(int i=1;i<=n;i++) {
			root.add(i,i,scan.nextLong());
		}
		int[] res=new int[n];
		for(int ct=1;ct<=n;ct++) {
			int lo=1, hi=n;
			
			while(hi>=lo) {
				int mid=(hi+lo)/2;
				if(root.min(mid,n)==0) {
					lo=mid+1;
				}
				else {
					hi=mid-1;
				}
			}
			if(hi+1<=n) root.add(hi+1,n,-ct);
			root.add(hi,hi,Long.MAX_VALUE/2);
			res[hi-1]=ct;
		}
		for(int i:res) {
			out.print(i);
			out.print(" ");
		}
		out.close();
	}
	static class node {
		node l=null,r=null;
		int lo,hi;
		long delta,min;
		
		node(int lo, int hi) {
			this.lo=lo;
			this.hi=hi;
			delta=0L;
			min=0L;
			if(lo!=hi) {
				int m=(lo+hi)/2;
				l=new node(lo,m);
				r=new node(m+1,hi);
			}
		}
		
		void add(int nlo, int nhi, long add) {
			if(nlo<=lo&&hi<=nhi) {
				//covers entire interval
				delta+=add;
				return;
			}
			if(lo>nhi||hi<nlo) {
				//covers nothing
				return;
			}
			push();
			l.add(nlo,nhi,add);
			r.add(nlo,nhi,add);
			update();
		}
		
		long min(int nlo, int nhi) {
			if(nlo<=lo&&hi<=nhi) {
				//covers entire interval
				return min+delta;
			}
			if(lo>nhi||hi<nlo) {
				//covers nothing
				return Long.MAX_VALUE;
			}
			push();
			long left=l.min(nlo,nhi);
			long right=r.min(nlo,nhi);
			update();
			
			return Math.min(left,right);
		}
		void update() {
			min=Math.min(l.min+l.delta,r.min+r.delta);
		}
		void push() {
			l.delta+=delta;
			r.delta+=delta;
			delta=0;
		}
	}
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
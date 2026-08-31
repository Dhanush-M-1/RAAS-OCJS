import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class g {
	public static void main(String[] args) {
		FastScanner scan=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		
		int t=scan.nextInt();
		for(int tt=0;tt<t;tt++) {
			int n=scan.nextInt(), q=scan.nextInt();
			long sum=0;
			segtree tree=new segtree(n+10);
			
			for(int i=0;i<n;i++) {
				int x=scan.nextInt();
				sum+=x;
				tree.increment(i+2,i+2,sum);
			}
			
			//prefix sum starts at 1, tree[1]=0, etc
			
			long max=tree.rangeMax(1,1,n+5);
			
			for(int i=0;i<q;i++) {
				int x=scan.nextInt();
				
				if(max<x&&sum<=0) {
					out.print(-1+" ");
					continue;
				}
//				System.out.println(max+" "+sum);
				long res=0L;
				
				long achieve=x-max;
				long achieved=0;
				
				if(achieve>0) {
					long div=achieve/sum;
					res+=div*n;
					achieved+=div*sum;
					if(achieve%sum!=0) {
						res+=n;
						achieved+=sum;
					}
				}
				long left=x-achieved;
				res+=tree.minIdAtleastVal(1,1,n+5,left);
				
				out.print(res-2+" ");
			}
			out.println();
		}
		out.close();
	}
	static class segtree {
		int n;
		int[] lo, hi;
		long[] min, max, sum, delta;

		segtree(int n) {
			this.n=n;
			lo=new int[4*n+1];//low end of range for each node
			hi=new int[4*n+1];//high end of range for each node
			min=new long[4*n+1];
			max=new long[4*n+1];
			sum=new long[4*n+1];
			delta=new long[4*n+1];

			init(1,0,n-1);//init for root node and it is the entire range
		}

		void init(int i, int a, int b) {
			lo[i]=a;
			hi[i]=b;

			if(a==b) return;//you are at a leaf

			int m=(a+b)/2;
			init(2*i,a,m);//recur for left child
			init(2*i+1,m+1,b);//recur for right child
		}

		//Lazy propagation (push delta to children)
		void prop(int i) {
			delta[2*i]+=delta[i];
			delta[2*i+1]+=delta[i];
			delta[i]=0;
		}

		//update range minimum
		void update(int i) {
			min[i]=Math.min(min[2*i]+delta[2*i],min[2*i+1]+delta[2*i+1]);
			max[i]=Math.max(max[2*i]+delta[2*i],max[2*i+1]+delta[2*i+1]);
			
			sum[i]=sum[2*i]+((hi[2*i]-lo[2*i]+1)*delta[2*i]);
			sum[i]+=sum[2*i+1]+((hi[2*i+1]-lo[2*i+1]+1)*delta[2*i+1]);
		}
		void increment(int a, int b, long val) {
			increment(1,a,b,val);
		}
		void increment(int i, int a, int b, long val) {
			if(hi[i]<a||lo[i]>b) return;//no cover

			if(lo[i]>=a&&hi[i]<=b) {//full cover
				delta[i]+=val;
				return;
			}

			//partial cover
			prop(i);

			increment(2*i,a,b,val);
			increment(2*i+1,a,b,val);

			update(i);
		}

		int minIdAtleastVal(int i, int a, int b, long val) {
			//whats the min id from a to b that is at least val?
			if(hi[i]<a||lo[i]>b) return Integer.MAX_VALUE;//no cover
			
			if(lo[i]>=a&&hi[i]<=b) {//full cover
				if(max[i]+delta[i]<val) return Integer.MAX_VALUE;
			}
			
			if(lo[i]==hi[i]) {
				return max[i]+delta[i]>=val?lo[i]:Integer.MAX_VALUE;
			}
			prop(i);
			
			int solnleft=minIdAtleastVal(2*i,a,b,val);
			
			if(solnleft!=Integer.MAX_VALUE) {
				update(i);
				return solnleft;
			}
			
			int solnright=minIdAtleastVal(2*i+1,a,b,val);
			
			update(i);
			return solnright;
		}
		
		long rangeMin(int i, int a, int b) {
			if(hi[i]<a||lo[i]>b) return Long.MAX_VALUE;//no cover

			if(lo[i]>=a&&hi[i]<=b) {//full cover
				return min[i]+delta[i];
			}

			//partial cover

			prop(i);

			long left=rangeMin(2*i,a,b);
			long right=rangeMin(2*i+1,a,b);

			update(i);

			return Math.min(left,right);
		}

		long rangeMax(int i, int a, int b) {
			if(hi[i]<a||lo[i]>b) return Long.MIN_VALUE;//no cover

			if(lo[i]>=a&&hi[i]<=b) {//full cover
				return max[i]+delta[i];
			}

			//partial cover

			prop(i);

			long left=rangeMax(2*i,a,b);
			long right=rangeMax(2*i+1,a,b);

			update(i);

			return Math.max(left,right);
		}

		long rangeSum(int i, int a, int b) {
			if(hi[i]<a||lo[i]>b) return 0;//no cover

			if(lo[i]>=a&&hi[i]<=b) {//full cover
				return sum[i]+delta[i]*(hi[i]-lo[i]+1);
			}

			//partial cover

			prop(i);

			long left=rangeSum(2*i,a,b);
			long right=rangeSum(2*i+1,a,b);

			update(i);

			return left+right;
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
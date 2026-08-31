import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out= new PrintWriter(System.out);
		int n= in.nextInt();
		int rt= in.nextInt();
		int a= in.nextInt();
		int b= in.nextInt();
		int q= in.nextInt();
		long [] tot= new long[(int) 2e5+5];
		fenwick slow= new fenwick((int) 2e5+5);
		fenwick fast= new fenwick((int) 2e5+5);
		for(int i=0; i<q; i++){
			int key= in.nextInt();
			if(key==1){
				int d= in.nextInt();
				int order= in.nextInt();
				slow.update(d, Math.max(Math.min(order, b-tot[d]), 0));
				fast.update(d, Math.max(Math.min(order, a-tot[d]), 0));
				tot[d]+=order;
			}
			else{
				int d= in.nextInt();
				long res= slow.sum(d-1)+ fast.sum(n)-fast.sum(d+rt-1);
				out.println(res);
			}
		}
		out.close();
	}
	static class fenwick{
		long [] tree;
		int len;
		public fenwick(int n){
			tree= new long[n];
			len=n;
		}
		void update(int i, long l){
			while(i<len){
				tree[i]+=l;
				i+=(i&-i);
			}
		}
		long sum(int i){
			long sum= 0;
			while(i>0){
				sum+=tree[i];
				i-= (i&-i);
			}
			return sum;
		}
	}
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer("");
		}
		public String next() throws IOException {
			if(!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
				return next();
			}
			return st.nextToken();
		}
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}

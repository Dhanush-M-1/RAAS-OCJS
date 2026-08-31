import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class RestorePermutation_D_CF_Manthan {
static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws Exception{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
		int n=Integer.parseInt(bf.readLine());
			long[] s=new long[n];
			st=new StringTokenizer(bf.readLine());
			int ans[]=new int[n];
			FenwickTree ft= new FenwickTree(n);
			for(int i=0;i<n;i++)
			s[i]=Long.parseLong(st.nextToken());
			for(int i=n-1;i>=0;i--) {
				int lo=1,hi=n;
				while(hi-lo>=0) {
					int mid=lo+hi>>1;
					long x=sum(mid-1);
					x-=ft.query(mid-1);
					if(x<s[i]) {
						lo=mid+1;
					}else if(x>s[i]) {
						hi=mid-1;
						
					}else {
						ans[i]=mid;
						lo=mid+1;
						
					}
				}
				ft.update(ans[i], ans[i]);
			}
			for(int i=0;i<n;i++) {
				pw.print(ans[i]+" ");
			}
			pw.println();
			pw.flush();
	}
	static long sum(int x) {
		return (x*1l*(x+1))/2;
	}
	static class FenwickTree{
		int n;
		long ft[];
		
public FenwickTree(int n) {
			this.n=n;
			ft=new long[n+1];
		}
		public void update(int idx,int val) {
			while(idx<=n) {
				ft[idx]+=val;
				idx+=(idx&-idx);
			}
		}
		 long query(int i) {
			long sum=0;
			while(i>0) {
				sum+=ft[i];
				i-=i&-i;
			}
			return sum;
		}
	}

}

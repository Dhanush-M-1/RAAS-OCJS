import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class C{
	public static void main(String[] args){
		FastReader sc = new FastReader();
		int t=sc.nextInt();
		a:while(t-->0){
			int k=sc.nextInt();
			int n=sc.nextInt();
			int m=sc.nextInt();
			int a[]=new int [n];
			int b[]=new int [m];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			for(int i=0;i<m;i++)b[i]=sc.nextInt();
			ArrayList<Integer> ans= new ArrayList<>();
			int up=0,down=0;
			for(int i=0;i<n+m;i++) {
				if( up<n && a[up]==0) { // new line added
					ans.add(a[up]);
					k++;
					up++;
				}else if(down<m && b[down]==0) {  // new line added
					ans.add(b[down]);
					k++;
					down++;
				}else if(up<n && a[up]<=k) {  // line updated
					ans.add(a[up]);
					up++;
				}
				else if(down<m && b[down]<=k) {  // line updated
					ans.add(b[down]);
					down++;
				}
				else {
					System.out.println(-1);
					continue a;
				}
			}
			Object res[]= ans.toArray();
			for(Object i:res)System.out.print(i+" ");
			System.out.println();
		}		
	}
	static class ind {
		int x;int y;
		 ind(int x,int y){
			this.x=x;
			this.y=y;
		}
		
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(
				new InputStreamReader(System.in));
		}

		String next()
		{
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() { return Integer.parseInt(next()); }

		long nextLong() { return Long.parseLong(next()); }

		double nextDouble()
		{
			return Double.parseDouble(next());
		}

		String nextLine()
		{
			String str = "";
			try {
				str = br.readLine();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codefest18B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out=new PrintWriter(new BufferedOutputStream(System.out));
		FastReader s=new FastReader();
		int n=s.nextInt();
		int re=s.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		long ans=0;
		Arrays.sort(arr);
		int mid=arr[n/2];
		if(mid==re) {
			
		}else if(mid<re) {
			ans+=re-mid;
			int last=re;
			for(int i=n/2+1;i<n;i++) {
				if(last>arr[i]) {
					ans+=last-arr[i];
				}else {
					break;
				}
			}
		}else if(mid>re) {
			ans+=mid-re;
			int last=re;
			for(int i=n/2-1;i>=0;i--) {
				if(last<arr[i]) {
					ans+=arr[i]-last;
				}else {
					break;
				}
			}
		}
		out.println(ans);
		out.close();
	}

	public static PrintWriter out;
	
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		//it reads the data about the specified point and divide the data about it ,it is quite fast
		//than using direct 

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());//converts string to integer
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	
}

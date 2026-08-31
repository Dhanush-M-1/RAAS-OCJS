import java.util.*;
import java.io.*;

public class LevkoAndArray {
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		long[] bound = new long[n];
		Arrays.fill(bound, 1000000000L);
		String[] queries = new String[m];
		for(int i=0; i<m; i++){
			queries[i] = rd.readLine();
			st = new StringTokenizer(queries[i]);
			int fir = Integer.parseInt(st.nextToken());
			if(fir==1){
				int l = Integer.parseInt(st.nextToken()) - 1, r = Integer.parseInt(st.nextToken()) - 1,
						d = Integer.parseInt(st.nextToken());
				for(int x=l; x<=r; x++)
					a[x] += d;
			}
			else{
				int l = Integer.parseInt(st.nextToken()) - 1, r = Integer.parseInt(st.nextToken()) - 1,
						max = Integer.parseInt(st.nextToken());
				for(int x=l; x<=r; x++){
					long newBound = max - a[x];
					bound[x] = Math.min(newBound, bound[x]);
				}
			}
		}
		long[] res = new long[n];
		for(int i=0; i<n; i++){
			res[i] = bound[i];
			if(res[i]<-1000000000){
				System.out.println("NO");
				return;
			}
		}
		for(int i=0; i<m; i++){
			st = new StringTokenizer(queries[i]);
			int fir = Integer.parseInt(st.nextToken());
			if(fir==1){
				int l = Integer.parseInt(st.nextToken()) - 1, r = Integer.parseInt(st.nextToken()) - 1,
						d = Integer.parseInt(st.nextToken());
				for(int x=l; x<=r; x++)
					res[x] += d;
			}
			else{
				int l = Integer.parseInt(st.nextToken()) - 1, r = Integer.parseInt(st.nextToken()) - 1,
						max = Integer.parseInt(st.nextToken());
				long realMax = res[l];
				for(int x=l; x<=r; x++){
					realMax = Math.max(realMax, res[x]);
				}
				if(max!=realMax){
					System.out.println("NO");
					return;
				}
			}
		}
		pw.println("YES");
		for(int i=0; i<n; i++){
			pw.print(bound[i]+" ");
		}
		pw.println();
		pw.flush();
	}
}

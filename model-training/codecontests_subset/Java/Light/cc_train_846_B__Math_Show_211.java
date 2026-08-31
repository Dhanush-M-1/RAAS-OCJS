import java.util.*;
import java.io.*;
public class B846_2 {
	public static void main(String args[])throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		int a[] = new int[k];
		int result =0;
		st = new StringTokenizer(br.readLine());
		long sum = 0;
		for(int i=0; i<k; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			sum += a[i];
		}
		Arrays.sort(a);
		int ans = 0;
		for(int x=0;x<=n;x++) {
			long time = x * sum;
			int points = 0;
			long m = M;
			if(m >= time) {
				points = x * (k + 1);
				m-= time;
				for(int i=0;i<k;i++) {
					points += Math.min((n-x), (m/a[i]));
					m -= Math.min((a[i]*(n-x)), (a[i]*(m/a[i])));
				}
			}
			ans = Math.max(ans, points);
		}
		out.println(ans);
		out.flush();
	}
}
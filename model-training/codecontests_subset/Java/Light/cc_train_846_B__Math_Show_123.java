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
			if(time <= M) {
				points = x * (k + 1);
				for(int i=0;i<k;i++) {
					for(int j=0;j<(n-x);j++) {
						if(time + a[i] <= M) {
							time += a[i];
							points++;
						}
					}
				}
			}
			ans = Math.max(ans, points);
		}
		out.println(ans);
		out.flush();
	}
	static class Items implements Comparable<Items> {
		int index, points, time;
		double cost;
		public Items (int index, int points, int time) {
			this.index = index;
			this.points = points;
			this.time = time;
			cost = (double)time / points;
		}
		public int compareTo(Items a) {
			return Double.compare(this.cost, a.cost);
		}
	}
}
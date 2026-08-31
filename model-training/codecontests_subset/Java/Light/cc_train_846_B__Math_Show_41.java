import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class b {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), k = in.nextInt();
		long m = in.nextInt();
		long[] arr = new long[k];
		long sum = 0;
		for(int i=0;i<k;i++) {
			arr[i] = in.nextLong();
			sum += arr[i];
		}
		Arrays.sort(arr);
		long ans = 0;
		for(int i=0;i<=n;i++) {
			if(sum * i > m) break;
			long tm = m-sum*i;
			long s = i * (k+1);
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for(long v : arr) {
				for(int j=0;j<n-i;j++)
					pq.offer(v);
			}
			while(!pq.isEmpty()) {
				tm -= pq.poll();
				if(tm < 0) break;
				s++;
			}
			ans = Math.max(ans, s);
		}
		System.out.println(ans);
	}
}

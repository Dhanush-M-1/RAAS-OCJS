import java.util.*;
import java.io.*;
 
public class Equalizing_by_Division_hard_version {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[n];
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		int max = -1;
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[i] = x;
			max = Math.max(max, x);
		}
		PriorityQueue<Integer>[] q = new PriorityQueue[max + 1];
		for (int i = 0; i < max + 1; i++) {
			q[i] = new PriorityQueue<Integer>();
		}
		int num = 0;
		int count = 0;
		int ans = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			int x = arr[i];
			count = 0;
			q[x].add(0);
			while (x > 0) {
				count++;
				x /= 2;
				q[x].add(count);
			}
		}
		//System.out.println(Arrays.toString(q));
		for (int i = 0; i < max + 1; i++) {
			int steps = 0;
			num = 0;
			for (int j = 0; j < k; j++) {
				if (!q[i].isEmpty()) {
					steps++;
					num += q[i].poll();
				}else {
					break;
				}
			}
			if (steps == k) {
				ans = Math.min(ans, num);
			}
		}
		pw.println(ans);
		pw.flush();
		pw.close();
	}
}
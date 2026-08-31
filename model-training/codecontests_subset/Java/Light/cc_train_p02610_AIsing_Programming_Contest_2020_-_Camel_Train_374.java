import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			long ans = 0;
			List<Integer>[] X = new ArrayList[N+1];
			List<Integer>[] Y = new ArrayList[N+1];
			for(int i = 0; i <= N; i++) {
				X[i] = new ArrayList<>();
				Y[i] = new ArrayList<>();
			}
			for(int i = 0; i < N; i++) {
				int K = sc.nextInt()-1;
				int L = sc.nextInt();
				int R = sc.nextInt();
				if(L - R > 0) {
					ans += L;
					X[K].add(L - R);
				}
				else {
					if(K == N - 1)
						ans += L;
					else {
						ans += R;
						Y[K+1].add(R - L);
					}
				}
			}
			PriorityQueue<Integer> pq1 = new PriorityQueue<>();
			PriorityQueue<Integer> pq2 = new PriorityQueue<>();
			for(int i = 0; i < N; i++) {
				for(int x : X[i])
					pq1.offer(x);
				while(pq1.size() > i + 1)
					ans -= pq1.poll();
				for(int y : Y[N-1-i])
					pq2.offer(y);
				while(pq2.size() > i + 1)
					ans -= pq2.poll();
			}
			System.out.println(ans);
		}
	}

}
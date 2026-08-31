import java.util.*;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] books = new int[N];
		int[] order = new int[M];
		for (int i = 0; i < N; i++) books[i] = sc.nextInt();
		for (int i = 0; i < M; i++) order[i] = sc.nextInt();
		
		boolean[] used = new boolean[N+1];
		ArrayList<Integer> o = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			if (!used[order[i]]) {
				used[order[i]] = true;
				o.add(order[i]);
			}
		}
		int totsum = 0;
		for (int i = 0; i < M; i++) {
			int lookingFor = order[i];
			int sum = 0;
			for (int j = 0; j < o.size(); j++) {
				if (o.get(j) == lookingFor) {
					o.remove((int)j);
					break;
				} else {
					sum += books[o.get(j)-1];
				}
			}
			o.add(0, (Integer) lookingFor);
			totsum += sum;
		}
		System.out.println(totsum);
	}
}
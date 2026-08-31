import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		PriorityQueue<Integer> bothq = new PriorityQueue<>();
		PriorityQueue<Integer> aq = new PriorityQueue<>();
		PriorityQueue<Integer> bq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int t = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			
			if (a == 1 && b == 1) {
				bothq.add(t);
			} else if (a == 1) {
				aq.add(t);
			} else if (b == 1) {
				bq.add(t);
			}
		}
		
		if (bothq.size() + aq.size() < k || bothq.size() + bq.size() < k) {
			System.out.println(-1);
			return;
		}
		
		int count = 0;
		int res = 0;
		while (count < k) {
			if (bothq.isEmpty()) {
				res += aq.poll();
				res += bq.poll();
			} else if (aq.isEmpty() || bq.isEmpty()) {
				res += bothq.poll();
			} else if (bothq.peek() > aq.peek() + bq.peek()) {
				res += aq.poll();
				res += bq.poll();
			} else {
				res += bothq.poll();
			}
			count++;
		}
		
		System.out.println(res);
	}


}

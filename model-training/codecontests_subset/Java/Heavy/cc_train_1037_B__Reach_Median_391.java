import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {		
		
		Scanner scan = new Scanner(System.in);
	
		PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>(16 , (i1 , i2) -> {
			if (i1 > i2) {
				return - 1;
			} else if (i1 < i2) {
				return 1;
			} else {
				return 0;
			}
		});
		PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>(16 , (i1 , i2) -> {
			if (i1 < i2) {
				return - 1;
			} else if (i1 > i2) {
				return 1;
			} else {
				return 0;
			}
		});
		
		int i , n = scan.nextInt() , s = scan.nextInt() , cnt = 0;
		for (i = 0;i < n;i ++) {
			int value = scan.nextInt();
			if (value < s) {
				queue1.add(value);
			} else if (value > s) {
				queue2.add(value);
			} else {
				cnt ++;
			}
		}
		int size = n / 2;
		if (queue1.size() <= size && queue1.size() + cnt >= (n + 1) / 2) {
			System.out.println(0);
		} else {
			// median is not enough
			if (queue1.size() <= size) {
				long ans = 0;
				int temp = queue1.size() + cnt;
				while (temp < (n + 1) / 2) {
					ans += Math.abs(queue2.poll() - s);
					temp ++;
				}
				System.out.println(ans);
			} else {
				long ans = 0;
				while (queue1.size() > size) {
					ans += Math.abs(queue1.poll() - s);
				}
				System.out.println(ans);
			}
		}
		
	}
	
	
}









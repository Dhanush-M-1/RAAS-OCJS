import java.util.PriorityQueue;
import java.util.Scanner;

public class d {	
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		int n = stdin.nextInt();
		int k = stdin.nextInt();
		
		PriorityQueue<Integer>[] arr = new PriorityQueue[200_001];
		for (int i = 0; i < 200_001; i ++) arr[i] = new PriorityQueue<>();
		
		for (int i = 0; i < n; i ++) {
			int in = stdin.nextInt();
			arr[in].add(0);
			int count = 0;
			while (in >= 1) {
				in /= 2;
				arr[in].add(++count);
			}
		}
		
//		for (int i = 1; i < 3; i ++) for (int j = 0; j < arr[i].size(); j ++) System.out.println(arr[i].poll());
		
		int min = 1_000_000_000;
		
		for (int i = 0; i < 200_001; i++) {
			int taken = 0, sum = 0;
			while (!arr[i].isEmpty() && taken < k) {
				sum += arr[i].poll();
				taken ++;
				if (taken == k) min = Math.min(min, sum);
			}
		}
		
		System.out.println(min);
	}
}

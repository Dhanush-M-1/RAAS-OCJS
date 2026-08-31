import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int max = 0;
		long total = 0;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
			total += arr[i];
			max = Math.max(arr[i], max);
		}
		long get = max * n - total;
		if(total < get) {
			System.out.println(max);
		} else {
			long delta = total - get;
			long r = delta / n + 1;
//			if(delta % n == 0) {
//				r++;
//			}
			System.out.println(r + max);
		}
	}
}

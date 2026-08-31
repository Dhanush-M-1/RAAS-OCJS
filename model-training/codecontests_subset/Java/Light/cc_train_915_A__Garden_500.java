import java.util.Arrays;
import java.util.Scanner;

public class P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] bucket = new int[n];
		for (int i = 0; i < n; i++) {
			bucket[i] = sc.nextInt();
		}
		Arrays.sort(bucket);
		
		int proper = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (k % bucket[i] == 0) {
				proper = bucket[i];
				break;
			}
		}
		
		System.out.println(k / proper);
		
		sc.close();
	}
}
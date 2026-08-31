import java.util.*;

public class Main {

	public static void main (String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arrA = new int[n + 1];
		int[] arrB = new int[n + 1];
		int[] arrC = new int[n];
		for (int i = 1; i <= n; i++) {
			arrA[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			arrB[i] = sc.nextInt();
		}
		for (int i = 1; i < n; i++) {
			arrC[i] = sc.nextInt();
		}
		int prev = -1;
		int total = 0;
		for (int i = 1; i <= n; i++) {
			int x = arrA[i];
			total += arrB[x];
			if (prev + 1 == x) {
				total += arrC[prev];
			}
			prev = x;
		}
		System.out.println(total);
	}
}

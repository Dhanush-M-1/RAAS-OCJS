import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n - 1];
		
		Arrays.setAll(a, i -> sc.nextInt() - 1);
		Arrays.setAll(b, i -> sc.nextInt());
		Arrays.setAll(c, i -> sc.nextInt());
		
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			sum += b[a[i]];
			if (a[i + 1] == a[i] + 1) sum += c[a[i]];
		}
		sum += b[a[n - 1]];
		
		System.out.println(sum);
		
		sc.close();
	}
	
}



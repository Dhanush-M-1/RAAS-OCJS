import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[N-1];
		for (int i = 0; i < N; i++)
			a[i] = sc.nextInt()-1;
		for (int i = 0; i < N; i++)
			b[i] = sc.nextInt();
		for (int i = 0; i < N-1; i++)
			c[i] = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += b[a[i]];
			if (i < N-1 && a[i] + 1 == a[i + 1])
				sum += c[a[i]];
		}
		System.out.println(sum);
	}
}

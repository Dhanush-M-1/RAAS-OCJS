import java.util.*;

public class CF385A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), c = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		int max = 0;
		for (int i = 0; i < n-1; i++)
			if (a[i]-a[i+1]-c > max) max = a[i] - a[i+1] - c;
		System.out.println(max);
	}
}

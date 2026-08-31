import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int s = 0;
		int n = sc.nextInt();
		int[] a = new int[n], b = new int[n], c = new int[n-1];

		for(int i = 0; i < n; i++) a[i] = sc.nextInt();
		for(int i = 0; i < n; i++) b[i] = sc.nextInt();
		for(int i = 0; i < n - 1; i++) c[i] = sc.nextInt();

		for(int i = 0; i < n; i++) {
			s += b[a[i] - 1];
			if(i != 0 && a[i - 1] + 1 == a[i]) s += c[a[i] - 2];
		}

		System.out.println(s);
	}
}
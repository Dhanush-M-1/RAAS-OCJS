import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int i, j, n, q, b, e, t;
		try (Scanner sc = new Scanner(System.in)) {
			n = sc.nextInt();
			int[] a = new int[n];
			for(i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			q = sc.nextInt();
			for(i = 0; i < q; i++) {
				b = sc.nextInt();
				e = sc.nextInt();
				t = sc.nextInt();
				for(j = 0; j < e - b; j++) {
					a[b + j] = a[b + j] ^ a[t + j];
					a[t + j] = a[b + j] ^ a[t + j];
					a[b + j] = a[b + j] ^ a[t + j];
				}
			}
			for(i = 0; i < n - 1; i++){
				System.out.print(a[i] + " ");
			}
			System.out.println(a[n - 1]);
		}
	}
}


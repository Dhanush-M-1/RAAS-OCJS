import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n-1];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt()-1;
		}
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		for(int i = 0; i < n-1; i++) {
			c[i] = sc.nextInt();
		}
		int d = b[a[0]];
		for(int i = 1; i < n; i++) {
			d += b[a[i]];
			if(a[i] - a[i-1] == 1) d += c[a[i-1]];
		}
		System.out.println(d);

		sc.close();

	}

}
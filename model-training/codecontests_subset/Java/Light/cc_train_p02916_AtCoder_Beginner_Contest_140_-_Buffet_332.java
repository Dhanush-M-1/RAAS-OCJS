import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		int[] c = new int[n];

		for ( int i = 1; i <= n; i++ )
			a[i] = in.nextInt();
		for ( int i = 1; i <= n; i++ )
			b[i] = in.nextInt();
		for ( int i = 1; i <= n - 1; i++ )
			c[i] = in.nextInt();

		int sum = 0;
		int prev = 0;
		for ( int i = 1; i <= n; i++ ) {
			sum += b[a[i]];
			// System.out.println("a:" + a[i] + " b:" + b[i] + " sum:" + sum);
			
			if(prev == a[i] - 1 ) {
				sum += c[prev];
			}
			
			prev = a[i];
		}

		System.out.println(sum);
		in.close();

	}
}
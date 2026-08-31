import java.util.*;

public class AandBandCompilationErrors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long a = 0 , b = 0 , c = 0;
		for(int i = 0 ; i < n ; i++) {
			long x = sc.nextLong();
			a += x;
		}
		for(int i = 0 ; i < n - 1 ; i++) {
			long x = sc.nextLong();
			b += x;
		}
		for(int i = 0 ; i < n - 2 ; i++) {
			long x = sc.nextLong();
			c += x;
		}
		System.out.println(a - b);
		System.out.println(b - c);
		sc.close();
	}

}

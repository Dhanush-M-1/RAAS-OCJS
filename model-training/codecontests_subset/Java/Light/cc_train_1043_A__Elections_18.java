import java.io.IOException;
import java.util.Scanner;

public class Solutions {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int [] a = new int[100];
		int s1 = 0;
		int mx = -1;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			s1 += a[i];
			if(a[i] > mx)
				mx = a[i];
		}
		
		System.out.println(Math.max((2 * s1 / n) + 1, mx) );
		sc.close();
	}
}

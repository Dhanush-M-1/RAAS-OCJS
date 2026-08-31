import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(new File("test_1.txt"));
		// Scanner sc = new Scanner(new File("test_2.txt"));
		// Scanner sc = new Scanner(new File("in4.txt"));
		int N = sc.nextInt();
		int ans = 0;		
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			boolean is_prime = true;
			for (int i = 2; i * i <= n; i++)
				if (n % i == 0)
					is_prime = false;
			if (is_prime)
				ans++;
		}

		System.out.println(ans);		
	}
}
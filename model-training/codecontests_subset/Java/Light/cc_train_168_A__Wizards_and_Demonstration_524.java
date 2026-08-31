import java.util.Scanner;

public class Task168A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		
		if ((x * 100) >= (y * n)) {
			System.out.println(0);
			System.exit(0);
		}
		
		int c = (n * y) / 100 - x;
		if (((c + x) * 100) < n * y) { c++; }
		
		System.out.println(c);
	}
}
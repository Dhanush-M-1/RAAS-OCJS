import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int a, b, result = 0;
		
		try (Scanner scanner = new Scanner(System.in)) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			result = a;
		}
		
		while (a >= b) {
			result += a/b;
			a = a/b + (a%b);
		}
		
		System.out.println(result);
	}
}

import java.util.Scanner;

public class Codeforces379A {
	public static void main(String[] args) {
		int a, b, sum = 0;
		Scanner scanner = new Scanner(System.in);
		sum = a = scanner.nextInt();
		b = scanner.nextInt();
		for (int i = a; i / b > 0; i = i/b+(i%b))
			sum += (i / b);
		System.out.println(sum);
	}
}

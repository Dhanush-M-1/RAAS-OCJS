import java.util.Scanner;

public class XORinacci_1208A {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t-- > 0) {
			int a = input.nextInt();
			int b = input.nextInt();
			int n = input.nextInt();
			if (n % 3 == 0)
				System.out.println(a);
			else
				System.out.println(n % 3 == 1 ? b : a ^ b);
		}
		input.close();
	}
}

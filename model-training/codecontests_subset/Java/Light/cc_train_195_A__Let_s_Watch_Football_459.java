import java.util.Scanner;

public class d2_123_a {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int ans = (a * c + b - 1) / b - c;
		System.out.println(Integer.toString(ans));
	}
}

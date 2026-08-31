import java.util.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if((a - b) * c % b == 0) {
			System.out.println((a - b) * c / b);
		} else {
			System.out.println((a - b) * c / b + 1);
		}
	}
}

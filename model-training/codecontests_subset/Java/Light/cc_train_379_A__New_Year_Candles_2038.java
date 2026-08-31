import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int a = reader.nextInt();
		int b = reader.nextInt();
		long cnt = a;
		while(a >= b) {
			cnt += a / b;
			a = a / b + a % b;
		}
		System.out.println(cnt);
	}
	
}
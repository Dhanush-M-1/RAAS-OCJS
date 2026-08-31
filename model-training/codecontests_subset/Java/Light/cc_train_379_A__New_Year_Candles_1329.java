import java.util.Arrays;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int i = 0;
		int sum = a;
		int usedCandles = a;
		while(usedCandles >= b) {
			sum += usedCandles / b;
			usedCandles = (usedCandles / b) + (usedCandles % b);
		}
		System.out.println(sum);
		s.close();

	}
}
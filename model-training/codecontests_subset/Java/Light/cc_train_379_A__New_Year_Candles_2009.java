
import java.util.Scanner;

public class A {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		
		if (b > a) {System.out.println(a);return;}
		
		int currentNumCandles = a;
		int candleTotal = a;
		while (currentNumCandles >= b) {
			candleTotal += currentNumCandles/b;
			currentNumCandles = (currentNumCandles/b) + currentNumCandles%b;

		}
		System.out.println(candleTotal);
		
	}
	
}

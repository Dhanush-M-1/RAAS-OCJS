import java.util.*;

public class Example {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt(), b = input.nextInt();
		int wax = a, n;
		while(wax >= b) {
			n = (int)Math.floor((double)wax / b);
			a += n;
			wax = wax % b + n;
		}
		System.out.println(a);
	}
}
import java.util.*;
public class java9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		long pow = (long) Math.pow(5, n);
		String s = pow + "";
		if (n > 100000) {
			System.out.println("25");
		}
		else {
		System.out.println(s.substring(s.length() - 2, s.length()));
		}
	}
}

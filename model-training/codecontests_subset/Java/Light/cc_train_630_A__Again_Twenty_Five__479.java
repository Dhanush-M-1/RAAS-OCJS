import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BigInteger n = input.nextBigInteger();
		BigInteger m = new BigInteger("5");
		BigInteger s = new BigInteger("100");
		System.out.println(m.modPow(n, s));
	}
}
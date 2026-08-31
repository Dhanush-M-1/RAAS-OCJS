import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		BigInteger base = cin.nextBigInteger();
		for(BigInteger i = BigInteger.ONE;i.compareTo(base) < 0;i = i.add(BigInteger.ONE)) {
			for(BigInteger j = BigInteger.ONE;j.compareTo(base) < 0;j = j.add(BigInteger.ONE)) {
				int max_len = j.multiply(base.add(BigInteger.valueOf(-1))).toString(base.intValue()).length();
				int now_len = i.multiply(j).toString(base.intValue()).length();
				if(j.compareTo(BigInteger.ONE) != 0) {
					System.out.print(" ");
				}
				for(int k = 0;k < max_len - now_len;k++) {
					System.out.print(" ");
				}
				System.out.print(i.multiply(j).toString(base.intValue()));
			}
			System.out.print("\n");
		}
	}
}

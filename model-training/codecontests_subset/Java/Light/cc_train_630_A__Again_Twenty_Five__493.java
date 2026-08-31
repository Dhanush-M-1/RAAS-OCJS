import java.math.BigInteger;
import java.util.Scanner;

public class Problem630A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = new BigInteger(in.next());
        BigInteger five = BigInteger.valueOf(5);
        BigInteger fiveTo = five.modPow(n, BigInteger.valueOf(100));
        System.out.println(fiveTo);
    }
}

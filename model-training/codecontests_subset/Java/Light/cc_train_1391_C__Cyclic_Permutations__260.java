import java.math.BigInteger;
import java.util.Scanner;

public class CyclicPermutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        BigInteger const2 = BigInteger.valueOf(1000000007);
        BigInteger a2 = BigInteger.valueOf(2).pow((int)n - 1).mod(const2);

        BigInteger result = BigInteger.valueOf(n);
        for (long i = n - 1; i > 1; i--) {
            result = result.multiply(BigInteger.valueOf(i)).mod(const2);
        }

        BigInteger output = result.subtract(a2);

        if (output.compareTo(BigInteger.ZERO) < 0) {
            System.out.println(output.add(const2));
        }else{
            System.out.println(output);
        }

    }
}

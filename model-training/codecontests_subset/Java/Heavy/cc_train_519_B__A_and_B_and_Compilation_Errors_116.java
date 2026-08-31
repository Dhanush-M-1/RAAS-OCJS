
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Ignazio Castrogiovanni on 2019-04-22.
 */
public class HRGraph {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

      BigInteger bigInt = BigInteger.ZERO;

      for (int i = 0; i < n; i++) {
        int currentValue = scanner.nextInt();
        bigInt = bigInt.add(BigInteger.valueOf(currentValue));
      }

      BigInteger secondValue = BigInteger.ZERO;
      for (int i = 0; i < n - 1; i++) {
        int currentValue = scanner.nextInt();
        secondValue = secondValue.add(BigInteger.valueOf(currentValue));

        bigInt = bigInt.subtract(BigInteger.valueOf(currentValue));
      }

      System.out.println(bigInt);

      for (int i = 0; i < n - 2; i++) {
        int currentValue = scanner.nextInt();

        secondValue = secondValue.subtract(BigInteger.valueOf(currentValue));
      }

      System.out.println(secondValue);
    }
  }

import java.math.BigInteger;
import java.util.*;

public class Main {
    static int primeCounter = 0;

    public static void main(String args[]) {
        // input

        int numEl;

        Scanner inp = new Scanner(System.in);

        numEl = inp.nextInt();

        for (int i = 0; i < numEl; i++) {
            BigInteger input = new BigInteger(inp.next());

            if (input.isProbablePrime(5)) {
                primeCounter++;
            }
        }

        System.out.println(primeCounter);
    }
}

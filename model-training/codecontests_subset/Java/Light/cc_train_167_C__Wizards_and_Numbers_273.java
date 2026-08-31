import java.math.*;
import java.util.*;

public class Main {
    boolean func(BigInteger a, BigInteger b) {
        BigInteger A = a.min(b);
        BigInteger B = a.max(b);
        if (A.equals(BigInteger.ZERO)) return false;
        if (!func(B.mod(A), A)) return true;
        return B.divide(A).mod(A.add(BigInteger.ONE)).and(BigInteger.ONE).equals(BigInteger.ZERO);
    }
    public void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; ++ i) {
            BigInteger a = new BigInteger(in.next());
            BigInteger b = new BigInteger(in.next());
            System.out.println(func(a, b) ? "First" : "Second");
        }
    }
    public static void main(String[] args) {
        new Main().run();
    }
}

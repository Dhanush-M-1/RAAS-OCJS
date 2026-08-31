import java.util.*;
import java.math.*;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long X = scanner.nextLong();
        int N = (int)1e6;
        ArrayList<Long> primes = new ArrayList<>();
        for(long i = 2; i <= (long)Math.ceil(Math.sqrt(X)); i++) {
            if(X % i == 0) {
                long cur = 1;
                while(X % i == 0) {
                    X /= i;
                    cur *= i;
                }
                primes.add(cur);
            }
        }
        if(X > 1) primes.add(X);
        long ansA = Long.MAX_VALUE;
        long ansB = Long.MAX_VALUE;
        for(int i = 0; i < (1 << primes.size()); i++) {
            long a = 1;
            long b = 1;
            for(int k = 0; k < primes.size(); k++) {
                if(((i >> k) & 1) == 1) a *= primes.get(k);
                else b *= primes.get(k);
            }
            if(Math.max(a, b) < Math.max(ansA, ansB)) {
                ansA = a;
                ansB = b;
            }
        }
        System.out.println(ansA + " " + ansB);
    }
}
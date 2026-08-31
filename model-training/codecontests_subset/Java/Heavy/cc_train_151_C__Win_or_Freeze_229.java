import java.util.Scanner;

public class C {
    static long[] primes = new long[3200000];
    static int cnt;

    public static void sieve() {
        cnt = 0;
        primes[cnt++] = 2;
        int sqrt = (int) (Math.sqrt(3200000) + 1);
        int[] marks = new int[50000];
        for (int i = 3; i <= sqrt; i += 2) {
            if ((marks[i >> 6] & (1 << ((i >> 1) & 31))) == 0) {
                for (int j = i * i; j <= 3200000; j += (i << 1)) {
                    marks[j >> 6] |= (1 << ((j >> 1) & 31));
                }
            }
        }
        for (int i = 3; i <= 3200000; i += 2) {
            if ((marks[i >> 6] & (1 << ((i >> 1) & 31))) == 0) {
                primes[cnt++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), tmp = n;
        if (n == 2) {
            System.out.println(1);
            System.out.println(0);
            return;
        }
        sieve();
        long sqrt = (long) Math.sqrt(n) + 1;
        long res = 1;
        int factors = 0;
        for (int i = 0; i < cnt && primes[i] <= sqrt; i++) {
            if (n % primes[i] == 0) {
                int count = 0;
                while (n % primes[i] == 0) {
                    n /= primes[i];
                    count++;
                }
                if (count > 1) {
                    if (primes[i]*primes[i]<tmp) {
                        System.out.println(1);
                        System.out.println(primes[i] * primes[i]);
                        return;
                    } else {
                        System.out.println(2);
                        return;
                    }
                }
                if (factors < 2) {
                    res *= primes[i];
                }
                factors++;
            }
        }
        if (n == tmp) {
            System.out.println(1);
            System.out.println(0);
        } else {
            if (n > 1)
                factors++;
            if (factors > 2) {
                System.out.println(1);
                System.out.println(res);
            } else
                System.out.println(2);
        }
    }
}

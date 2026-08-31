import java.util.Scanner;

public class CF_107_C {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        if (n == 1 || isPrime(n)){
            System.out.println(1);
            System.out.println(0);
            System.exit(0);
        }

        for (int i = 2; i * i <= n; ++i){
            if (n % i == 0){
                long k = n / i;
                if (isPrime(k)){
                    System.out.println(2);
                    System.exit(0);
                } else {
                    for (int j = 2; j*j <= k; ++j)
                        if (k % j == 0) {
                            System.out.println(1);
                            System.out.println(j * i);
                            System.exit(0);
                        }
                }
            }
        }
        
            System.out.println(2);
    }

    static boolean isPrime(long k) {
        if (k == 2 || k == 3) return true;
        for (long i = 2; i * i <= k; ++i){
            if (k % i == 0) return false;
        }
        return true;
    }
    
}
 
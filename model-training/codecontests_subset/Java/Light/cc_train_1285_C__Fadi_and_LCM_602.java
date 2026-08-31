import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long a = n, b = 1;
        for (long i = 2; i * i <= n; i++) {
            if (n%i==0 && gcd(i, n / i) == (long) 1) {
                a = n / i;
                b = i;
            }
        }
        System.out.println(b+" "+a);
    }
 
    private static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
import java.util.Scanner;

public class Main {

    static long gcd(long a,long b){
        return b == 0 ? a : gcd(b,a % b);
    }

    static long lcm(long a,long b){
        return a / gcd(a,b) * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        for (int i = (int) Math.round(Math.sqrt(n)); i >= 1; i--) {
            if ((n % i == 0) && lcm(i, n/i) == n) {
                System.out.println(i+" "+n/i);
                break;
            }
        }
    }
}
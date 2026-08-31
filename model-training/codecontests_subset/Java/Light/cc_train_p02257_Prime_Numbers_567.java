import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int primeCount = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (isPrime(num)) {
                primeCount++;
            }
        }
        System.out.println(primeCount);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

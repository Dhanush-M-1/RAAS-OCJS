import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrimeNumber(sc.nextInt())) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPrimeNumber(int num) {
        double max = Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

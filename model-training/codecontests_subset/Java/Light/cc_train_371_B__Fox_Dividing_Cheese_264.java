
import java.util.Scanner;

public class main {
    static int a, b;
    static int ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();

        findPowers(2);
        findPowers(3);
        findPowers(5);
        System.out.println((a == b? ans : -1));

    }

    static void findPowers(int base) {
        int counterA = 0;
        int counterB = 0;

        while (a % base == 0) {
            a /= base;
            counterA++;
        }

        while (b % base == 0) {
            b /= base;
            counterB++;
        }

        ans += Math.abs(counterA - counterB);
    }
    
    
}


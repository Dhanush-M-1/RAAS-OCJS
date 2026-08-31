import java.util.Scanner;

public class FoxDividingCheese {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int gcd = GCD(a, b);
        int aStep = primeFactorizationSteps(a / gcd);
        int bStep = primeFactorizationSteps(b / gcd);
        if (aStep != -1 && bStep != -1) {
            System.out.println(aStep + bStep);
        } else {
            System.out.println(-1);
        }
    }

    public static int GCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    public static int primeFactorizationSteps(int a) {
        int steps = 0;
        while (a % 2 == 0) {
            steps++;
            a = a / 2;
        }

        while(a % 3 == 0) {
            steps++;
            a = a / 3;
        }

        while(a % 5 == 0) {
            steps++;
            a = a / 5;
        }
        if (a != 1) {
            return -1;
        } else {
            return steps;
        }
    }
}

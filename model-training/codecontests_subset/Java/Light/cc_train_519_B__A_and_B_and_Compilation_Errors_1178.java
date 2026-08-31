import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();
        }

        long sum2 = 0;
        for (int i = 1; i < n; i++) {
            sum2 += sc.nextInt();
        }
        long sum3 = 0;
        for (int i = 2; i < n; i++) {
            sum3 += sc.nextInt();
        }

        System.out.println(sum - sum2);
        System.out.println(sum2 - sum3);

    }
}

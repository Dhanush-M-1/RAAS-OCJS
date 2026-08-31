


import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        final Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long sum = 0;
        for (int i = 0; i < N; ++i) {
            sum += scanner.nextInt();
        }
        sum -= N;
        System.out.println(sum);
    }
}

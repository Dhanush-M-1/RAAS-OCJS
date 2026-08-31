import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += sc.nextInt();
        }

        sum -= N;
        System.out.println(sum);
        sc.close();

    }
}

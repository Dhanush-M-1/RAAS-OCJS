import java.util.Scanner;

/**
 * Created by Baka on 10.05.2016.
 */
public class AandBandCompilerErrors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long a = 0;
        for (int i = 0; i < n; i++){
            a += scanner.nextLong();
        }

        long b = 0;
        for (int i = 0; i < n-1; i++){
            b += scanner.nextLong();
        }

        long c = 0;
        for (int i = 0; i < n - 2; i++){
            c += scanner.nextLong();
        }

        System.out.println(a-b);
        System.out.println(b-c);

    }
}

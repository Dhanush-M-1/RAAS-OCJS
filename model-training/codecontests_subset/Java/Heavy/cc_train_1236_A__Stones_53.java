import java.util.Arrays;
import java.util.Scanner;

public class gaurav {

    // Driver method
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        int T = ob.nextInt();
        for (int i = 0; i < T; i++) {
            int a = ob.nextInt();
            int b = ob.nextInt();
            int c = ob.nextInt();
            int sum = a + b + c;
            while (c > 1 && b > 0) {
                b = b - 1;
                c = c - 2;
            }

            while (b > 1 && a > 0) {
                a = a - 1;
                b = b - 2;

            }
            sum = sum - a - b - c;
            System.out.println(sum);

        }

    }
}

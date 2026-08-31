import java.util.Scanner;

/**
 * Created by user on 28.12.2016.
 */
public class A379 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int l = n;
        while (true) {
            l += n / k;
            n = n / k + n % k;
            if (n < k) {
                break;
            }
        }
        System.out.println(l);
    }
}

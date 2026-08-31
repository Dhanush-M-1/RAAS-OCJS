
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int max = Math.max(first, second);
        int min = Math.min(first, second);
        int sum = 0, a = 1, b = 1, j = min;
        for (int i = max; i > 0; i--) {
            if (i != j) {
                j++;
                sum = sum + b;
                b++;
            }
            if (i != max) {
                sum = sum + a;
                a++;
            }
            if (i == j) {
                break;
            }
        }
        System.out.println(sum);
    }
}

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ArtemArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int top = 0, x;
        long sum = 0;
        int n = scanner.nextInt();
        long st[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            x = scanner.nextInt();
            while (top > 0 && st[top - 1] >= st[top] && x >= st[top]) {
                sum += Math.min(x, st[top - 1]);
                top--;
            }
            st[++top] = x;
        }

        Arrays.sort(st, 1, 1 + top );
        for (int i = 0; i <= top - 2; i++) {
            sum += st[i];
        }
        System.out.println(sum);
    }
}

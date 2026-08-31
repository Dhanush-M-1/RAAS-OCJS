
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final char[] n = in.next().toCharArray();
        final int k = in.nextInt();
        if (n.length < k) {
            System.out.println(0);
            return;
        }
        System.out.println(sum(n, k, 0));
    }

    private static int sum(char[] n, int count, int index) {
        if (count == 0) {
            return 1;
        }
        if (index >= n.length) {
            return 0;
        }
        final int number = n[index] - '0';
        if (number == 0) {
            return sum(n, count, index + 1);
        }

        int total = 0;
        if (count > 0 && count != n.length - index) {
            int result = combination(n.length - index - 1, count);
            for (int i = 0; i < count; i++) {
                result *= 9;
            }
            total += result;
        }
        if (number > 1) {
            int result = number - 1;
            result *= combination(n.length - index - 1, count - 1);
            for (int i = 0; i < count - 1; i++) {
                result *= 9;
            }
            total += result;
        }
        total += sum(n, count - 1, index + 1);
        return total;
    }

    private static int combination(int n, int k) {
        int top = 1;
        int bottom = 1;
        for (int i = 1; i <= k; i++) {
            bottom *= i;
            top *= n - i + 1;
        }
        return top / bottom;
    }
}

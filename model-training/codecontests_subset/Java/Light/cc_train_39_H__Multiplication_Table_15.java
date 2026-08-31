
import java.util.Scanner;

public class H {
    public static String toBase(int x, int b) {
        String res = "";
        while (x > 0) {
            res = x % b + res;
            x /= b;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++)
                System.out.print(toBase(i * j, n) + "   ");
            System.out.println();
        }
    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class b_294 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long sum_a = 0, sum_b = 0, sum_c = 0;
        for (int i = 0; i < n; i++)
            sum_a += in.nextLong();
        for (int i = 0; i < n - 1; i++)
            sum_b += in.nextLong();
        for (int i = 0; i < n - 2; i++)
            sum_c += in.nextLong();
        System.out.println(sum_a - sum_b);
        System.out.println(sum_b - sum_c);
    }

}

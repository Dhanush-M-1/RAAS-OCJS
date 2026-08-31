
import java.util.*;

public class CODE {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = n;
        sum += n / m;
        n = n / m + n % m;

        while (n >= m) {
            sum += n / m;
            n = n / m + n % m;
        }
        System.out.println(sum);
    }
}


import java.util.Scanner;

/**
 * Created by shoya on 2017/04/14.
 */
public class Main {
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += (isPrime(sc.nextInt())) ? 1 : 0;
        System.out.println(ans);
        return;
    }

    public static boolean isPrime(int n){
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0)
                return false;
            i++;
        }
        return true;
    }
}
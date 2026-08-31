import java.util.Random;
import java.util.Scanner;

/**
 * Created by vishakha on 17-07-2016.
 */
public class Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int candles = sc.nextInt();
        int b = sc.nextInt();
        int sum = candles;
        int wentOut = candles;
        while (candles != 0) {
            candles = wentOut/b;
            wentOut = wentOut%b + wentOut/b;
            sum += candles;
        }
        System.out.println(sum);
    }
}

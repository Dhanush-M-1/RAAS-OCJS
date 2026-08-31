import java.util.*;
import java.lang.Math;
public class NewYearCandles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int sum = 0;
        int candles = n;
        int burnt = 0;
        while (candles > 0) {
            sum += candles;
            burnt += candles;
            candles = burnt/k;
            burnt = burnt - k*candles;
        }
        System.out.println(sum);
    }
}
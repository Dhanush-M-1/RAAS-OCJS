import java.util.Scanner;
public class MyClass {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int candles = scan.nextInt(), reuse = scan.nextInt(), total = candles;
        int res = 0;
        while(candles/reuse > 0) {
            res += candles/reuse;
            candles = (candles/reuse)+(candles%reuse);
        }
        System.out.println(total + res);
    }
}

import java.util.Scanner;

public class New_Year_Candles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b;
        a = in.nextInt();
        b = in.nextInt();
        int rest = 0;
        int count = 0;
        while (a > 0) {
            count += a;
            rest += a % b;
            a = a / b;
            if (rest >= b) {
                a += 1;
                rest -= b;
            }
        }
        System.out.println(count);
    }
}

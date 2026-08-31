import java.util.Scanner;

public class NewYearCandles {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int sum = 0;
        int c = a;
        int d = 0;
        while (c > 0) {
            sum += c;
            d += c;
            c = d/b;
            d = d%b;
        }
        System.out.println(sum);
    }

}

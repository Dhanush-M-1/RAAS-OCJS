import java.util.Scanner;

public class Candles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");
        int a = Integer.valueOf(inp[0]);
        int b = Integer.valueOf(inp[1]);

        int total = a;

        if (a >= b) {
            int min = Math.min(a, b);

            while (a >= min) {
                total += a/b;
                a = (a / b) + (a % b);
            }
        } 

        System.out.println(total);
    }

}

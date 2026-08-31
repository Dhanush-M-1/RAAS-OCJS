import java.util.*;

public class Candels {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a / b + a % b;

        int d = 0;
        for (int i = 1; i < a; i++) {
            int f = c % b;
            c = c / b;
            d = d + c;
            if (c +f< b ) {
                break;
            }
            c = f + c;
        }
        System.out.println(a + d + a / b);

    }

}

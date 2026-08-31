import java.util.Scanner;

/**
 * Created by Michael on 9/10/14.
 */
public class B_218 {
    public static void main(String...bob) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int gcd = gcd(a, b);
        if(a == b){
            System.out.println(0);
        }
        else {
            int[] divide = {2, 3, 5};
            a /= gcd;
            b /= gcd;
            int count = 0;
            for (int i = 2; i >= 0; i--) {
                while (a % divide[i] == 0) {
                    count++;
                    a /= divide[i];
                }
                while (b % divide[i] == 0) {
                    count++;
                    b /= divide[i];
                }
            }
            if(a == b)
                System.out.println(count);
            else
                System.out.println(-1);
        }

    }
    public static int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b % a, a);
    }
}

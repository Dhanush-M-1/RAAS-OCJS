
import java.util.Scanner;

public class Stones {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            
                long res = Math.min(b, c / 2);
                b -= res;
                res += Math.min(a, b / 2);
                System.out.println(res * 3);
            
        }
    }

}

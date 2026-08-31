
import java.util.Scanner;

public class MinimumInteger {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            if (c < a) {
                System.out.println(c);
            } else {
                int k = b / c;
                if(k*c<=b){
                    ++k;
                }
                System.out.println(c*k);
            }
        }
    }

}

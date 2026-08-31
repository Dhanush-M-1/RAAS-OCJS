import java.util.Scanner;

public class Solution {


    public static void main(String ...args) {

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int c = a ^ b;

            int d = 0;
            if (n % 3 == 0) {
                d = a;        
            } else if (n % 3 == 1) {
                d = b;
            } else {
                d = c;
            }

            System.out.println(d);
        }

        in.close();

    }

}
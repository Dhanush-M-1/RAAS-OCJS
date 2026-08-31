
import java.util.*;

public class A_Garden {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt(), rem = 0, min = Integer.MAX_VALUE, ans = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            rem = k % a[i];
           // System.out.println("rem = " + rem);
            if (rem == 0) {
                ans = k / a[i];
               // System.out.println("ans = " + ans);
                if (ans < min) {
                    min = ans;
                }
            }
        }
        System.out.println(min);

    }

}

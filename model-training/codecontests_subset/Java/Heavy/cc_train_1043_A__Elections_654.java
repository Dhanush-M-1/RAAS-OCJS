import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];


        int max = Integer.MIN_VALUE;
        int opponent = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            max = Math.max(max, a[i]);
            opponent += a[i];
        }

        for (int i = max; ; i++) {
            if (i * n - opponent > opponent) {
                System.out.println(i);

                break;
            }
        }
    }


}

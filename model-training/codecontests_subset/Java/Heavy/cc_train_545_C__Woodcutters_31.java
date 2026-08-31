import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Askar on 12.06.2017.
 */

public class task1 {
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long [][] mas = new long[n][2];

        for (int i = 0; i < n; i++) {
            mas[i][0] = in.nextLong();
            mas[i][1] = in.nextLong();
        }
        int c;
        if (n==1)c=1;
        else c=2;

        for (int i = 1; i < n-1; i++) {
            long q1, q2;
            q1 = mas[i][0]-mas[i][1];
            q2 = mas[i][0] + mas[i][1];

            if (q1>0 && q1>mas[i-1][0]){

                c++;
                mas[i][1] = mas[i][0] - mas[i][1];
            }
            else if (q2<mas[i+1][0]){

                c++;
                mas[i][0] = mas[i][0] + mas[i][1];
            }
        }



        System.out.println(c);


    }
}
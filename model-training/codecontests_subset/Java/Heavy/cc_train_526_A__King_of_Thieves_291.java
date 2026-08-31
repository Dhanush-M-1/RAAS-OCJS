
import java.util.Scanner;

/**
 * Created by alya on 4/4/15.
 */
public class A {

    private static int N;
    private static String LINE;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        // считывание данных
        N = in.nextInt();

        //int[] lens = new int[N];

        LINE = in.next();

        /*for (int r = 0; r < N; r++) {
            //System.out.println(r);
            lens[r] = in.nextInt();
        }
        */


        boolean b = false;
        int cur_count = 0;
        int maxStep = (N - 1)/4;
        for (int i = 1; i <= maxStep; i++)
        {
            if (b) break;
            for (int s = 0; s < maxStep; s++) {
                cur_count = 0;
                for (int j = s; j < N; j += i) {
                    //System.out.println(i + "," + j + " ");

                    if (LINE.charAt(j) == '*') {
                        cur_count++;
                        //System.out.println("+");
                    } else {
                        cur_count = 0;
                        //System.out.println("-");
                    }

                    if (cur_count == 5) {
                        b = true;
                        break;
                    }
                }
            }
        }










        if (b)
            System.out.println("yes");
        else
            System.out.println("no");

    }

    private static void findSolution()
    {

    }

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main1 {

    static int[] selected = new int[4];
    static boolean[] taken = new boolean[10];
    static boolean flag = false;
    static int r1, r2, d2, d1, c1, c2;

    public static void combination(int index) {
        if (index == 4) {

            if (selected[0] + selected[1] == r1
                    && selected[2] + selected[3] == r2
                    && selected[0] + selected[3] == d1
                    && selected[1] + selected[2] == d2
                    && selected[0] + selected[2] == c1
                    && selected[1] + selected[3] == c2) {
                // System.out.println(selected[0]+" "+selected[1]+" "+selected[2]+" "+selected[3]);

                flag = true;
            }
            return;

        }

        for (int i = 1; i <= 9; i++) {
            if (!taken[i]) {
                if (flag)
                    return;
                selected[index] = i;
                taken[i] = true;

                combination(index + 1);
                if (flag)
                    return;
                taken[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        r1 = in.nextInt();
        r2 = in.nextInt();
        c1 = in.nextInt();
        c2 = in.nextInt();
        d1 = in.nextInt();
        d2 = in.nextInt();

        combination(0);

        if (flag) {
            System.out.println(selected[0] + " " + selected[1]);
            System.out.println(selected[2] + " " + selected[3]);
        } else {
            System.out.println("-1");
        }
    }

}

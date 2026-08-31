import java.util.Arrays;
import java.util.Scanner;

public class Partition {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), c = 0;
        int[] a = new int[2];
        a[0] = 1;
        a[1] = 2;
        int[] a1 = new int[3];
        a1[0] = 1;
        a1[1] = 2;
        a1[2] = 3;
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            for (int j = 0; j < 3; j++) {
                if (a[0] != a1[j] && a[1] != a1[j]) {

                    if (a[0] != x && a1[j] != x) {
                        a[0] = a1[j];
                        c++;
                        break;
                    } else if (a[1] != x && a1[j] != x) {
                        a[1] = a1[j];
                        c++;
                        break;
                    }

                }
            }
        }
        //System.out.println(c);
        if (c == n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

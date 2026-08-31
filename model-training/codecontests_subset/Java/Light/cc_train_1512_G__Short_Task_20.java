
import java.util.Scanner;

public class ShortTask {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int[] a = new int[10000010];
        for (int i = 1; i < 10000010; i++) {
            for (int j = i; j < 10000010; j += i) {
                a[j] += i;
            }
        }
        int[] res = new int[10000010];
        for (int i = 0; i < 10000010; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < 10000010; i++) {
            if (a[i] <= 10000000 && res[a[i]] == -1) {
                res[a[i]] = i;
            }
        }
        int t = scan.nextInt();
        while (t-- > 0) {
            int c = scan.nextInt();
            System.out.println(res[c]);
        }
    }

}

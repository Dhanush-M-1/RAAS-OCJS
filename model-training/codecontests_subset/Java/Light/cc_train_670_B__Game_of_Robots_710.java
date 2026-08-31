import java.util.Scanner;

public class GameofRobots {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int i = 0;
        long s = 0;
        for (i = 0; s + i < k; i++) {
            s += i;
        }
        int p = k - (int) s;
        System.out.println(a[p - 1]);

    }

}

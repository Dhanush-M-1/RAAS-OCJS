import java.util.*;

public class CodeForce {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] a = new int[100];
        int gcd = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            if (k % a[i] == 0) {
                gcd = a[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (k % a[i] == 0) {
                if (a[i] > gcd) {
                    gcd = a[i];
                }
            }
        }
        System.out.println(k/gcd);
    }

}
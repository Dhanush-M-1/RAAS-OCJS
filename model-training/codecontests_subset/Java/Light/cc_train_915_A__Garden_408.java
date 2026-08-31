import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n, k, min, bk = 0;
        int[] a, b;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        a = new int[1000];
        b = new int[1000];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (k % a[i] == 0) {
                b[++bk] = k / a[i];
            }
        }
        min = b[1];
        for (int i = 1; i <= bk; i++) {
            if (b[i] < min) {
                min = b[i];
            }
        }
        System.out.print(min);
    }
}

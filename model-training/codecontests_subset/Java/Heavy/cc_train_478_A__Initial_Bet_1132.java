import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int result = solve();
        System.out.println(result);
    }

    public static int solve() {
        Scanner scan = new Scanner(System.in);
        int[] a = new int[5];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = scan.nextInt();
            sum += a[i];
        }
        if (sum % 5 != 0) return -1;
        int b = sum / 5;
        if (b == 0) return -1;
        int[] r = new int[5];
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            r[i] = a[i] - b;
            res += r[i];
        }
        if (res == 0) return b; else return -1;
    }
}
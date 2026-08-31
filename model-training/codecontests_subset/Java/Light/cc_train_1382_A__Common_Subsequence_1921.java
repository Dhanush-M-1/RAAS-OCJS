import java.util.Scanner;

public class Div2658A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            int[] b = new int[m];
            for (int j = 0; j < m; j++) {
                b[j] = scanner.nextInt();
            }
            solve(a, b);
        }
    }

    private static void solve(int[] a, int[] b) {
        int[] valuesA = new int[1000];
        for (int i = 0; i < a.length; i++) {
            valuesA[a[i] - 1]++;
        }
        for (int i = 0; i < b.length; i++) {
            if (valuesA[b[i] - 1] != 0) {
                System.out.println("YES");
                System.out.println("1 " + b[i]);
                return;
            }
        }
        System.out.println("NO");
    }
}

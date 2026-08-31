import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    public static int[] solve(int n, int[] p) {
        int[] empty = new int[] { 0, 0, 0 };
        if (n < 6) {
            return empty;
        }
        int i = 0;
        int g = 0;
        int s = 0;
        int b = 0;
        int middle = n / 2;
 
        while (middle > 0 && p[middle] == p[middle- 1]) {
            middle--;
        }
 
        while (g < n && p[g] == p[0]) {
            g++;
        }
 
        if (g * 3 > middle - 2) { // !
            return empty;
        }

        s = g + 1;
        while (p[g + s] == p[g + s - 1] && g + s < n) {
            s++;
        }


        b = middle - s - g;
 
 
        if (g == 0 || s == 0 || b == 0 || b <= g) return empty;
 
        return new int[] { g, s, b };
    }

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scanner.nextInt();
 
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
 
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
 
            int[] r = solve(n, a);
 
            System.out.println(r[0] + " " + r[1] + " " + r[2]);
        }
 
    }
}
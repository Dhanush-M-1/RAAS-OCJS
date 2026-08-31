import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int l = 0, r = 10000000;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (m * 100 >= n * y) {
                r = m;
            }
            else {
                l = m;
            }
        }
        System.out.println(Math.max(0, r - x));
        scanner.close();
    }
}

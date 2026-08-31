import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        int[][] counter = new int[26][n + 1];

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int l = 1; l <= n - i; l++) {
                    char j = s.charAt(i + l - 1);
                    if (j != c) {
                        count++;
                    }
                    counter[c - 'a'][count] = Math.max(counter[c - 'a'][count], l);
                }
            }
            for (int i = 1; i <= n; i++) {
                counter[c - 'a'][i] = Math.max(counter[c - 'a'][i - 1], counter[c - 'a'][i]);
            }
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int t = scanner.nextInt();
            String str = scanner.next();
            System.out.println(counter[str.charAt(0) - 'a'][t]);
        }
    }
}
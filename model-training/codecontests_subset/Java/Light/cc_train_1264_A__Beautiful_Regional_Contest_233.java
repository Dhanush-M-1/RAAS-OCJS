import java.util.*;

public class Solution {
    private static final long modula = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int t = scanner.nextInt();
        int[] mass = new int[400_002];
        for (int z = 0; z < t; z++) {
            int n = scanner.nextInt();
            for (int i = 0 ; i < n / 2 ; ++i) mass[i] = scanner.nextInt();
            for (int i = n / 2 ; i < n ; ++i) mass[i] = scanner.nextInt();
            int k = n / 2;
            int g = 0;
            int s = 0;
            int b = 0;
            int i = 0 ;
            int first = mass[0];
            int last = mass[k];
            while (i < k && mass[i] == first) {
                g++;
                i++;
            }
            while (i < k && s <= g) {
                first = mass[i];
                s++;
                i++;
            }
            while (i < k && mass[i] == first) {
                s++;
                ++i;
            }
            while (i < k && mass[i] != last) {
                b++;
                ++i;
            }
            if (s == 0 || b == 0 || g == 0 || g >= b || g >= s ) {
                s = b = g = 0;
            }
            stringBuilder.append(g).append(' ').append(s).append(' ').append(b).append('\n');

        }
        System.out.println(stringBuilder);

    }



}
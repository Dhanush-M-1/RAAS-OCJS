import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TheBestGift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        Integer[] genres = new Integer[m];
        for (int i = 0; i < n; ++i) {
            int num = sc.nextInt() - 1;
            if (genres[num] == null) {
                genres[num] = new Integer(0);
            }
            genres[num]++;
        }

        Arrays.sort(genres, Collections.reverseOrder());
        int[] prefix = new int[m];

        for (int i = m - 1; i >= 0; --i) {
            prefix[i] = (i == m - 1)? genres[i]: genres[i] + prefix[i + 1];
        }

        int combinations = 0;
        for (int i = 0; i < m - 1; ++i) {
            combinations += (genres[i] * prefix[i + 1]);
        }

        System.out.println(combinations);
    }

}

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by frillyfrufru on 29/04/16.
 *
 * @codeforces.title k-String
 * @codeforces.id A219
 * @codeforces.url http://codeforces.com/problemset/problem/219/A
 * @codeforces.keywords string, histogram
 *
 *
 */
 
public final class A219 {
    /** Do not instantiate. */
    private A219() { }

    public static void main(final String[] notUsed) {
        Scanner sin = new Scanner(System.in);
        int[] freq = new int[128]; // 7bit ascii: 0 - 127

        int k = sin.nextInt();
        String s = sin.next();

        for (int i = 0; i < s.length(); i++) {
            ++freq[s.charAt(i)];
        }

        for (char i = 'a'; i <= 'z'; i++) {
            if (freq[i] % k != 0) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            if (freq[i] != 0) {
                char[] cs = new char[freq[i] / k];
                Arrays.fill(cs, i);
                sb.append(cs);
            }
        }
        while (k-- > 0) {
            System.out.print(sb);
        }
        System.out.println();
        sin.close();
    }
}

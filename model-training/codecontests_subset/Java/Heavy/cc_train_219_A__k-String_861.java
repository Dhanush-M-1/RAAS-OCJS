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
 * A string is a k-string if it can be represented as k concatenated
 * copies of some string. "aabaabaabaab" is a 1-string, 2-string, and
 * a 4-string, but it is not a 3-string, 5-string, or 6-string (etc.)
 * Obviously any string is a 1-string.
 *
 * Given a string s of lowercase english letters and a positive integer
 * k, reorder the letters in s in such a way that the resulting string
 * is a k-string.
 *
 * Input:
 * The first line of iput contains integer 1 <= k <= 100. The second
 * line contains s, where 1 <= |s| <= 1000.
 *
 * Output:
 * Rearrange the letters in s in such a way that the result is a k-string.
 * Print the result on a single output line. If there are multiple
 * solutions, print any one of them. If the solution doesn't exist,
 * print -1.
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

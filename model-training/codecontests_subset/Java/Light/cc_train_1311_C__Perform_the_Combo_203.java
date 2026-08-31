import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Acesine on 2/24/20.
 */
public class C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt(), m = s.nextInt();
            String str = s.next();
            int[] p = new int[m];
            for (int i=0;i<m;i++) p[i] = s.nextInt() - 1;
            Arrays.sort(p);
            int[] cnt = new int[n];
            for (int pos : p) {
                cnt[pos]++;
            }
            for (int i=n-2;i>=0;i--) cnt[i] += cnt[i+1];
            int[] w = new int[26];
            for (int i=0;i<n;i++) {
                w[str.charAt(i)-'a'] += cnt[i] + 1;
            }
            for (int i=0;i<26;i++) System.out.print(w[i]+" ");
            System.out.println();
        }
    }
}

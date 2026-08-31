import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class codechef {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        int t = 0;
//        if (sc.hasNext())
//            t = sc.nextInt();
//        for (int i = 1; i <= t; i++) {
        solve();
//        }
    }

    public static void solve() {
        int k = sc.nextInt();
        char[] c = sc.next().toCharArray();
        int[] freq = new int[26];
        for (char value : c) {
            freq[value - 'a']++;
        }
//        System.out.println(Arrays.toString(freq));
        boolean check = true;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % k != 0) {
                check = false;
                break;
            }
        }
        if (check) {
            String str = "";
            for (int i = 0; i < 26; i++) {
                int n = freq[i] / k;
                for (int j = 0; j < n; j++) {
                    str += (char) (i + 'a');
                }
            }
            for (int i = 0; i < k; i++) {
                System.out.print(str);
            }
            System.out.println();
        } else
            System.out.println(-1);
    }
}
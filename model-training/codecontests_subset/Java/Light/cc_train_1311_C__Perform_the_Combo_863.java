import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            int[] p = new int[m];
            for (int i1 = 0; i1 < p.length; i1++) {
                p[i1] = sc.nextInt();
            }
            Arrays.sort(p);
            int[] answer = new int[26];
            for (Character ch : s.toCharArray()) {
                answer[ch - 'a']++;
            }
            for (int j = 0; j < n; j++) {
                int l = 0, r = m - 1;
                int ans = -1;
                while(l <= r) {
                    int m1 = (l + r) / 2;
                    if (p[m1] <= j) {
                        l = m1 + 1;
                    } else {
                        r = m1 - 1;
                        ans = m1;
                    }
                }
                int cnt = m - ans;
                if (ans == -1) {
                    cnt = 0;
                }
                answer[s.charAt(j) - 'a'] += cnt;
            }
            for (int value : answer) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

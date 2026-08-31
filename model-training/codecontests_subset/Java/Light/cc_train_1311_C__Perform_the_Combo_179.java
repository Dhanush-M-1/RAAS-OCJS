import java.util.Scanner;

public class Main {

    public static int[] abc;

    public static String toStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(abc[i]).append(" ");
        }
        return sb.toString();
    }


    public static void solve(int p[], String s) {
        int n = s.length();
        abc = new int[26];
        int[] cnt = new int[n];
        for (int i = 0; i < p.length; i++) {
            ++cnt[p[i]];
        }
        for (int i = n - 1; i > 0; --i) {
            cnt[i - 1] += cnt[i];
        }
        for (int i = 0; i < n; ++i) {
            abc[s.charAt(i) - 'a'] += cnt[i] + 1;
        }
        System.out.println(toStr());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            int[] p = new int[m];
            for (int j = 0; j < m; j++) {
                p[j] = sc.nextInt()-1;
            }
            solve(p, s);
        }
    }
}

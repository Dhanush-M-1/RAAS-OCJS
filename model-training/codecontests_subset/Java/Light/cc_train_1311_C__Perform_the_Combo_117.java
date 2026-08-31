import java.util.*;
public class Problem1311c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int[] x = new int[26];
            int j = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (j < m && i + 1 <= a[j]) {
                    x[c - 'a'] += (m + 1 - j);
                } else {
                    while (j < m && i + 1 > a[j]) {
                        j++;
                    }
                    x[c-'a'] += m + 1 - j;
                }
            }
            for (int i = 0; i < 26; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println();
        }
    }
}
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            int[] count = new int[n];
            for (int i = 0; i < m; i++) {
                count[sc.nextInt() - 1]++;
            }
            for (int i = n - 1; i > 0; i--) {
                count[i - 1] += count[i];
            }
            int[] ans = new int[26];
            for (int i = 0 ; i < n; i++) {
                char c = s.charAt(i);
                ans[c - 'a'] += count[i] + 1;
            }
            for (int k : ans) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    private static void solve(int[] a, Set<Integer> p) {

    }

}

/**
 *
 *  1,2,3
 **/
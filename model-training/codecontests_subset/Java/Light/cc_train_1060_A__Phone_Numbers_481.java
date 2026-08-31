

import java.util.Scanner;

public class Prob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '8') cnt++;
        }

        int res = 0;
        for (int i = 1; i <= cnt; i++) {
            if ((n - i) / 10 >= i) res = i;
        }
        System.out.println(res);
    }
}

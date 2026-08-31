import java.util.Scanner;

/**
 * Created by kate on 04/04/15.
 */
public class Z1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String pl = s.next();
        if(n > 4) {
            for (int i = 1; i <= (n-1) / 4; i++) {
                if (check(pl.toCharArray(), i)) {
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println("no");
    }

    private static boolean check(char[] scheme, int k) {
        int start = 0;
        while (true) {
            while (scheme[start] != '*') {
                start++;
                if (start > scheme.length - 4 * k - 1) {
                    return false;
                }
            }
            int count = 0;
            for (int j = start; count < 5; count++, j += k) {
                if (scheme[j] != '*') break;
            }
            if (count == 5) return true;
            start++;
        }
    }
}

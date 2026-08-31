import java.util.*;

public class CowsAndPokerGame {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int i = 0;
        int a = 0;
        String z = cin.next();
        char[] s = z.toCharArray();
        for (int e = n - 1; e > -1; e--) {
            if (s[e] == 'I') {
                ++i;
            }
            if (s[e] == 'A') {
                ++a;
            }
        }
        if (i > 1) {
            System.out.print(0);
            System.exit(0);
        }
        if (i > 0) {
            System.out.print(1);
        } else {
            System.out.print(a);
        }
    }
}
import java.util.*;

public class KingofThieves {

    public static void solve(String s, int n) {
        boolean good = false;
        for(int i = 0; i < n-4; i++) {
            int maxJump = (n - 1 - i) / 4;
            for(int j = 1; j <= maxJump; j++) {
                if(s.charAt(i) == '*' && s.charAt(i+j) == '*'
                    && s.charAt(i+2*j) == '*' && s.charAt(i+3*j) == '*'
                    && s.charAt(i+4*j) == '*') {
                    good = true;
                }
            }
        }
        if(good == true)
            System.out.println("yes");
        else
            System.out.println("no");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();
        solve(s, n);
    }
}
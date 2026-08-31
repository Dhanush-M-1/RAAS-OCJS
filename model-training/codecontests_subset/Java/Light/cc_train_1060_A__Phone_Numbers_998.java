
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), cnt = 0, ans = n / 11;
        String s = in.next();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '8') {
                cnt++;
            }
        }
        System.out.println(Math.min(ans, cnt));
    }
}

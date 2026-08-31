
import java.util.*;

public class JavaApplication3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        String a = in.next();

        int r = x / 11;
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '8') {
                cnt++;
            }
        }
        if (cnt >= r) {
            System.out.println(r);
        } else {
            System.out.println(cnt);
        }
    }
}

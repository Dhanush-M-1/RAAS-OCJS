import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String target = "keyence";

        int index;
        if ((index = s.indexOf(target)) >= 0 && index == 0 || index + target.length() == s.length()) {
            System.out.println("YES");
            return;
        }

        for (int i = 1; i < target.length(); i++) {
            int fi;
            if ((fi = s.indexOf(target.substring(0, i))) != 0) {
                continue;
            }
            if (s.indexOf(target.substring(i), fi + i) > 0
                    && s.endsWith(target.substring(i))) {
                System.out.println("YES");
                return;
            }

        }

        System.out.println("NO");
    }
}


import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;

public class A {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ans = 0, x = 0;
        while (n-- > 0) {
            x = s.nextInt();
            ans = max(ans, min(x - 1, 1000000 - x));
        }
        System.out.println(ans);
    }
}

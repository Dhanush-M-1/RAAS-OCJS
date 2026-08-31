import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String ans = "keyence";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str.contains(ans)) {
            System.out.println("YES");
            return;
        }
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (str.charAt(i) == ans.charAt(i)) {
                count++;
            }
        }
        String left = ans.substring(count);
        String le = str.substring(str.length() - 7 + count);
        if (left.equals(le)) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

}

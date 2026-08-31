
import java.util.*;

public class codeforce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next();
        int count = 0;
        int nuberOfEight = 0;
        boolean flag = false;
        if (a.contains("8")) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '8') {
                    nuberOfEight++;
                }
            }
        } else {
            System.out.println(0);
            flag = true;
        }
        if (!flag) {
            int length = a.length();
            for (int i = 0; i < nuberOfEight && length >= 11; i++) {
                length -= 11;
                count++;
            }
            System.out.println(count);
        }
    }
}

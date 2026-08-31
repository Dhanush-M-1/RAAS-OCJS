
import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        String sub = "";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += chars[i];
        }
        if (sum % k != 0) {
            System.out.println("-1");
            System.exit(0);
        }

        for (int i = 0; i < s.length(); i = i + k) {
            sub += chars[i];
        }
        String res = "";
        for (int i = 0; i < k; i++) {
            res += sub;
        }
        System.out.println(res);
    }
}

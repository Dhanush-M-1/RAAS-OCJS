
import java.util.Scanner;

/**
 *
 * @author izharishaksa
 */
public class C1060A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.nextLine();
        s = sc.nextLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '8') {
                count++;
            }
        }
        int max = -1;
        do {
            int x = s.length() - count;
            max = Math.max(max, Math.min(count, (s.length() - count) / 10));
            count--;
        } while (count > 0);
        System.out.println(max);
    }

}

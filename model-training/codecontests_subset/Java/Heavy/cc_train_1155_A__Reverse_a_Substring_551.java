import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        if (s.length() != n) {
            System.exit(1);
        } else {
            char[] sorter = s.toCharArray();
            Arrays.sort(sorter);
            String s2 = new String(sorter);
            if (s.equals(s2)) {
                System.out.println("NO");
            } else {
                for (int i = 0; i < s.length() - 1; i++) {
                    if (s.charAt(i) > s.charAt(i + 1)) {
                        System.out.println("YES");
                        System.out.println((i + 1) + " " + (int) (i + 2));
                        break;
                    }
                }
            }
        }
    }
}
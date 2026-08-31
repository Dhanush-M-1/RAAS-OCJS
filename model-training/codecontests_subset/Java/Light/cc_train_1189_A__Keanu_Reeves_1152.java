import java.util.HashSet;
import java.util.Scanner;

public class Main1189A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String s = in.next();

            if (n % 2 == 1 || isOdd(s)) {
                System.out.println(1);
                System.out.println(s);
            } else {
                System.out.println(2);
                System.out.println(s.charAt(0) + " " + s.substring(1));
            }
        }
    }

    public static boolean isOdd(String s) {
        char[] ch = s.toCharArray();
        int one = 0;
        int zero = 0;
        for (char c : ch) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        if (zero== 0 || one == 0) {
            return true;
        }
        return ((zero + one) % 2 == 0) && (zero != one);
    }

}

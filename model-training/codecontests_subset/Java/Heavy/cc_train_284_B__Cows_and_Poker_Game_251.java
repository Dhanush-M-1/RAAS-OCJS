
import java.util.Scanner;

public class Main {

    static boolean search(String s, int right, int left) {
        for (int i = right; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                return true;
            }
        }
        for (int i = left; i >= 0; i--) {
            if (s.charAt(i) == 'I') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), c = 0;
        String s = in.next();
        int x1 = s.indexOf("I"), x2 = s.lastIndexOf("I");
        if (x1 < 0 && x2 < 0) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'A') {
                    c++;
                }
            }
        } else if (x1 == x2) {
            c = 1;
        }
        System.out.println(c);
    }
}

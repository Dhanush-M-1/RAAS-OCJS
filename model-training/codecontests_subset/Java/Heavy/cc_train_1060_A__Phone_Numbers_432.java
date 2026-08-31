import java.util.Scanner;

/**
 *
 * @author hp
 */
public class JavaApplication39 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int x = 0;
        int y = n / 11;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '8') {
                x++;
            }
        }
        if (x == 0) {
            System.out.println(0);
        } else {
            if (x < y) {
                System.out.println(x);
            } else {
                System.out.println(y);
            }

        }
    }
}
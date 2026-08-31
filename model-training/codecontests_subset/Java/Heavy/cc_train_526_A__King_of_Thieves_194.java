
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lathif
 */
public class A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = sc.nextLine();
        //String s = ".*.*...*.*.";
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        int len;
        for (int i = 1; i < 25; i++) {
            for (int j = 0; j < s.length() / i + 1; j++) {
                len = 0;
                for (int k = j; k < s.length(); k += i) {
                    if (s.charAt(k) == '*') {
                        len++;
                    } else {
                        len = 0;
                    }
                    if (len == 5) {
                        System.out.println("yes");
                        return;
                    }
                }
            }
        }
        System.out.println("no");
    }

}

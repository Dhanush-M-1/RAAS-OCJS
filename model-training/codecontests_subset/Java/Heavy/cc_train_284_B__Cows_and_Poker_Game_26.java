import java.util.Scanner;

/**
 *
 * @author WIN7
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                if (flag) {
                    flag = false;
                    count = 0;
                }
                count++;
            }

            if (flag && s.charAt(i) == 'A') {
                count++;
            }
        }
        if (flag) {
            System.out.println(count);
        } else if (!flag && count == 1) {
            System.out.println(count);
        } else {
            System.out.println(0);
        }

    }
}
import java.util.Scanner;

/**
 * User : ribhavpahuja
 * Date : 06/07/19
 * Time : 2:07 AM
 */
public class HelloWorld28 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if(str.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }

        if(count0 != count1) {
            System.out.println(1);
            System.out.println(str);
        } else{
            System.out.println(2);
            System.out.println(str.charAt(0) + " " + str.substring(1));
        }
    }
}

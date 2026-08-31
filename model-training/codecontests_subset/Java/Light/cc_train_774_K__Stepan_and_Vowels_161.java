
import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {

        int n;
        String s = new String();

        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        s = in.next();

        int flag1 = 0, flag2 = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'y') {
                flag1 = flag2 = i;
                flag2++;
                while (flag2 < n && s.charAt(flag2) == s.charAt(flag1))
                    flag2++;
                if (flag2 - flag1 == 2 && (s.charAt(i) == 'e' || s.charAt(i) == 'o')) {
                    System.out.print(s.charAt(i));
                }
                System.out.print(s.charAt(i));
                i = flag2 - 1;
            }
            else {
                System.out.print(s.charAt(i));
            }
        }

    }

}

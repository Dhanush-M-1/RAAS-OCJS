
import java.util.Scanner;

public class KeanuReeves {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);        
        int n = scan.nextInt();
        String s = scan.next();
        int one = 0;
        int zero = 0;        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ++one;
            } else {
                ++zero;
            }
        }
        if (one == zero) {
            System.out.println("2");
            System.out.println(s.substring(0, n - 1) + " " + s.substring(n - 1, n));
        }else{
            System.out.println("1");
            System.out.println(s);
        }
    }
    
}

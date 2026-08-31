import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final PrintStream so = System.out;
    static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        char[] x = nsToChars();
        int len = x.length;
        
        int countST = 0;
        int countS = 0;
        for (int i = 0; i < len; i++) {
            if (x[i] == 'S') {
                countS++;
                
            } else if (countS > 0) {
                countS--;
                countST++;
            }
        }
        so.println(len - countST*2);
    } 

    static int ni() {
        return sc.nextInt();
    }
    
    static long nl() {
        return sc.nextLong();
    }

    static char[] nsToChars() {
        return sc.next().toCharArray();
    }
}

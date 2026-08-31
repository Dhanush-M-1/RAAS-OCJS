
import java.util.Scanner;

public class Main{
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        short n = scanner.nextShort(), c = scanner.nextShort();
        short x1 = scanner.nextShort(), x2;
        
        short s, max = 0;
        for(int i = 1; i < n; i++) {
            x2 = scanner.nextShort();
            s = (short)(x1 - x2 - c);
            if (s > max) max = s;
            x1 = x2;
        }
        
        System.out.println(max);
    }
}

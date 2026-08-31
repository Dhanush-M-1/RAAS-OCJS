
import java.util.*;
import java.math.*;
import java.io.*;

/**
 *
 * @author magzhan
 */
public class Main {
    
    
    public static int gcd(int x, int y) {
        BigInteger bx = BigInteger.valueOf(x);
        BigInteger by = BigInteger.valueOf(y);
        BigInteger bgcd = bx.gcd(by);
        return bgcd.intValue();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
        
            Scanner in = new Scanner(System.in);
           
            int a = in.nextInt();
            int b = in.nextInt();
            int s = a;
            while (a >= b) {
                s += a / b;
                a = a / b + (a % b);
                
            }
            
            System.out.println(s);
            
        } catch(Exception ex) {
        
            System.out.println(ex.toString());
        }
    }
    
}

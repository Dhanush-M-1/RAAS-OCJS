
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author omar
 */
public class Ladder {

    
    public static void main(String[] args) {
       
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();      
        int y = scanner.nextInt();
        
        double ret = Math.max(0, Math.ceil ((n*y/100.0)-x));
        System.out.println((int)ret);
    }
}

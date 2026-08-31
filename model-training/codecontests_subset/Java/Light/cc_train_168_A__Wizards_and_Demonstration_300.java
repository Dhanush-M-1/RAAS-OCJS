
import java.util.*;

public class cf168a {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        
        
        double r = p * n / 100.0;
        r = Math.ceil(r);
        
        
        if (m >= r) {
            System.out.println(0);
        } else {
            System.out.println((int) (r - m));
        }
        
    }

}

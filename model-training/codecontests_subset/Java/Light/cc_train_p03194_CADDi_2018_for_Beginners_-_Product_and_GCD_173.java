import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long p = sc.nextLong();
        
        long maxRoot = (long)Math.ceil(Math.pow(p, 1.0/n));
        
        for(long l = maxRoot; l > 0; l--){
            if(p % (long)Math.pow(l, n) == 0){
                System.out.println(l);
                break;
            }
        }
    }
}
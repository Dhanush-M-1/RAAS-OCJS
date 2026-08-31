import java.util.*;
import java.lang.Math;
public class Main{
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++){
            long l = scan.nextLong();
            long r = scan.nextLong();
            long d = scan.nextLong();
            long toPrint = 0;
            if (d >= l)
                toPrint = (d - (r % d)) + r;
            else
                toPrint = d;
            System.out.println(toPrint);    
        }
        
    }
}

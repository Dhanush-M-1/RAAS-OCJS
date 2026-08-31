import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int num = 0;
        for(int i = 0; i < N; ++i) {
            String s;
            s = scan.next();
            if(new BigInteger(s).isProbablePrime(5)) ++num;
        }
        System.out.println(num);
    }
}
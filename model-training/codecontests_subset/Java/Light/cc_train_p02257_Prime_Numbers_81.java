import java.util.*;
import java.math.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        for(int i = 0;i < n;i++){
            BigInteger bi = new BigInteger(sc.next());
            if(bi.isProbablePrime(5)) count++;
        }
        System.out.println(count);
        
    }
}

import java.math.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;

        for(int i = 0; i < num; i++){
            String x = sc.next();
            if(new BigInteger(x).isProbablePrime(5)){
                count++;
            }
        }
        System.out.println(count);
    }
}

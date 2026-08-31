import java.util.*;
import java.lang.*;

public class Main {
    static boolean isPrime(int x) {
        for(int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) return false;
        }
        return true;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int flag = 0, sum = 0;
        while (flag  < n) {
            if(isPrime(sc.nextInt())) sum++;
            flag++;
        }
        System.out.println(sum);
    }
}
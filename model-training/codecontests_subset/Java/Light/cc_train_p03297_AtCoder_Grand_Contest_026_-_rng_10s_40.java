import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long[] as = new long[t];
        long[] bs = new long[t];
        long[] cs = new long[t];
        long[] ds = new long[t];
        for (int i = 0;i < t;++i){
            as[i] = scanner.nextLong();
            bs[i] = scanner.nextLong();
            cs[i] = scanner.nextLong();
            ds[i] = scanner.nextLong();
        }
        for (int i = 0;i < t;++i){
            long a = as[i];
            long b = bs[i];
            long c = cs[i];
            long d = ds[i];
            if(d < b||a < b){
                System.out.println("No");
                continue;
            }
            if(c >= b){
                System.out.println("Yes");
                continue;
            }
            long k1 = a - ((a - (c + 1)) / b + 1) * b;
            if(k1 < 0){
                System.out.println("No");
                continue;
            }
            long k2 = g(b,d);
            long k3 = k1 % k2 - k2;
            if(k3 + b > c){
                System.out.println("No");
            }
            else System.out.println("Yes");
        }
    }

    public static long g(long a,long b) {
        while (a != b){
            if(a > b){
                long k = (a % b);
                a = k == 0 ? b : k;
            }
            else{
                long k = (b % a);
                b = k == 0 ? a : k;
            }
        }
        return a;
    }
}

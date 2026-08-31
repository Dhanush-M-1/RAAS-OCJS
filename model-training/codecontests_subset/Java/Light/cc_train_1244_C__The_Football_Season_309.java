import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n, p, w, d;
        n = scanner.nextLong();
        p = scanner.nextLong();
        w = scanner.nextLong();
        d = scanner.nextLong();
        long x, y = 0;
        boolean []rem = new boolean[(int)w];
        boolean possible = false;
        long remainder;

        while(p - y*d >= 0){
            remainder = (p - y*d)%w;
            if(remainder == 0){
                possible = true;
                break;
            }else if(!rem[(int)remainder]){
                rem[(int)remainder] = true;
            }else {
                break;
            }
            y++;
        }

        if(!possible){
            System.out.println("-1");
        }else{
            x = (p - y*d)/w;
            if(y + x <= n){
                System.out.println(x + " " + y + " " +  (n - x - y));
            }else{
                System.out.println("-1");
            }
        }
    }
}


class Test
{
    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }
}
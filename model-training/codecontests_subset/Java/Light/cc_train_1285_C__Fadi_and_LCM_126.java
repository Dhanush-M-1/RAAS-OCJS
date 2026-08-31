import java.util.Arrays;
import java.util.Scanner;

public class Practise {
    // public static int[] dp= new int[100];

    public static void main(String[] args) {
        //top- down approch
        //fibonacci

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int a =(int) Math.floor(Math.sqrt(n));
        for(long i=a;i>=1;i--)
        {
            if(n%i==0)
            {
                if(n==(n)/Gcd(i,n/i))
                {
                    System.out.print(i+" "+n/i);
                    break;
                }

            }
        }


    }

    private static long Gcd(long i, long l) {
        if(l==0)
            return i;
        return Gcd(l,i%l);
    }
}
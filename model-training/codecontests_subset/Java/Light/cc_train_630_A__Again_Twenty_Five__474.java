import java.util.*;

public class Program
{
    static int binpow(int x,long n)
    {
        if(n==1)
            return x%100;
        if(n%2==0)
            return binpow((x*x)%100,n/2)%100;
        else
        {
            return (x*binpow(x,n-1))%100;
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long n=in.nextLong();
        System.out.println(binpow(5,n));
    }
}
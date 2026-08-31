import java.util.*;
public class MyClass
{
    public static void main(String args[])
    {
     Scanner sc=new Scanner(System.in);
     long n=sc.nextLong();
     System.out.print(lcm(n));
    }
    public static long lcm(long n)
    {
        long res=0;
        if(n<=2)
        {
            return n;
        }
        if(n%2==1)
        {
            res=n*(n-1)*(n-2);
            return res;
        }
        else
        {
            if(n%3==0)
            {
                res=(n-1)*(n-2)*(n-3);
                return res;
            }
            else
            {
                res=n*(n-1)*(n-3);
                return res;
            }
        }
    }
}
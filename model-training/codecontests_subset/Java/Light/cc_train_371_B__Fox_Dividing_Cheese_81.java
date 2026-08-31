import java.util.Scanner;

public class L13_C1
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();
        int[] a_count=new int[3];
        int[] b_count=new int[3];
        long x=count(a, a_count);
        long y=count(b, b_count);
        if (x!=y)
            System.out.println("-1");
        else
        {
            int ans=0;
            for (int i=0;i<3;i++)
                ans=ans+Math.abs(a_count[i]-b_count[i]);
            System.out.println(ans);
        }
    }
    static long count(long n, int a[])
    {
        while (n % 2 == 0 )
        {
            a[0]++;
            n=n/2;
        }
        while (n % 3 == 0 )
        {
            a[1]++;
            n=n/3;
        }
        while (n % 5 == 0 )
        {
            a[2]++;
            n=n/5;
        }
        return  n;
    }
}

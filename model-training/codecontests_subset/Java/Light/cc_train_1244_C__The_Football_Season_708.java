import java.util.Scanner;

public class Foot592 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long p=sc.nextLong();
        long w=sc.nextLong();
        long d=sc.nextLong();
        if(p>(n*w))
        {
            System.out.println(-1);
            return;
        }
        long lg=0;

        long wg=p/w;
        long dg=(p-(wg*w))/d;
        if((p-(wg*w))%d==0)
        {
            lg=n-wg-dg;
            System.out.println(wg+" "+dg+" "+lg);
            return;
        }
        else
        {
            for(long i=1;i<d;i++)
            {
                wg=wg-1;
                dg=(p-(wg*w))/d;
                if((p-(wg*w))%d==0 && wg+dg<=n && wg>=0 && dg>=0)
                {
                    lg=n-wg-dg;
                    System.out.println(wg+" "+dg+" "+lg);
                    return;
                }
            }
        }
        System.out.println(-1);
        return;
    }

}

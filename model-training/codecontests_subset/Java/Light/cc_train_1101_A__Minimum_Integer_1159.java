import java.util.*;
public class segmentt
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        long q;
        q=in.nextLong();
        while(q!=0)
        {
            long l,r,d,a;
            l=in.nextLong();
            r=in.nextLong();
            d=in.nextLong();
            a=d;
            if(d<l || d>r)
            {
                System.out.println(d);
            }
            else if(d>=l && d<=r)
            {
                a=r%d;
                System.out.println((d-a)+r);
            }
            q--;
        }
    }
}

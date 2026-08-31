import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 12-4-10
 * Time: 下午11:20
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private static long gcd(long a,long b)
    {
        return b==0 ? a : gcd(b,a%b);
    }
    private static boolean can(long a,long b,long c,long d,long e,long f)
    {
        long s=a*e-b*d;
        if (s!=0)
        {
            return (c*e-b*f)%s==0 && (a*f-c*d)%s==0;
        }
        if((a==0 && b==0 && c!=0) || (d==0 && e==0 && f!=0)) return false;
        else if(c*e==b*f && a*f==c*d)
        {
            long g=gcd(Math.abs(a),Math.abs(b));
            if(g==0)
            {
                if(a==0 && b==0) return c==0;
                else return c%Math.max(Math.abs(a),Math.abs(b))==0;
            }
            return c%g==0;
        }
        return false;
    }
    public static void main(String[] args)
    {
        long x1,y1,x2,y2,x3,y3;
        Scanner scan = new Scanner(System.in);
        x1=scan.nextLong();
        y1=scan.nextLong();
        x3=scan.nextLong();
        y3=scan.nextLong();
        x2=scan.nextLong();
        y2=scan.nextLong();
        System.out.println((can(x2,y2,x1-x3,y2,-x2,y1-y3)
                || can(x2,y2,x1+x3,y2,-x2,y1+y3)
                || can(x2,y2,x1-y3,y2,-x2,y1+x3)
                || can(x2,y2,x1+y3,y2,-x2,y1-x3)) ? "YES" : "NO");
    }
}

import java.util.Scanner;
import java.io.*;
public class ques
{
    static long gcd(long a, long b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }
    public static void main(String argc[])
    {
      Scanner sc=new Scanner(System.in);  
    long n,p,w,d, win=0,loss=0,draw=0, flag=0;
    n=sc.nextLong();
    p=sc.nextLong();
    w=sc.nextLong();
    d=sc.nextLong();
    long c=0;
    win=p/w;
    if(p%gcd(w,d)!=0)
    {
        System.out.println("-1");
        System.exit(0);
    }
    while((p-w*win)%d!=0 )
    {
        win--;
        if(win<0)
        {
            flag++;
            break;
        }
        if(win + (p-w*win)/d > n)
        {
            flag=1;
            break;
        }
    }
    if(flag==0 && ((n-win)-(p-w*win)/d)>=0 && (p-w*win)/d>=0)
    {
        System.out.println(""+ win + " " + (p-w*win)/d + " " + ((n-win)-(p-w*win)/d));
        //cout<<win<<" "<<(p-w*win)/d<<" "<<n-win-(p-w*win)/d;
    }
    else
    {
        System.out.println("-1");
        //cout<<"-1";
    }
    }
}
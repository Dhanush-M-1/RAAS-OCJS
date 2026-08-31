
import java.util.*;
import java.lang.*;
public class Candles
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int a,b;
        a=s.nextInt();
        b=s.nextInt();
        int x=a;int y;
        while(a-b>=0)
        {
            y=a%b;
            a=(int)(a/b);
            x+=a;
            a+=y;
        }
        System.out.print(x);
    }
}

import java.util.*;
import java.math.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int N=sc.nextInt();
            if(N==1)
            {
                System.out.println("0");
                continue;
            }
            int cnt=0;
            while(N!=1)
            {
                if(isp2(N))
                    break;
                if(N%6==0)
                    N/=6;
                else
                    N*=2;
                cnt++;
            }
            if(isp2(N))
                System.out.println("-1");
            else
                System.out.println(cnt);
        }
    }
    public static boolean isp2(int n)
    {
        if(n==0 || n==1)
            return false;
        return (int)(Math.ceil((Math.log(n)/Math.log(2))))==(int)(Math.floor(((Math.log(n)/Math.log(2)))));
    }
}
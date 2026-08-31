import java.util.*;
import java.io.*;
public class equation
{
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     public static void main(String[] args)throws IOException
    {
        String s=in.readLine();
        String[] st = s.trim().split("\\s+");
        long a=Long.parseLong(st[0]);
        long b=Long.parseLong(st[1]);
        long c=Long.parseLong(st[2]);
        boolean ch=true;
        if(a==0&&b==0&&c==0)
        System.out.println("-1");
        else 
        {
            if(b*b-4*a*c>=0)
        {
            if(a==0||b*b-4*a*c==0)
            {
                double r=0;
                if(a==0)
                {
                    if(c!=0&&b!=0)
                    r=-c*1.0/b;
                    else if(b==0&&c!=0)
                    {
                        ch=false;
                        System.out.println("0");
                    }
                }
                else
                r=-b/(2*a);
                if(ch)
                {
                System.out.println("1");
                System.out.println(String.format("%.10f", r));
                }
            }
            else
            {
                double r1=0,r2=0;
                System.out.println("2");
                r1=-b-Math.sqrt(b*b-4*a*c);
                r2=-b+Math.sqrt(b*b-4*a*c);
                r1=(r1)/(2*a);
                r2=(r2)/(2*a);
                if(r1<r2)
                {
                System.out.println(String.format("%.10f", r1));
                System.out.println(String.format("%.10f", r2));
                }
                else
                {
                System.out.println(String.format("%.10f", r2));
                System.out.println(String.format("%.10f", r1));
                }
            }
        }
        else
        System.out.println("0");
    }
        
    }
}
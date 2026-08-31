import java.util.*;
import java.io.*;
public class remainder
{
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     public static void main(String[] args)throws IOException
    {
        String s=in.readLine();
        String[] st = s.trim().split("\\s+");
        long n=Long.parseLong(st[0]);
        long x=Long.parseLong(st[1]);
        long y=Long.parseLong(st[2]);
        s=in.readLine();
        long c=0;
        for(long i=n-1;i>=n-x;i--)
        {
            if(i==n-y-1)
            {
                if(s.charAt((int)i)=='0')
                c++;
            }
            else
            {
                if(s.charAt((int)i)=='1')
                c++;
            }
        }
        System.out.println(c);
    }
}
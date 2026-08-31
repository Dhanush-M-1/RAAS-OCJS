import java.io.*;
import java.util.*;
public class x
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        double sum=0.0;
        int i;
        int max=-1;
        int x;
        for(i=0;i<n;i++)
        {
            x=in.nextInt();
            sum+=x;
            if(max<x)
            {
                max=x;
            }
        }
        long ans=(long)(Math.ceil(sum/(n-1)));
        System.out.println(Math.max(max,ans));
    }
}
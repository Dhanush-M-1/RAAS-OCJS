import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=0;x<t;x++)
        {
        int n=sc.nextInt();
        int larr[]=new int[n];
        int rarr[]=new int[n];
        int rmin,lmax;
        lmax=sc.nextInt();
        rmin=sc.nextInt();
        for(int i=1;i<n;i++)
        {
            int t1=sc.nextInt();
            int t2=sc.nextInt();
            if(t2<rmin)
            rmin=t2;
            if(t1>lmax)
            lmax=t1;
        }
        if(n==1||lmax-rmin<=0)
        System.out.println("0");
        else
        System.out.println(lmax-rmin);
        }
    }
}
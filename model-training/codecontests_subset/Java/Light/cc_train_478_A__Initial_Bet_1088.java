import java.util.*;
public class A
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a1=sc.nextInt();
        int a2=sc.nextInt();
        int a3=sc.nextInt();
        int a4=sc.nextInt();
        int a5=sc.nextInt();
        double d=(double)(a1+a2+a3+a4+a5)/5;
        if(a1==0&&a2==0&&a3==0&&a4==0&&a5==0)
        System.out.println(-1);
        else
        {
            double x=d-(int)d;
            if(x>0)
            System.out.println(-1);
            else
            System.out.println((int)d);
        }
    }
}
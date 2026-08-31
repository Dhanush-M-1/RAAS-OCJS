import java.util.*;
import java.util.Arrays.*;
public class Solutionn
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n,k,c=0,c1=0,num;
        n=in.nextInt();
        k=in.nextInt();
        if(n==k)
        {
            System.out.println(n);
            System.exit(0);
        }
        num=n;
        n=k-n;
        c=n/2;
        c1=n/3;
        if(k%2==0)
        {
            c++;
        }
        if(k%3==0)
        {
            c1++;
        }
        if(num%2==0)
        {
            c++;
        }
        if(num%3==0)
        {
            c1++;
        }
        if(c>c1)
        {
            System.out.println("2");
        }
        else if(c<c1)
        {
            System.out.println("3");
        }
        else
        {
            System.out.println("2");
        }
    }
}
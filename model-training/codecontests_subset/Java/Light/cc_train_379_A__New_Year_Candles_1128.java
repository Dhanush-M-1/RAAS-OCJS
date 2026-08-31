
import java.util.*;
public class Codeforces
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int res=a,m=0;
        while(a/b!=0)
        {
            m=(a%b);
            res=res+(a/b);
            a=(a/b)+m;
        }
     
        System.out.print(res);
    }
}
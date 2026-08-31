import java.util.*;
public class cf1
{
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        int t=obj.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=obj.nextInt();
            int a=0;
            int b=0;
            int ans=0;
            while(n%2==0)
            {
                n=n/2;
                a++;
            }
            while(n%3==0)
            {
                n=n/3;
                b++;
            }
            if(n!=1)
            {
                ans=-1;
            }
            else
            {
                if(a>b)
                {
                    ans=-1;
                }
                else
                {
                    ans=(2*b)-a;
                }
            }
            System.out.println(ans);
        }
    }
}
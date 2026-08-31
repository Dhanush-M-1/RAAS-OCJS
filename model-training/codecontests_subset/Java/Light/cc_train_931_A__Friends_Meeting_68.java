import java.util.*;
public class algo1
{
    public static void main(String args[])
    {
        Scanner ex=new Scanner(System.in);
        int a=ex.nextInt();
        int b=ex.nextInt();
        if(a>b)
        {
            a=a+b;
            b=a-b;
            a=a-b;
        }
        int diff=b-a;
        int flag=0;
        if(diff%2==1)
        {
            diff=diff/2+1;
            flag=1;
        }
        else
        diff=diff/2;
        int ans;
        if(flag==1)
        ans=diff*(diff+1)-diff;
        else
        ans=diff*(diff+1);
        System.out.println(ans);
    }
}
import java.util.*;
public class A
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        char ch1=str.charAt(0);
        char ch2=str.charAt(1);
        int q=sc.nextInt();
        int flag=0,temp=0,xx=0;
        while(q-->0)
        {
            String s=sc.next();
            if(str.equals(s))
            {
                xx=1;
            }
            else
            {
                char x1=s.charAt(0);
                char x2=s.charAt(1);
                if(ch1==x2)
                flag=1;
                if(ch2==x1)
                temp=1;
            }
        }
        if(xx==1||(flag==1&&temp==1))
        System.out.println("YES");
        else
        System.out.println("NO");
    }
}
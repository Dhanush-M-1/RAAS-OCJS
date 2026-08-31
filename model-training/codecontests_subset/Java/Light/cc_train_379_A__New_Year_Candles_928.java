import java.util.*;
public class a379
{
    public static void main(String ar[])
    {
        Scanner ob=new Scanner(System.in);
        int n=ob.nextInt();
        int m=ob.nextInt();
        int x=0,result=0;
        while(n>0)
        {
            result+=n;
            x+=n;
            n=x/m;
            x=x%m;
        }
        System.out.println(result);

    }
}

import java.util.*;
public class Friends
{
    public static void main(String args[])
    throws Exception
    {
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        int b=scan.nextInt();
        int min=0,max=0,tiredness=0;
        if(a<=b)
        {
            min=a;
            max=b;
        }
        else
        {
            min=b;
            max=a;
        }
        for(int i=1;;i++)
        {
            min=min+1;
            tiredness=tiredness+i;
            if(min<max)
            {
            max=max-1;
            tiredness=tiredness+i;
        }
        if(min==max)
        {
            break;
        }
            }
            System.out.print(tiredness);
    }
}
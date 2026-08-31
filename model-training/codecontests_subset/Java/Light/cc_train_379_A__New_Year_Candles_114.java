import java.util.*;
public class NewYearCandles
{
    public static void main(String args[])
    throws Exception
    {
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        int b=scan.nextInt();
        int num=0;
        for(int i=1;a!=0;i++)
        {
            a=a-1;
            if(i%b==0)
            {
                a=a+1;
            }
            num=num+1;
        }
        System.out.print(num);
    }
}
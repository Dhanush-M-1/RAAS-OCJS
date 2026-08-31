
import java.util.Scanner;

public class B1374 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i=0;i<t;i++)
        {
            int count=0;
            long a=sc.nextLong();
            while (a>0)
            {
                if (a==1)
                {
                    break;
                }else if(a<0)
                {
                    break;
                }
                if (a%6==0)
                {
                    a=a/6;
                    count++;
                }else {
                    a=a*2;
                    count++;
                }
                if (a==1)
                {
                    break;
                }else if(a<0)
                {
                    break;
                }
            }
            if (a==1)
            {
                System.out.println(count);
            }else {
                System.out.println("-1");
            }
        }
    }
}

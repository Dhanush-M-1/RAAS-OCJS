import java.util.*;

public class MultiplyDivide
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int iter1=0;iter1<T;iter1++)
        {
            long n=sc.nextLong();

            if(n==1)
            {
                System.out.println(0);
                continue;
            }
            
            long count=0;
            int flag=0;

            while(true)
            {
                count++;
                if(n%6==0)
                    n/=6;
                else
                    n*=2;
                if(n==1)
                    break;
                if(n>Math.pow(10,9))
                {
                    flag=1;
                    break;
                }

            }
            if(flag==0)
                System.out.println(count);
            else
                System.out.println(-1);
        }
        sc.close();
    }
}

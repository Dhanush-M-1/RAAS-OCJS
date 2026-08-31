import java.util.*;

public class CodeForces
{
     public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int u=0;u<t;u++)
        {
            long n=sc.nextLong();
            if(n==1)
            {
                System.out.println(0);
                continue;
            }
            int count=0;
            int wrong=0;
            while(n>1)
            {
                if(n%6==0)
                {
                    n=n/6;
                    count++;
                    if(n==1)
                    {
                        break;
                    }
                }
                else if(n%3==0)
                {
                    n=n*2;
                    count++;
                }
                else
                {
                    wrong++;
                    break;
                }
            }
            if(wrong!=0)
            {
                System.out.println(-1);
                continue;
            }
            System.out.println(count);
        }
    }
}
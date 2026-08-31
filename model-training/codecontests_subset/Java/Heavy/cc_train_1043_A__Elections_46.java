import java.util.*;
import java.lang.*;
public class Main
{
    public static void main(String argz[])
    {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        int a[]=new int[n];
        int max=0;
        int sum=0;
        int reman=0;
        for(int i=0;i<n;i++)
        {
            a[i]=inp.nextInt();
            if(i==0)
            {
                max=a[i];        
            }
            else if(a[i]>max)
            {
                max=a[i];
            }
            else
            {}
            
            sum=sum+a[i];
        }
        int min=1;
        for(int j=1;j<=10000;j++)
        {
            reman=j*n-sum;
            if(reman>sum)
            {
                if(j>=max)
                {
                    min=j;
                    break;
                }
            }
        }
        System.out.println(min);
        
    }
    
}
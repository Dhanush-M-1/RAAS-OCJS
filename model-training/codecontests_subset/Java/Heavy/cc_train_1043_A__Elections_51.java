import java.util.*;
public class Elections
{
    public static void main(String args[])
    throws Exception
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] a=new int[n];
        int sum1=0,value=0,maxValue=0,sum2=0,ans=0;
        for(int i=0;i<n;i++)
        {
            a[i]=scan.nextInt();
            sum1=sum1+a[i];
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                value=a[j];
            if(value>=maxValue)
            {
                maxValue=value;
            }
        }
        }
        int k=maxValue;
        for(;;k=k+1)
        {
            sum2=(k*n)-sum1;
        ans=k;
        if(sum2>sum1)
        break;
    }
    System.out.print(ans);
    }
}
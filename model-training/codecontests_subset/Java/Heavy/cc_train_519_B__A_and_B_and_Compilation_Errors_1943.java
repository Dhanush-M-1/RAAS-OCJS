
import java.util.Scanner;
public class AandBandCompilationErrors
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n-1];
        int[] c=new int[n-2];
        for(int i=0;i<n;i++)
        a[i]=sc.nextInt();
         for(int i=0;i<n-1;i++)
        b[i]=sc.nextInt();
         for(int i=0;i<n-2;i++)
        c[i]=sc.nextInt();
        int sum1=0,sum2=0,sum3=0;
        for(int i=0;i<n;i++)
        sum1+=a[i];
        for(int i=0;i<n-1;i++)
        sum2+=b[i];
        for(int i=0;i<n-2;i++)
        sum3+=c[i];
        System.out.println(sum1-sum2);
        System.out.println(sum2-sum3);
    }
}

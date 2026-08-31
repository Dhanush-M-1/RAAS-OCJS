import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class a1
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        long n=s.nextLong();
        int m=s.nextInt();
        long sum=0;
        long [] arr=new long[m];
        for(long i=0;i<n;i++)
        {
            int j=s.nextInt();
            arr[j-1]++;
        }
        sum=(n*(n-1))/2;
        for(int j=0;j<m;j++)
        {
            if(arr[j]>1)
                sum-=((arr[j]*(arr[j]-1))/2);
        }
        System.out.println(sum);
    }
}


import java.util.Scanner;

public class TheBestGift {
    public static void main(String asd[])throws Exception
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int a[]=new int[m+1];
        for(int i=0;i<n;i++)
            a[in.nextInt()]++;
        long sum=0;
        for(int i=1;i<m;i++)
        {
            for(int j=i+1;j<=m;j++)
                sum+=a[i]*a[j];
        }
        System.out.println(sum);
    }
}

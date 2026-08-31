import java.util.*;
public class thebestgift
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int a[]=new int[n];
        int c[]=new int[m+1];
        long ans=0;int i,s=n;
        Arrays.fill(c,0);
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            c[a[i]]++;
        }
        for(i=0;i<n;i++)
        {
            s--;
            c[a[i]]--;
            ans+=(s-c[a[i]]);
        }
        System.out.println(ans);
    }
}
        
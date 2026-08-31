import java.util.*;
public class Solution
{
    public static Scanner sc = new Scanner(System.in);
    public static long calc(int n, long p[], long c[], long flag)
    {
        for(int i=0;i<n-1;i++)
        {
            if(p[i+1]<p[i] || c[i+1]<c[i])
            {
                flag++;
            }
            else if(p[i+1]-p[i]<c[i+1]-c[i])
            {
                flag++;
            }
        }
        return flag;
    }
    public static void main(String args[])
    {
        int t = sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            long p[] = new long[n];
            long c[] = new long[n];
            long flag=0;
            for(int j=0;j<n;j++)
            {
                p[j] = sc.nextInt();
                c[j] = sc.nextInt();
                if(c[j]>p[j])
                {
                    flag++;                      
                }
            }
            flag = calc(n,p,c,flag);
            if(flag==0)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}
import java.io.*;
import java.util.*;
public class Subsequence
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[m];
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
            }
            for(int i=0;i<m;i++)
            {
                b[i]=sc.nextInt();
            }
            int flag=0;int d=0;
            for(int i=0;i<n;i++)
            {
               for(int j=0;j<m;j++)
               {
                   if(a[i]==b[j])
                   {
                       flag++;
                       d=a[i];
                       break;
                   }
                   if(flag>0)
                    break;
                }
            }
            if(flag==0)
                System.out.println("NO");
            else
            {
                System.out.println("YES");
                System.out.println(1+" "+d);
            }
        }
    }
}
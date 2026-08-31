import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main (String[] args) 
    {
        Scanner s1=new Scanner(System.in);
        int n,m;
        n=s1.nextInt();
        m=s1.nextInt();
        boolean mark[]=new boolean[m];
        for(int i=0;i<n;i++)
        {
            int num=s1.nextInt();
            for(int j=0;j<num;j++)
            {
                int no=s1.nextInt();
                if(!mark[no-1])
                mark[no-1]=true;
            }
        }
        for(int i=0;i<m;i++)
        {
            if(!mark[i])
            {
            System.out.println("NO");
            return;
            }
        }
        System.out.println("YES");
    }
}
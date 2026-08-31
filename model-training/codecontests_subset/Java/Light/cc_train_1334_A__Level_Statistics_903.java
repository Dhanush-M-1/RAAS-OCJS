import java.math.*;
import java.lang.*;
import java.io.*;
import java.util.*;
public final class Test
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while(test-->0)
        {
            int n=sc.nextInt();
            int ip=0,ic=0;
            int i=0;
            boolean flag=true;
            for(i=1;i<=n;i++)
            {
                int p=sc.nextInt();
                int c=sc.nextInt();
                if(p==ip && c==ic)
                continue;
                else if((p-ip)<(c-ic))
                flag=false;
                else if(p>ip && c>=ic && c>p)
                flag=false;
                else if(p>ip && c>=ic)
                {
                    ip=p;
                    ic=c; 
                }
                else
                flag=false;
            }
            if(flag)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}
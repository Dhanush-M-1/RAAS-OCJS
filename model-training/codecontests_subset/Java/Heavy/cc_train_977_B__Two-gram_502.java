
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{   public static void main (String[] args) throws java.lang.Exception
	{
		Scanner ob=new Scanner(System.in);
        int n;
        n=ob.nextInt();
        String s=ob.next();
        char a[]=s.toCharArray();
        int ans=0;
        String se="";
        for(int i=0;i<n-1;i++)
        {int count=1;
            for(int j=i+2;j<n;j++)
            {
             if(j==i+2)
             {
                 if(a[i]==a[i+1] && a[j]==a[i])
                 {
                     count++;
                 }
             }
                if(j<n-1 && a[i]==a[j] && a[i+1]==a[j+1])
                {
                    count++;
                }
            }
            if(count>ans)
            {
                ans=count;
                se=String.valueOf(a[i])+String.valueOf(a[i+1]);
            }
        }
        System.out.println(se);
	}

 
}
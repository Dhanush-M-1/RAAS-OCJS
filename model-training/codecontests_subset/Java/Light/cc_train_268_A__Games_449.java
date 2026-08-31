
import java.util.*;
import java.lang.String;
import java.lang.Math;
import java.util.Arrays;

public class Capitalization
{
public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
int n,res=0,k=0;
n=sc.nextInt();
int [] a=new int[n+1];
int [] b=new int[n+1];
for(int i=0;i<n;i++)
{
    a[i]=sc.nextInt();
    b[i]=sc.nextInt();
}
for(int i=0;i<n;i++)
{
    for(k=0;k<n;k++)
    {
        if(a[i]==b[k])
        {
            res++;
            
        }
        
    }
}
System.out.println(res);
}

}
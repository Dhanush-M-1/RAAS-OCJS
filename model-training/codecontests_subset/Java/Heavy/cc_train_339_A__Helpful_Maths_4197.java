import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            int l=(s.length()+1)/2;
            int a[]=new int[l];
            for(int i=0,j=0;i<l;i++,j+=2)
            a[i]=Integer.valueOf(s.substring(j,j+1));
            for(int i=0;i<l;i++)
            for(int j=i+1;j<l;j++)
            if(a[i]>a[j])
            {
                int temp=a[j];
                a[j]=a[i];
                a[i]=temp;
            }
            for(int i=0;i<l-1;i++)
            System.out.print(a[i]+"+");
            System.out.print(a[l-1]);
        }
        catch(Exception e)
        {
            return;
        }
    }
}
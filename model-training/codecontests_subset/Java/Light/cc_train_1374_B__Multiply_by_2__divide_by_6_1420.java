import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
      
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int temp=0;
            while(n>1)
            {
                if(n%6==0)
                {
                    
                   n=n/6;
                   temp++;
                }
                else
                {
                    n=n*2;
                    temp++;
                }
            }
                if(n==1&&temp>=0)
                {
                    System.out.println(temp);
                }
                else
                {
                    System.out.println("-1");
                }
            
        }
    }
}


import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map.Entry;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=sc.nextInt();
        }
        int sum1=0;
        for(int i=0;i<n-1;i++)
        {
            sum1+=sc.nextInt();
        }
        
        System.out.println((sum-sum1));
        sum=0;
        for(int i=0;i<n-2;i++)
        {
            sum+=sc.nextInt();
        }
        System.out.println((sum1-sum));
    }
}
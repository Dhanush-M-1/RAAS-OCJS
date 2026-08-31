import java.util.Scanner;  
import java.util.*; 
import java.util.Arrays; 
 
public class Solution
{ 
    public static void main(String[] args) 
    { 
        
        Scanner sc = new Scanner(System.in); 
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int n=sc.nextInt();
            int r=fibonacciRecursion(n%3,a,b);
            System.out.println(r);
            
        }
    }
    public static int fibonacciRecursion(int n,int a,int b)
    {
    	if(n == 0)
    	{
    		return a;
    	}
    	if(n == 1)
    	{
    		return b;
    	}
    	return fibonacciRecursion((n-2),a,b) ^ fibonacciRecursion((n-1),a,b);
	}
}
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    public static int maximum(int a, int b)
    {
        return (a>b? a: b);
    }
    public static int getMax(int[] arr, int c)
    {
        int max = 0;
        for(int i = 0; i < arr.length-1; i++)
        {
            if(arr[i] > arr[i+1]+c)
            {
                max = maximum(max, arr[i] - arr[i+1] -c);
            }
        }
        return max;
    }
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
		{
		    arr[i] = sc.nextInt();
		}
		System.out.println(getMax(arr,c));
	
		
	}
}

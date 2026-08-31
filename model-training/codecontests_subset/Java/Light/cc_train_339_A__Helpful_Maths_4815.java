/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class Solution {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] sumArray = input.split("\\+");
		int n = sumArray.length;
		int[] num = new int[n];
		for(int i=0;i<n;i++)
		{
		    num[i] = Integer.parseInt(sumArray[i]);
		}
		Arrays.sort(num);
		for(int i=0;i<n;i++)
		{
		    if(i==n-1)
		    {
		        System.out.print(num[i]);
		        break;
		    }
		    System.out.print(num[i]+"+");
		}
	}
}
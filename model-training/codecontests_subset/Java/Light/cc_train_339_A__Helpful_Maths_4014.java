/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String[] tokens = line.split("\\+");
		int[] nums = new int[tokens.length]; 
		
		for(int i = 0; i < tokens.length;i++) {
		    nums[i] = Integer.parseInt(tokens[i]);
		}
		
		Arrays.sort(nums);
		for(int i= 0; i < nums.length; i++){
		    System.out.print(nums[i]);
		    if(i < nums.length -1) System.out.print('+');
		}
	}
	
	
}

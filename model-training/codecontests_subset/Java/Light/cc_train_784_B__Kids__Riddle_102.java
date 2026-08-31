/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class Solution {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = Integer.toHexString(n);
		int count = 0;
		for(int i=0;i<s.length();i++)
		{
		    if(s.charAt(i) == '4' || s.charAt(i) == '6' || s.charAt(i) == '9' || s.charAt(i) == '0' || s.charAt(i) == 'a' || s.charAt(i) == 'd')
		    {
		        count++;
		    }
		    if(s.charAt(i) == '8' || s.charAt(i) == 'b')
		    {
		        count += 2;
		    }
		}
		System.out.println(count);
	}
}
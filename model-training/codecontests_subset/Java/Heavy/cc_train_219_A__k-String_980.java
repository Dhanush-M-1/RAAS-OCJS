//package codeforces;

import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.Stack;

public class q_1 {
	static Scanner scn = new Scanner(System.in);
	static long cunt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.format("%.10f", ans);char c = sc.next().charAt(0);
		int n=scn.nextInt();
		String str=scn.next();
		boolean bl=true;
		StringBuilder sb=new StringBuilder();
	int arr[]=new int[26];
	for(int i=0;i<str.length();i++)
	{
		arr[str.charAt(i)-97]=arr[str.charAt(i)-97]+1;
	}
	for(int i=0;i<26;i++)
	{
		if(arr[i]%n!=0)
		{System.out.println("-1");
			return;
		}
		else
		{
			for(int j=0;j<arr[i]/n;j++) 
				sb.append((char)(i+'a'));
		}
	}
	
	for(int i=0;i<n;i++)
		System.out.print(sb);
	
}
	
	public static int ohh(long n)
	{	
		if(n==1)
		{
			return 0;
		}
		int x=Integer.MAX_VALUE,y=Integer.MAX_VALUE,z=Integer.MAX_VALUE;
		if(n%2==0)
		 x=1+ohh(n/2);
		
		if(n%3==0)
			 y= 1+ohh(2*(n/3));
			
			
		if(n%5==0)
			 z= 1+ohh(4*n/5);
		return Math.min(x, Math.min(y, z));
	}
	public static String factorial(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(new BigInteger(i + ""));
		}
		return fact.toString();
	}

	public static int bs(int arr[], int k) {
		int high = 0, low = Integer.MIN_VALUE, ans = 0;
		for (int i = 0; i < arr.length; i++) {
			high += arr[i];
			if (arr[i] > low)
				low = arr[i];
		}
		while (low <= high) {
			int mid = (high + low) / 2;
			if (valid(arr, mid, k)) {
				ans = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return ans;
	}

	public static boolean valid(int arr[], int mid, int k) {
		int sum = 0, cs = 1;
		for (int i = 0; i < arr.length; i++) {
			if (sum + arr[i] > mid) {
				cs++;
				if (cs > k)
					return false;
				sum = arr[i];
			} else
				sum += arr[i];
		}
		return true;
	}

	public static long gcd(long a, long n) {

		if (a == 0)
			return n;
		return gcd(n % a, a);
	}

}

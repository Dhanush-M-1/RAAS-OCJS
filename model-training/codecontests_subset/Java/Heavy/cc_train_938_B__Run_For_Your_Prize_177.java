//package godiji;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class pac1 {
	static Scanner scn = new Scanner(System.in);
	static int count = 0;

	public static void main(String[] args) throws Exception {
		// enter the size of arra
		int n=scn.nextInt(),max=0;
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scn.nextInt();
		}
		int brr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			brr[i]=Math.min(arr[i]-1, 1000000-arr[i]);
			if(brr[i]>max)
				max=brr[i];
		}
		System.out.println(max);
		
		
	}

	public static void cut(int arr[], int n, int sum, int prev) {
		if (sum > n)
			return;
		if (sum == n) {
			count++;
			return;
		}
		for (int i = prev; i < arr.length; i++) {
			cut(arr, n, sum + arr[i], i + 1);
		}
	}

	public static long gcd(long a, long n) {

		if (a == 0)
			return n;
		return gcd(n % a, a);
	}
}

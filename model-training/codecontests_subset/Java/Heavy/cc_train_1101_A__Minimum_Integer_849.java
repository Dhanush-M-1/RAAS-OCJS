//package codeforces;

import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.Set;

public class q {
	static Scanner scn = new Scanner(System.in);
	static int mod = 1000000007;
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t=scn.nextInt();
		while(t-->0)
		{
			int l,r,d,i=1;
			long ans=0,div1=0;
			boolean bl=false;
			l=scn.nextInt();
			r=scn.nextInt();
			d=scn.nextInt();
			double div=(double)l/(double)d;div1=r/d;
			if(div>1.0)
			{
				System.out.println(d*1);
			}
			else
				System.out.println((div1+1)*d);
			
			
		}
	}
	
	
	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		int l = gcd(b % a, a);
		return l;
	}

	public static void permu(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String res = str.substring(0, i) + str.substring(i + 1);
			permu(res, ans + ch);

		}
	}
	public static String factorial(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(new BigInteger(i + ""));
		}
		return fact.toString();
	}

}

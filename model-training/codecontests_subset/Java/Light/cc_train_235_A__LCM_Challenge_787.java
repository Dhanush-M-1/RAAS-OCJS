import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormat;
import java.lang.Math;
import java.util.Iterator; 
public class C39{
    static class Pair implements Comparable<Pair>{
		int v;
		int i;
		public Pair(int v, int i) {
			this.v = v;
			this.i = i;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.v-o.v;
		}
	}
	public static long gcd(long a, long b){
	    if(b==0){
	        return a;
	    }
	    else{
	        return gcd(b, a%b);
	    }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long res = 0;
		int flag = 0;
		long b = 0;
		if(n<=3) {
			if(n==1) {
				System.out.println(1);
			}else if(n==2) {
				System.out.println(2);
			}else {
				System.out.println(6);
			}
		}else {
			if(n%2==1) {
				System.out.println(n*(n-1)*(n-2));
			}else {
				System.out.println((n-1)*(n-3)*(n%3==0?(n-2):n));
			}
		}
	}
}
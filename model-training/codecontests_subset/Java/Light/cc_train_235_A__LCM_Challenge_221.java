import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Acm {
	public static void main(String args[]){ 
		BigInteger x ; 
		Scanner sc= new Scanner(System.in);
		long n =sc.nextLong(); long lcm1,lcm2,lcm3 =0 ; long max =0 ; long res= 0; 
		for(long i =n; i>=n-100 && i>0;i--)
			for(long j =n; j>=n-100 && j>0;j--)
				for(long k=n; k>=n -100 && k>0;k--)
					res = Math.max(res, lcm(i,lcm(j,k)));
		System.out.println(res);
			
		
	}		

		
		
		
		

			
				
	
		
			
			
			
			
				
			
		public static long gcd(long n,long l){
			if(n==0) return l ; 
			if(l==0) return n ;
			if(n>l) return gcd(n%l,l); else return gcd(n,l%n);
			
			
		}
		public static long lcm(long n,long l){
			
			return n*l/gcd(n,l);
			
		}
		
		
	
	
	
	

	
	
		
	}
	

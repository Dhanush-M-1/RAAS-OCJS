import java.util.*;
import java.lang.*;
import java.io.*;
public class Main{
static long gcdEuclid(long a,long b) {
		if(b==0) return a;
		else return gcdEuclid(b,a%b);
	}
	
	static long lcm(long a,long b) {
		long gcd = gcdEuclid(a,b);
		return (a*b)/gcd;
	}
	
		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			long num = sc.nextLong();
			
			if(num==1){
			    System.out.println("1 1");
			    return;
			}
			
			long i = (long)Math.sqrt(num);
			long j=1;
			for(;i>=1;i--) {
				if(num%i==0) {
					 j = num/i;
					if(i!=j && lcm(i,j)==num) break;
				}
				
			}
			System.out.println(i+ " " + j);
		}
}
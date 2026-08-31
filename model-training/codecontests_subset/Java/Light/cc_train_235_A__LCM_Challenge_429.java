import java.util.*;
import java.io.PrintWriter;
import java.lang.*;
public class test {
	public static void main (String [] test){
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		  if(n==1 || n==2) {System.out.println(n);}
		  else if (n%2 == 0 ){
			  if(f(n,n-3)==1) System.out.println(n*(n-1)*(n-3));
			  else System.out.println((n-1)*(n-2)*(n-3));
			  
		  }
		  else System.out.println(n*(n-1)*(n-2));

	
		
		




		}
	static long f (long x , long y){
		if(y==0){return x;}
		else{
			long z = x%y;
		return f(y,z);}
	}
	}
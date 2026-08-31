//package Practice;
import java.util.*;

 
 
public class  Again25_630A {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Long a=sc.nextLong();
		//Long pow= fastpow(5,a);
		//String s=Long.toString(pow);
		//System.out.println(s.substring(s.length()-2));1000000000000000000
		System.out.println(25);
				
	}
	public static  long fastpow(long a,long b) {
        //stepcount++;
        if(b==0) return 1;    //Base case
        if(b%2==0) return fastpow(a*a,b/2);
        return a*fastpow(a*a,b/2);    //Generalise
    }	
	}
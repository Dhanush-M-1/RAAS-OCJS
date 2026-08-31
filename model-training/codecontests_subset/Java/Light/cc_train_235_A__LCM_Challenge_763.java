/* package whatever; // don't place package name! */
import java.math.BigInteger; 
import java.util.*;
import java.lang.*;
import java.io.*;

public class main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger n1 =BigInteger.valueOf(n); 
        BigInteger n2 = BigInteger.valueOf(n-1);
        BigInteger n3 = BigInteger.valueOf(n-2);
        BigInteger n4 = BigInteger.valueOf(n-3);
        
        
		BigInteger res = new BigInteger("1");
		if(n<=2){
			res=BigInteger.valueOf(n);
		}
		else if(n%2!=0)
			res= n3.multiply(n2).multiply(n1);
		else{
			if(n%3==0){
				res = n2.multiply(n3).multiply(n4);
			}
			else
				res = n4.multiply(n2).multiply(n1);
		}
		System.out.println(res);
	}
}
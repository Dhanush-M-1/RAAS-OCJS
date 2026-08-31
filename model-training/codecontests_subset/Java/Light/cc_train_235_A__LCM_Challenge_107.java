import java.util.*;
import java.io.*;

public class Tests{
	public static void main (String []args) {
		Scanner in = new Scanner (System.in);
		long n = in.nextLong();
		int ans = 0 ;
		  if(n==1 || n==2) {System.out.println(n);}
		  else if (n%2==1)  {System.out.println(n*(n-1)*(n-2));}
		  else if (n%3==0) {System.out.println ((n-1)*(n-2)*(n-3));}
		  else {System.out.println(n*(n-1)*(n-3));}
	}
}
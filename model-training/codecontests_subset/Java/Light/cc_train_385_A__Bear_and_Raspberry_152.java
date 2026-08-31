import java.io.*;
import java.math.BigInteger;
import java.util.*;
 public class Main {
	public static void main(String args[]) throws Exception
	{
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 int n,c,a[];
		 String s[];
		 s=in.readLine().split(" ");
		 n=Integer.parseInt(s[0]);
		 c=Integer.parseInt(s[1]);
		 a=new int[n];
		 s=in.readLine().split(" ");
		 for(int i=0;i<n;i++)
			 a[i]=Integer.parseInt(s[i]);
		 int sum=0;
		 for(int i=0;i<n-1;i++)
		 {
			 sum=Math.max(a[i]- a[i+1]-c,sum);				 
		 }
		 System.out.print(sum);
	}
}

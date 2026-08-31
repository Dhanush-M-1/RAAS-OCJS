import java.io.*;
import java.util.Scanner;
import java.lang.*;
public class killer
{
	public static void main(String[] args)
	
	{
		Scanner sc=new Scanner(System.in);
		String a,b;
		a=sc.next();
		b=sc.next();
		if(a.length()>10&&b.length()>10)
			System.exit(0);
		int n;
		n=sc.nextInt();
		if(n>=1&&n<=1000)
		{
			
			System.out.println(a+" "+b);
			for(int i=0;i<n;i++)
			{
			     String c,d;
				 c=sc.next();
				 d=sc.next();
				 if(a.equals(c))
				 {
					 System.out.println(b+" "+d);
					 a=b;
					 b=d;
				 }
				 else if(a.equals(d))
				 {
					 System.out.println(b+" "+c);
					 a=b;b=c;
				 }
				 else if(b.equals(c))
				 {
					 System.out.println(a+" "+d);
					 a=a;
					 b=d;
				 }else if(b.equals(d))
				 {
					 System.out.println(a+" "+c);
					 a=a;b=c;
				 }
			}
		}           					 
	}
}

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int hr=a;
		int extra=0;
		int mod=0;
		while(a>=b)
		{
			extra=a/b;
			hr+=extra;
			mod=a%b;
			a=extra+mod;
		}
		System.out.println(hr);
	}
}
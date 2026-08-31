import java.util.*;
import java.io.*;
 
public class CodeForces
{
	public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
		//Scanner sc=new Scanner(new File("ip.txt"));
		int n,i,z=0;

		n=sc.nextInt();
		String s=sc.next();

		for(i=0;i<n;i++)
			if(s.charAt(i)=='0')
				z++;

		if(z!=n-z)
		{
			System.out.println(1);
			System.out.println(s);
		}
		else
		{
			System.out.println(2);
			System.out.println(s.charAt(0)+" "+s.substring(1));
		}
	}
}
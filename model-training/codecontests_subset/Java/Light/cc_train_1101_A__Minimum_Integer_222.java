import java.util.*;
import java.io.*;

public class CodeForces
{
	public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
		//Scanner sc=new Scanner(new File("ip.txt"));
		
		int n,l,r,d,i;

		n=sc.nextInt();

		for(i=0;i<n;i++)
		{
			l=sc.nextInt();
			r=sc.nextInt();
			d=sc.nextInt();
			System.out.println(fun(l,r,d));
		}
	}
	public static int fun(int l,int r,int d)
	{
		int p=(l/d);
		int q=(r/d);

		if(p>1||(p*d!=l&&p==1))
			return d;
		else
			return (q+1)*d;
		
	}
}
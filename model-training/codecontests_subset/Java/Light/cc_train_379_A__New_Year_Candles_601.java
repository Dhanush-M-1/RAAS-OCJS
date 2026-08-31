//package abcdes;
import java.util.Scanner;

public class Solution
{	
	public static void main(String[] args)
	{
		Scanner x=new Scanner(System.in);
		boolean h=true;
		long a,b,ans=0,y,z=0,c;
		a=x.nextLong();
		b=x.nextLong();
		c=a;
		while(h)
		{
			if(a<=0)
				break;
			ans+=a;
			a+=z;
			y=a/b;
			z=a%b;
			a=y;
		}
		System.out.println(ans);
		
		
		
	}
}

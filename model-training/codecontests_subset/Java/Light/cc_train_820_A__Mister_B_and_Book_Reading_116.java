import java.util.*;
import java.lang.*;
import java.io.*;
/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int c=scan.nextInt(),a0=scan.nextInt(),a1=scan.nextInt(),v=scan.nextInt(),l=scan.nextInt();
		int days=0,page=0;
		boolean finish=false;
		while(!finish)
		{
			if(a0+(v*days)<=a1)
			{
				page+=a0+(v*days);
			}
			else
				page+=a1;
			if(days!=0)	
				page-=l;
			days++;
			if(page>=c)
			{
				System.out.println(days);
				break;
			}
		}
	}
}
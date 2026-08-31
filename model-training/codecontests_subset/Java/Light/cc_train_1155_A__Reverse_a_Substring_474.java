import java.util.*;
import java.io.*;
public class srx2
{
	public static void main(String args[])throws IOException
	{	
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		String s=sc.nextLine();
		char c[]=s.toCharArray();
		int i=1;
		for(i=1;i<c.length;i++)
		{
			if((c[i]-c[i-1])<0)
				break;
		}
		if(i==c.length)
			System.out.println("NO");
		else
		{
			System.out.println("YES");
			System.out.println((i)+" "+(i+1));
		}
	}
}

import java.io.*;
import java.util.*;

public class cf5
{
	public static void main(String args[])

	{

		Scanner s=new Scanner(System.in);

		String str=s.next();

		int n=s.nextInt();

		String a[]=new String[n]; 

		for(int i=0;i<n;i++)
		{

			a[i]=s.next();


		}
String ans="";

		for(int i=0;i<n;i++)

			for(int j=0;j<n;j++ )
			{

				ans=ans+a[i]+a[j];

				if(ans.contains(str))
				{
					System.out.println("YES");
					System.exit(0);
				}

				else
				{
					ans="";
				}



			}

			System.out.println("NO");

		


	}
}
import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String [] Args)
	{
		Scanner in=new Scanner(System.in);		
		int a=in.nextInt();
		int b=in.nextInt();
		int ans=a*b;
		if(a>9||b>9)
		{
			ans=-1;
		}
		System.out.println(ans);
	}
}
	
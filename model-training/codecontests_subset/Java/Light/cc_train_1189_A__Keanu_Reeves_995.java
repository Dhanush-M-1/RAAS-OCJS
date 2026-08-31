//package hello;
import java.util.*;
public class keanuReeves 
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		String text = "";
		while(text.length()==0)
		text=scan.nextLine();
		int cnt=0;
		for(int i=0;i<n;i++)
		{
			if(text.charAt(i)=='1')cnt++;
		}
		if(2*cnt==n)
		{
			System.out.println(2);
			System.out.println(text.charAt(0)+" " +text.substring(1));
		}
		else
		{
			System.out.println(1);
			System.out.println(text);
		}
	}
}

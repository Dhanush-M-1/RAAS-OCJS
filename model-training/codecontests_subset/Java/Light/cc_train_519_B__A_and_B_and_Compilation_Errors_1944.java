import java.util.*;
public class Next
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int first=0,sec=0,third=0,n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			first+=sc.nextInt();
		}
		for(int i=0;i<n-1;i++)
		{
			sec+=sc.nextInt();
		}
		for(int i=0;i<n-2;i++)
		{
			third+=sc.nextInt();
		}
		System.out.println(first-sec);
		System.out.println(sec-third);
	}
}
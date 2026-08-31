import java.util.Scanner;

public class pr1
{
	public static void main(String xx[])
	{
		Scanner sc=new Scanner(System.in);
		int n;
		String s;
		n=sc.nextInt();
		s=sc.next();
		int i,oct=0;
		if(s.length()%2!=0)
		{
			System.out.println("1");
			System.out.println(s);
		}
		else
		{
			for(i=0;i<s.length();i++)
			{
				if(String.valueOf(s.charAt(i)).equals("1"))
				{
					oct++;
				}
			}
			if(oct!=(n-oct))
			{
				System.out.println("1");
				System.out.println(s);
			}
			else
			{
				System.out.println("2");
				if(s.length()<=3)
				{
					System.out.println(s.charAt(0)+" "+s.charAt(1));
				}
				else
				{
					System.out.println(s.substring(0,3)+" "+s.substring(3,s.length()));					
				}
			}			
		}
	}
}

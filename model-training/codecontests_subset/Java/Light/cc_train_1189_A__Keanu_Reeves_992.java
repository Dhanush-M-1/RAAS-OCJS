import java.util.*;
final public class KeanuReeves
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		String a=s.next();
		int one=0,zero=0;
		for(int i=0;i<a.length();i++)
			if(a.charAt(i)=='1')
				one++;
		zero=a.length()-one;
		if(zero==one)
		{
			System.out.println("2");
			System.out.print(a.charAt(0)+" "+a.substring(1,a.length()));
		}
		else
		{
			System.out.println("1");
			System.out.println(a);
		}
		s.close();
	}
}
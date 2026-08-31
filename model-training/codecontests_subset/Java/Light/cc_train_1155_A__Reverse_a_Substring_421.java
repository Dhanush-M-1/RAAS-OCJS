import java.util.*;
public class a
{
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.next();
		for(int i=0;i<s.length()-1;i++)
		{
			if(s.charAt(i)>s.charAt(i+1))
			{
				System.out.println("YES");
				System.out.println((i+1)+" "+(i+2));
				return;
			}
		}
		System.out.println("NO");

	}	
}
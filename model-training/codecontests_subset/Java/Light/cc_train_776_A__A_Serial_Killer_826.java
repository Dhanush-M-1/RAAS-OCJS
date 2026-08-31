import java.util.Scanner;

public class Dress
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String s[] = new String[2];
		s[0] = sc.next();
		s[1] = sc.next();
		int n = sc.nextInt();
		String ans[] = new String[n+1];
		ans[0] = s[0]+" "+s[1];
		for(int i=1; i<=n; i++)
		{
			String a = sc.next();
			String b = sc.next();
			if(a.compareTo(s[0]) == 0)
			{
				s[0] = b;
			}
			else
				s[1] = b;
			ans[i] = s[0] + " "+ s[1];
		}
		for(int i=0; i<=n; i++)
			System.out.println(ans[i]);
		
		sc.close();
	}
	    
}

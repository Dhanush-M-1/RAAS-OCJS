import java.util.*;
import java.util.Scanner;
public class Salamander
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int flag=0;
		int n = s.nextInt();
		String str1[] = new String[n];
		for(int i=0;i<n;i++)
		{	str1[i] = s.next();
		}
		//System.out.println(str+str1[0]);
		outer:
		for(int i=0;i<n;i++)
		{
			if(str1[i].equals(str))
			{
				System.out.println("YES");
				flag=1;
				break;
			}
			else if(str1[i].charAt(1)==str.charAt(0))
			{
				for(int j=0;j<n;j++)
				{	if(str1[j].charAt(0)==str.charAt(1))
					{	System.out.println("YES");
						flag=1; break outer;
					}
				}
			}
		}
		if(flag==0)
		System.out.println("NO");
	}
}
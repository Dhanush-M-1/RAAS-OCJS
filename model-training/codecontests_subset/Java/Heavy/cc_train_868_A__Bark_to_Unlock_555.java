
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Row2 
{
	
	public static void main(String[] args) 
	{
		Scanner jk = new Scanner(System.in);
		String[] po = jk.nextLine().split("");
		int x = jk.nextInt();
		jk.nextLine();
		int ans = 0;
		ArrayList<String[]> ins = new ArrayList<String[]>();
		for (int i=0; i<x; i++)
		{
			String[] ko = jk.nextLine().split("");
			ins.add(ko);
		}
		for (String[] ko:ins)
		{
			if (ko[1].compareTo(po[0])==0)
			{
				//System.out.println("Yed");
				ans++;
			}
		}
		if (ans==0)
		{
			ans-=100;
		}
		int tri = 0;
		for (String[] ko:ins)
		{
			if (ko[0].compareTo(po[1])==0)
			{
				tri+=1;
				ans++;
			}
		}
		if (tri==0)
		{
			ans-=100;
		}
		for (String[] ko:ins)
		{
			if (ko[0].compareTo(po[0])==0 && ko[1].compareTo(po[1])==0)
			{
				ans+=900;
			}
		}
		if (ans>=2)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}
}
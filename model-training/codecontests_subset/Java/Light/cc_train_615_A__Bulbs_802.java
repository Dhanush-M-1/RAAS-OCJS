import java.util.*;
import java.io.*;

public class Bulb
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.nextLine();
		boolean[] a = new boolean[m];
		int temp;
		for(int i=0;i<n;i++)
		{
			int x = in.nextInt();
			for(int j=0;j<x;j++)
			{
				temp = in.nextInt();
				a[temp-1] = true;
			}
			in.nextLine();
		}
		
		boolean flag = true;
		
		for(int i=0;i<m;i++)
		{
			if(a[i]==false)
			{
				flag = false;
				break;
			}
		}
		if(flag==true)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
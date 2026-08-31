//package cow17;
/*
LANG: JAVA
TASK: 
*/

import java.io.*;
import java.util.*;
public class cf
{
	public static void main(String[] args) throws IOException
	{
		Scanner c = new Scanner(System.in);
		int N = c.nextInt();
		int spec = 3;
		for(int i=0; i<N; i++)
		{
			int a = c.nextInt();
			if(a==spec)
			{
				System.out.println("NO"); return;
			}
			spec = (6-spec)-a;
		}
		System.out.println("YES");
	}
}

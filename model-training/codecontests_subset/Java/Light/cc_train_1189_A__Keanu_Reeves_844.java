import java.util.*;
import java.io.*;

public class a
{
	int n, k = 1;
	String s;
	
	a(Scanner in, PrintWriter out)
	{
		n = in.nextInt();
		s = in.next();
		int o = 0, z = 0;
		for (int i = 0; i < n; i++)
		{
			if (s.charAt(i) == '0') z++;
			else o++;
		}
		
		if (o == z)
		{
			k++;
			out.println(k);
			out.println(s.substring(0, 1)+" "+s.substring(1));
		}
		
		else
		{
			out.println(k);
			out.println(s);
		}
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		new a(in, out);
		out.close();
	}
}
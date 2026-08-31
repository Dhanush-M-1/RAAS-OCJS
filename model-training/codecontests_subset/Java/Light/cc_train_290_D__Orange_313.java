import java.io.*;
import java.util.*;

public class Orange
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int n = in.nextInt();
		s = s.toLowerCase();
		String output = "";
		for (int k = 0; k < s.length(); ++k)
		{
			char a = s.charAt(k);
			if (a < n+97)
				output += (char)(a+65-97);
			else
				output += a;
		}
		System.out.println(output);
	}
}
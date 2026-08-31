import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ProjectI 
{
	private static String compare(String s)
	{
		int n = s.length();
		if (n % 2 == 1)
			return s;

		String sub1 = compare(s.substring(0, n / 2));
		String sub2 = compare(s.substring(n / 2));

		if (sub2.compareTo(sub1) < 0)
			return sub2 + sub1;
		return sub1 + sub2;
	}
	public static void main(String[] holaMundo) throws IOException 
	{
		BufferedReader isr = new BufferedReader(new InputStreamReader(System.in));
		PrintStream bos = new PrintStream(new BufferedOutputStream(System.out));
		String sA = isr.readLine();
		String sB = isr.readLine();
		bos.println(compare(sA).equals(compare(sB))?"YES":"NO");
		isr.close();
		bos.close();
	}

}
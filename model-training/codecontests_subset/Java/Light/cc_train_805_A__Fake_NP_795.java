import java.util.*;
import java.io.*;
import java.util.regex.*;


public class Main
{
	public static void main(String[] args)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int l = scan.nextInt();
		int r = scan.nextInt();

		System.out.println(l == r ? l : 2);
	}
}
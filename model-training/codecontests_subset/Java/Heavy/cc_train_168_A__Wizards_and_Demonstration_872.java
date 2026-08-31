import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class A
{
	BufferedReader in;
	PrintStream out;
	StringTokenizer tok;
	public A() throws NumberFormatException, IOException
	{
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("in.txt"));
		out = System.out;
		run();
	}
	void run() throws NumberFormatException, IOException
	{
		int n = nextInt();
		int x = nextInt();
		int y = nextInt();
		int c = (y*n-x*100)/100;
		if(c>=0 && c*100<(y*n-x*100))c++;
		out.println(Math.max(c,0));
	}
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		new A();
	}
	String nextToken() throws IOException
	{
		if(tok ==null || !tok.hasMoreTokens()) tok = new StringTokenizer(in.readLine());
		return tok.nextToken();
	}
	int nextInt() throws NumberFormatException, IOException
	{
		return Integer.parseInt(nextToken());
	}
	long nextLong() throws NumberFormatException, IOException
	{
		return Long.parseLong(nextToken());
	}
	double nextDouble() throws NumberFormatException, IOException
	{
		return Double.parseDouble(nextToken());
	}
}
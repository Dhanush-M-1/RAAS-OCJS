import java.io.*;
import java.util.*;

public class equation {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter out;
	public static boolean isquadratic(int a, int b, int c)	{
		if (a != 0)
			return true;
		return false;
		}
	public static long determinant(int a, int b, int c)	{
		return (long)(b)*(long)(b)-4*(long)(a)*(long)(c);
		}
	public static boolean islinear(int a, int b, int c)	{
		if (a == 0 && b != 0)
			return true;
		return false;
		}
	public static void main(String[] args) throws IOException {
		InputStream input = System.in;
		//InputStream input = new FileInputStream("fileIn.in");
		OutputStream output = System.out;
		//OutputStream output = new FileOutputStream("fileOut.out");
		br = new BufferedReader(new InputStreamReader(input));
		out = new PrintWriter(output);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		if (isquadratic(a,b,c))
			{
			if (determinant(a,b,c) > 0)
				{
				out.println(2);
				if (a > 0)
					{
					out.println((-b-Math.sqrt(determinant(a,b,c)))/(2*a));
					out.println((-b+Math.sqrt(determinant(a,b,c)))/(2*a));
					}
				if (a < 0)
					{
					out.println((-b+Math.sqrt(determinant(a,b,c)))/(2*a));
					out.println((-b-Math.sqrt(determinant(a,b,c)))/(2*a));
					}
				}
			if (determinant(a,b,c) == 0)
				{
				out.println(1);
				out.println((float)(-b)/(2*a));
				}
			if (determinant(a,b,c) < 0)
				out.println(0);
			}
		else if (islinear(a,b,c))
			{
			out.println(1);
			out.println((float)(-c)/b);
			}
		else
			{
			if (c == 0)
				out.println(-1);
			else
				out.println(0);
			}
		out.close();
	}
}

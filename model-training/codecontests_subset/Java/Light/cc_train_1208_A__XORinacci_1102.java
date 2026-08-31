import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class contest1 {
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		for(int i=0;i<t;i++)
		{
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		if(n%3 == 0)
			out.println(a);
		else if(n%3 == 1)
			out.println(b);
		else
			out.println(a^b);
		}	
		
		out.flush();
		out.close();
	}
	
}

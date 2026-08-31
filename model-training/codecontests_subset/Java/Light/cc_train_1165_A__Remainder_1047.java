import java.io.*;
import java.util.*;
public class Remainder2
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		String st = sc.next();
		int cnt = 0;
		int f = 0;
		for(int i = n - 1 ; i >= (n - x) ; i--)
		{
			if((cnt == y && st.charAt(i) == '0') || (cnt != y && st.charAt(i) == '1'))
			{
				f++;
			}
			cnt++;
/*			else if(cnt != y && st.charAt(i) == '1')
			{
				
			}*/
		}
		pw.println(f);
		pw.flush();
	}
}

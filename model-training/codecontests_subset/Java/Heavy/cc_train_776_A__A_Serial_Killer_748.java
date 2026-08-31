import java.io.*;
import java.util.*;
public class cf776A
{
	public static void main(String[] ar)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String[] s = br.readLine().split(" ");
		out.println(s[0]+" "+s[1]);
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
		{
			String[] str = br.readLine().split(" ");
			if(s[0].equals(str[0]))
				s[0]=str[1];
			else
				if(s[0].equals(str[1]))
					s[0]=str[0];
			else
				if(s[1].equals(str[0]))
					s[1]=str[1];
			else
				s[1]=str[0];
			out.println(s[0]+" "+s[1]);
		}
		out.flush();
	}
}

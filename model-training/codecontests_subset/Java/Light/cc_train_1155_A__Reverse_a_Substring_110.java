import java.io.*;

public class reverseSub
{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int I = isAlpha(s);
		if(I > 0)
		{
			System.out.println("YES");
			System.out.println(I + " " + (I+1));
			
		}
		else {
			System.out.println("NO");
		}

	}
	public static int isAlpha(String s)
	{
		for(int i = 1; i < s.length(); i++)
		{
			if(s.charAt(i) < s.charAt(i-1))
			{
				return i;
			}
		}
		return -1;
	}
}
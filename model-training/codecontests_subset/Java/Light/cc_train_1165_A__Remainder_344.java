import java.util.*;
import java.io.*;

public class CF1165A
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		int count = 0;
		for(int i = n-1; i >= n-x; i--)
		{
			if(i == n-y-1)
			{
				if(s.charAt(i) != '1') count++;
			}
			else
			{
				if(s.charAt(i) != '0') count++;
			}
		}
		System.out.println(count);
	}
}
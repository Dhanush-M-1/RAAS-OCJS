import java.util.*;
import java.io.*;

public class CF1155A
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int max = (int) s.charAt(0) - 97;
		int index = 0;
		int flag = 0;
		for(int i = 1; i < n; i++)
		{
			int value = (int) s.charAt(i) - 97;
			if(max > value)
			{
				flag = 1;
				System.out.println("YES");
				index++;
				i++;
				System.out.println(index+" "+i);
				break;
			}
			else
			{
				max = value;
				index = i;
			}
		}
		if(index == n-1 && flag == 0) System.out.println("NO");
	}
}
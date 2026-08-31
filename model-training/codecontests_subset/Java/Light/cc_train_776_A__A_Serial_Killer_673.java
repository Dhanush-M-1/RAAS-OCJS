import java.util.*;
import java.io.*;

public class SerialKiller
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = new String[2];
		s = br.readLine().split(" ");
		String t = br.readLine();
		int n = Integer.parseInt(t);
		System.out.println(s[0] + " " +s[1]);
		String[] temp = new String[2];
		for(int i=0;i<n;i++)
		{
			temp = br.readLine().split(" ");
			if(temp[0].equals(s[0]))
				s[0]=temp[1];
			
			else if(temp[0].equals(s[1]))
				s[1] = temp[1];
			
			System.out.println(s[0] + " " + s[1]);
		}
	}
}

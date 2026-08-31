import java.util.*;
import java.io.*;

public class mbbr
{
	public static void main(String args[])throws IOException
	{
		try
		{
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader bf = new BufferedReader(is);
			
			String tokens[] = new String[5];
			tokens = bf.readLine().split(" ");
			
			int c = Integer.parseInt(tokens[0]);
			int v0 = Integer.parseInt(tokens[1]);
			int v1 = Integer.parseInt(tokens[2]);
			int a = Integer.parseInt(tokens[3]);
			int l = Integer.parseInt(tokens[4]);
			
			int track=v0;
			int days=1;
			int inc=v0;
			while(track<c)
			{
				inc = inc+a;
				if(inc>v1)
					inc = v1;
				
				
				track = track+inc-l;
				
				days++;
			}
			System.out.println(days);
		}
		catch(Exception e)
		{
			return;
		}
	}
}
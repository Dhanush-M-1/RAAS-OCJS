import java.io.*;
import java.util.*;

public class BearAndRaspberry
{
	public static void main(String[] args) throws IOException
	{
		InputStreamReader istr = new InputStreamReader(System.in);
		BufferedReader bufRead = new BufferedReader(istr);
 		
 		int max = Integer.MIN_VALUE;
		String line = bufRead.readLine();
		StringTokenizer st = new StringTokenizer(line," ");
		int n = Integer.parseInt(st.nextElement().toString());
		int c = Integer.parseInt(st.nextElement().toString());
		int a[] = new int[n];
		String line2 = bufRead.readLine();
		StringTokenizer st2 = new StringTokenizer(line2," ");
		for(int i=0;i<n;i++)
		{
			a[i] = Integer.parseInt(st2.nextElement().toString());
		}
		int diff = 0;
		int index = 0;

		for(int i=0;i<n-1;i++)
		{
			diff = a[i] - a[i+1];
			if(diff > max)
			{
				max = diff;
				index = i;
			}
		}
		int answer = a[index] - a[index+1] - c;
		if(answer<0)
			System.out.println("0");
		else
			System.out.println(answer);
	}
}
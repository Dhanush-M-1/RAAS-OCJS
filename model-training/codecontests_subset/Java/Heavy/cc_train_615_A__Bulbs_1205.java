
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

 
public class temp {
	public static void main(String[] args) throws IOException
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int cases = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean [] bulb = new boolean [m+1];
		while(n-->0)
		{
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			for(int i =0;i<l;i++)
			{
				int b = Integer.parseInt(st.nextToken());
				bulb[b]=true;
			}			
		}
		boolean yes = true;
		for(int i =1;i<m+1;i++)
		{
			if(!bulb[i])
			{
				yes = false;
				break;
			}
		}
		System.out.println((yes)?"YES":"NO");
	}
}
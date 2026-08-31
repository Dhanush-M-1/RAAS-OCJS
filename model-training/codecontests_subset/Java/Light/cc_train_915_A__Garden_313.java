import java.util.*;
import java.io.*;
public class garden
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader f=new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader f=new BufferedReader(new FileReader("garden.in"));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int num=Integer.parseInt(st.nextToken());
		int length=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(f.readLine());
		int min=1<<20;
		for(int x=0;x<num;x++)
		{
			int temp=Integer.parseInt(st.nextToken());
			if(length%temp==0)
				min=Math.min(min,length/temp);
		}
		System.out.println(min);
	}
}
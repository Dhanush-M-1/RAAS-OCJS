import java.util.*;
import java.io.*;
public class Game_of_Robots
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader f=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int[] arr=new int[a];
		st=new StringTokenizer(f.readLine());
		for(int x=0;x<a;x++)
			arr[x]=Integer.parseInt(st.nextToken());
		for(int x=0;x<a;x++)
		{
			long temp=(long)(x+1)*(x+2)/2;
			if(temp>=b)
			{
				long move=temp-b;
				System.out.println(arr[x-(int)move]);
				break;
			}
		}
	}
}
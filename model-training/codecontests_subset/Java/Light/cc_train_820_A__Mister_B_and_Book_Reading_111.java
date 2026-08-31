import java.util.*;
import java.io.*;
public class Mister_B_and_Book_Reading
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader f=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int length=Integer.parseInt(st.nextToken());
		int start_speed=Integer.parseInt(st.nextToken());
		int max_speed=Integer.parseInt(st.nextToken());
		int accel=Integer.parseInt(st.nextToken());
		int reread=Integer.parseInt(st.nextToken());
		int counter=0;
		int speed=start_speed;
		int days=0;
		while(counter<length)
		{
			counter+=speed;
			speed+=accel;
			speed=Math.min(speed,max_speed);
			if(counter<length)
				counter-=reread;
			days++;
		}
		System.out.println(days);
	}
}
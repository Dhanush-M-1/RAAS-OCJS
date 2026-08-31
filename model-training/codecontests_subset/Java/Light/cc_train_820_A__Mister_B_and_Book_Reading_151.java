import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testtest1
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String string = reader.readLine();
		
		String strings[] = string.split(" ");
		
		long pages = Long.parseLong(strings[0]);
		long minspeed = Long.parseLong(strings[1]);
		long maxspeed = Long.parseLong(strings[2]);
		long acceleration = Long.parseLong(strings[3]);
		long reread = Long.parseLong(strings[4]);
		
		long pagesread = 0;
		long days = 0;
		
		while(true)
		{
			long todaySpeed = minspeed+(acceleration*days);
			
			if(todaySpeed<minspeed)
			{
				todaySpeed = minspeed;
			}
			else if(todaySpeed>maxspeed)
			{
				todaySpeed = maxspeed;
			}
			
			if(days>0)
			{
				todaySpeed -= reread;
			}
			
			pagesread+=todaySpeed;

			days+=1;
			
			if(pagesread>=pages)
			{
				break;
			}
		}
		
		System.out.println(days);
	}
}
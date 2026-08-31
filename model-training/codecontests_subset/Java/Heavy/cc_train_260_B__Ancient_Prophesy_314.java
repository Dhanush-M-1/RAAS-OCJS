import java.util.*;
import java.io.*;
public class AncientProphesy
{
	public static final int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String line = in.next();
		
		int[][][] dates = new int[32][13][4];
		
		for(int x = 0; x <= line.length() - 10; x++)
		{
			int[] date = getDate(line.substring(x, x + 10));
			
			if(date[0] != -1)
			{
				dates[date[0]][date[1]][date[2]]++;
			}
		}
		
		int[] best = new int[3];
		Arrays.fill(best, -1);
		int max = 0;
		for(int y = 0; y < dates.length; y++)
		{
			for(int z = 0; z < dates[0].length; z++)
			{
				for(int a = 0; a < dates[0][0].length; a++)
				{
					if(dates[y][z][a] > max)
					{
						max = dates[y][z][a];
						best[0] = y;
						best[1] = z;
						best[2] = a;
					}
				}
			}
		}
		
		System.out.printf("%02d-%02d-%d\n", best[0], best[1], best[2] + 2012);
	}
	
	public static int[] getDate(String line)
	{
		int[] ret = new int[3];
		
		if(line.charAt(2) == '-' && line.charAt(5) == '-')
		{
			try
			{
				ret[0] = Integer.parseInt(line.substring(0, 2));
				ret[1] = Integer.parseInt(line.substring(3, 5));
				ret[2] = Integer.parseInt(line.substring(6));
				ret[2] -= 2012;
				
				if(ret[1] >= 1 && ret[1] <= 12 && ret[0] >= 1 && ret[0] <= months[ret[1] - 1] && ret[2] >= 1 && ret[2] <= 3)
				{
					return ret;
				}
			}
			catch(NumberFormatException ex)
			{
				
			}
		}
		
		Arrays.fill(ret, -1);
		return ret;
	}
}

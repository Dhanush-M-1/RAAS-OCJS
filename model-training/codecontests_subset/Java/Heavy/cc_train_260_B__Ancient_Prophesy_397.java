import java.io.*;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter w = new PrintWriter(System.out);
		
		Map<String, Integer> l = new HashMap<String, Integer>();
		
		String line = reader.readLine();
		
		String key = "";
		int counts = 0;
		
		for(int i = 0; i <= line.length() - 10; i++)
		{
			String[] dt = new String[3];
			dt[0] = "";
			dt[1] = "";
			dt[2] = "";
			for(int j = 0; j < 10; j++)
			{
				if(j == 2 || j == 5)
				{
					if(line.charAt(i+j) != '-')
						break;
				}
				else if( j < 2 && line.charAt(i+j) >= '0' && line.charAt(i+j) <= '9')
				{
					dt[0] += line.charAt(i+j);
				}
				else if(j > 2 && j < 5 && line.charAt(i+j) >= '0' && line.charAt(i+j) <= '9')
				{
					dt[1] += line.charAt(i+j);
				}
				else if( j > 5 && line.charAt(i+j) >= '0' && line.charAt(i+j) <= '9')
				{
					dt[2] += line.charAt(i+j);
				}
				else
				{
					break;
				}
				if(j == 9)
				{
					i += 5;
					int day = Integer.parseInt(dt[0]);
					int month = Integer.parseInt(dt[1]);
					int year = Integer.parseInt(dt[2]);
					if(year >= 2013 && year <= 2015)
					{
						if(month >= 1 && month <= 12)
						{
							if((month <= 7 && month % 2 == 1) || (month > 7 && month %2 == 0))
							{
								if(day >= 1 && day <= 31)
								{
									String h = dt[0]+"-"+dt[1]+"-"+dt[2];
									if(l.containsKey(h))
										l.put(h, l.get(h)+1);
									else
										l.put(h, 1);
								}
							}
							else if( month == 2)
							{
								if(day >= 1 && day <= 28)
								{
									String h = dt[0]+"-"+dt[1]+"-"+dt[2];
									if(l.containsKey(h))
										l.put(h, l.get(h)+1);
									else
										l.put(h, 1);
								}
							}
							else if(day >= 1 && day <= 30)
							{
								String h = dt[0]+"-"+dt[1]+"-"+dt[2];
								if(l.containsKey(h))
									l.put(h, l.get(h)+1);
								else
									l.put(h, 1);
							}
						}
					}
					break;
				}
				
				
			}
		}
		for(String z : l.keySet())
		{
			if(counts <= l.get(z))
			{
				key = z;
				counts = l.get(z);
			}
		}
		
		w.print(key);
		w.flush();
	}

}
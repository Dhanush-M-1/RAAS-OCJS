import java.io.*;
import java.util.*;

public class HelpfulMath
{
	public static void main(String args[])
	{
		try
		{
			BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

			String line = cin.readLine();
			String construct = new String();
			int num1 = 0;
			int num2 = 0;
			int num3 = 0;

			for (int temp = 0;temp < line.length();temp++) 
			{
				if(line.charAt(temp) == '+')
				{
					continue;
				}
				else
				{
					if(line.charAt(temp) == '1')
					{
						num1++;
					}
					else if(line.charAt(temp) == '2')
					{
						num2++;
					}
					else if(line.charAt(temp) == '3')
					{
						num3++;
					}
				}	
			}

			for (int temp = 0;temp < num1;temp++) 
			{
				if(line.length()>1) 
				{
					construct = construct.concat("1+");	
				}
				else
					construct = construct.concat("1");
			}
			for (int temp = 0;temp < num2;temp++) 
			{
				if(line.length()>1) 
				{
					construct = construct.concat("2+");	
				}
				else
					construct = construct.concat("2");	
			}
			for (int temp = 0;temp < num3-1;temp++) 
			{
				construct = construct.concat("3+");	
			}
			if (num3 != 0) 
			{
				construct = construct.concat("3");	
			}

			construct = construct.substring(0,line.length());
			

			System.out.println(construct);
		}catch(IOException e){e.printStackTrace();}
	}
}
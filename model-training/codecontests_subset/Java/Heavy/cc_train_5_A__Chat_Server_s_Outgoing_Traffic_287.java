//package primaryTest;

import java.util.Scanner;

public class CF5A
{
	int count = 0;
	private void run(Scanner in)
	{
		int person = 0;
		
		while(in.hasNext())
		{
			String tmp = in.nextLine();
			
			if(tmp.charAt(0) == '+' )
			{
				person++;
			}
			else if(tmp.charAt(0) == '-')
			{
				person--;
			}
			else
			{
				count += check(tmp)* person;
			}
		}
		System.out.println(count);
	}
	
	private int check(String str)
	{
			int num = 0 ;
			boolean flag = false;
			
			for(int j = 0 ; j< str.length(); j++)
			{
				if(flag)
				{
					 num++;
				}
				else
				{
					if(str.charAt(j) == ':')
					{
						flag = true;
					}
				}
			}
			return num;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		CF5A solution = new CF5A();
		solution.run(in);
	}
}

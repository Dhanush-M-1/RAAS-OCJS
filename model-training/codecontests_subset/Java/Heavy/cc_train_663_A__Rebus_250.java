import java.util.*;
public class Rebus
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int pos = 0;
		int neg = 0;
		boolean current = true;
		boolean end = false;
		ArrayList<Boolean> types = new ArrayList<Boolean>();
		types.add(true);
		int n = -1;
		while(true)
		{
			String token = in.next();
			
			if(!end)
			{
				if(token.charAt(0) == '?')
				{
					if(current)
					{
						pos++;
					}
					else
					{
						neg++;
					}
				}
				else if(token.charAt(0) == '+')
				{
					current = true;
					types.add(true);
				}
				else if(token.charAt(0) == '-')
				{
					current = false;
					types.add(false);
				}
				else if(token.charAt(0) == '=')
				{
					end = true;
				}
			}
			else
			{
				n = Integer.parseInt(token);
				break;
			}
		}
		
		int[] result = new int[types.size()];
		int total = 0;
		for(int x = 0; x < types.size(); x++)
		{
			if(types.get(x))
			{
				total++;
			}
			else
			{
				total--;
			}
		}
		
		Arrays.fill(result, 1);
		for(int y = 0; y < types.size(); y++)
		{
			if(types.get(y))
			{
				if(total < n)
				{
					result[y] += Math.min(n - 1, n - total);
					total += result[y] - 1;
				}
			}
			else
			{
				if(total > n)
				{
					result[y] += Math.min(n - 1, total - n);
					total -= result[y] - 1;
				}
			}
		}
		
		if(total == n)
		{
			System.out.println("Possible");
			
			for(int y = 0; y < result.length; y++)
			{
				System.out.print(result[y]);
				
				if(y < result.length - 1)
				{
					if(types.get(y + 1))
					{
						System.out.print(" + ");
					}
					else
					{
						System.out.print(" - ");
					}
				}
			}
			
			System.out.println(" = " + n);
		}
		else
		{
			System.out.println("Impossible");
		}
	}
}

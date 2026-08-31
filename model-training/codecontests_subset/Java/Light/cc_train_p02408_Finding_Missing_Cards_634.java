
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		
		int n = stdIn.nextInt();
		
		boolean[] hantei = new boolean[52];
		Arrays.fill(hantei,false);
		
		String pattern;
		int number;
		
		for(int i=0;i<n;i++)
		{
			pattern = stdIn.next();
			number = stdIn.nextInt();
			
			if(pattern.equals("S"))
			{
				hantei[number-1] = true;
			}
			else if(pattern.equals("H"))
			{
				hantei[13+number-1] = true;
			}
			else if(pattern.equals("C"))
			{
				hantei[26+number-1] = true;
			}
			else
			{
				hantei[39+number-1] = true;
			}
			
		}
		
		for(int i=0;i<52;i++)
		{
			if(!hantei[i])
			{
				if(i<13)
				{
					System.out.println("S "+(i+1));
				}
				else if(i<26)
				{
					System.out.println("H "+(i-12));
				}
				else if(i<39)
				{
					System.out.println("C "+(i-25));
				}
				else
				{
					System.out.println("D "+(i-38));
				}
			}
		}
	}
}
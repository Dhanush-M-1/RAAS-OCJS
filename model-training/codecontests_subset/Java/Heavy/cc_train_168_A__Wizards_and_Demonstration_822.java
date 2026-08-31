import java.io.*;
import java.util.*;
import java.lang.*;

public class WizardsDemonstration
{
	public static int returnY(int n,int x,int y) 
	{	
		int calculateYValue = (int)Math.ceil((y*n)/100.0);
		//System.out.println(calculateYValue);
		int requiredNumberOfPeople = calculateYValue-x;
		if(requiredNumberOfPeople>=0)
			return requiredNumberOfPeople;
		return 0;
	}

	public static void main(String argz[])
	{
		try
		{
			int n,x,y;
			Scanner reader = new Scanner(System.in);
			n = reader.nextInt();
			x = reader.nextInt();
			y = reader.nextInt();

			if(n<1 || x>n || y > 10000)
				System.exit(0);
			
			System.out.println(returnY(n,x,y));
		}

		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
}

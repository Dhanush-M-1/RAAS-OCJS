import java.util.*;
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		while(stdIn.hasNext())
		{
			double a = stdIn.nextDouble();
			double l = stdIn.nextDouble();
			double x = stdIn.nextDouble();
			double s1 = a / 4 * Math.sqrt((a + 2 * l) * (2 * l - a));
			double maxS2 = 0;
			for(double i = 0.00001; i < 1.0; i += 0.00001)
			{
				double len1 = i * (l + x);
				double len2 = (1.0 - i) * (l + x);
				double s = (l + len1 + len2) / 2.0;
				if(s * (s - l) * (s - len1) * (s - len2) < 0)
				{
					continue;
				}
				else
				{
					double s2 = Math.sqrt(s * (s - l) * (s - len1) * (s - len2));
					if(maxS2 < s2)
					{
						maxS2 = s2;
					}
				}
			}
			System.out.printf("%6f\n", s1 + 2 * maxS2);
		}
	}
}
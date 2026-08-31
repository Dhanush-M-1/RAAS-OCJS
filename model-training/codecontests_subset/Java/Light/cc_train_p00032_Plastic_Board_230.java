import java.util.*;
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		int rectCount = 0;
		int diamondCount = 0;
		while(stdIn.hasNext())
		{
			String[] s = stdIn.next().split(",");
			int a = Integer.valueOf(s[0]);
			int b = Integer.valueOf(s[1]);
			int c = Integer.valueOf(s[2]);
			if(a * a + b * b == c * c)
			{
				++rectCount;
			}
			if(a == b)
			{
				++diamondCount;
			}
		}
		System.out.println(rectCount);
		System.out.println(diamondCount);
	}
}
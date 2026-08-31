import java.util.Scanner;

public class Thief
{
	public boolean good(int segments, String seg, int l)
	{
		int good = 0;
		int index;
		boolean isGood = false;

		if(segments < 4)
		{
			return false;
		}

		for (int i = 0; i < l; i++) 
		{
			index = i;
			while(!isGood && index < segments)
			{
				if(seg.charAt(index) == '*')
				{
					good ++;
					if(good == 5)
						isGood = true;
				}
				else
					good = 0;
				index = index + l;
			}
		}
		return isGood;
	}
	public static void main(String[] args)
	{
		int segments;
		boolean good = false;
		Scanner sc = new Scanner(System.in);
		segments = sc.nextInt();
		String seg = new String();
		seg = sc.next();
		Thief game = new Thief();
		int l = segments / 4;
		for (int i = 1; i <= l; i++)
		{
			if(game.good(segments, seg, i)) 
			{
				good = true;
				i = l+1;
			}
			else
			{
				good = false;
			}
		}
		if(good) 
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
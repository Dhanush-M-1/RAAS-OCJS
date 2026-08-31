import java.util.*;
public class Main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int d;
		char ch;
		int[] s = new int[66];
		for(int i = 0; i < n; i++){
			ch = input.next().charAt(0);
			d = input.nextInt();
			if (ch == 'S')s[d] = 1;
			if (ch == 'H')s[d+13] = 1;
			if (ch == 'C')s[d+26] = 1;
			if (ch == 'D')s[d+39] = 1;
		}
		for(int i = 1; i <= 52; i++)
		{
			if(s[i] == 0) 
			{
				if (i < 14)System.out.println("S " + i);
				else if (i < 27)System.out.println("H " + (i-13));
				else if (i < 40)System.out.println("C " + (i-26));
				else System.out.println("D " + (i-39));
			}
		}
	}
}
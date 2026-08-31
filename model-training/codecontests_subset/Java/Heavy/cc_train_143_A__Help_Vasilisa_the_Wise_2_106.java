import java.io.*;
import java.math.*;
import java.util.*;

public class Main 
{
	int[] r = new int[2];
	int[] c = new int[2];
	int[] d = new int[2];
	
	boolean check(int[] ans)
	{
		if(ans[2] + ans[3] != r[1]) return false;
		if(ans[1] + ans[3] != c[1]) return false;
		if(ans[1] + ans[2] != d[1]) return false;
		for(int i = 0; i < 4; i++)
		{
			for(int j = i + 1; j < 4; j++) if(ans[i] == ans[j]) return false;
		}
		for(int i = 0; i < 4; i++) if(ans[i] > 9 || ans[i] <= 0) return false;
		return true;
	}
	void run()
	{
		Scanner cin = new Scanner(System.in);
		for(int i = 0; i < 2; i++) r[i] = cin.nextInt();
		for(int i = 0; i < 2; i++) c[i] = cin.nextInt();
		for(int i = 0; i < 2; i++) d[i] = cin.nextInt();
		
		for(int i = 1; i <= 9; i++)
		{
			int[] ans = new int[4];
			ans[0] = i;
			ans[1] = r[0] - ans[0];
			ans[2] = c[0] - ans[0];
			ans[3] = d[0] - ans[0];
			if(check(ans))
			{
				for(int j = 0; j < 4; j++)
				{
					if(j != 0) System.out.print(' ');
					System.out.print(ans[j]);
				}
				System.out.println();
				return;
			}
			
			
			
		}
		System.out.println(-1);
	}
	
	public static void main(String[] args)
	{
		new Main().run();
	}

}

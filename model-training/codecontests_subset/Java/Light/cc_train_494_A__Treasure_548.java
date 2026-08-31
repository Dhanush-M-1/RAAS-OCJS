import java.util.*;
public class Treasure {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = s.length();
		int numo = 0;
		int numc = 0;
		int numh = 0;
		
		for(int i = 0; i < n; i ++)
		{
			if(s.charAt(i) == '#')
				numh++;
			else if(s.charAt(i) == ')')
				numc++;
			else
				numo++;
		}
		
		boolean possible = true;
		int[] ans = new int[numh];
		Arrays.fill(ans, 1);
		int need = numo - numc;

		need -= numh;
		ans[numh - 1] += need;
		
		if(need < 0)
			possible = false;
		
		int depth = 0;
		int index = 0;
		for(int i = 0; i < n; i ++)
		{
			if(s.charAt(i) == ')')
				depth--;
			else if(s.charAt(i) == '(')
				depth++;
			else
			{
				depth -= ans[index];
				index++;
			}
			if(depth<0)
			{
				possible = false;
				break;
			}
		}
		if(possible)
			for(int i = 0; i < numh; i ++)
				System.out.println(ans[i]);
		else
			System.out.println(-1);
	}
}

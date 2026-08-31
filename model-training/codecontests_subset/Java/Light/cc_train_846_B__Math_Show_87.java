
import java.util.Arrays;
import java.util.Scanner;

public class MathShow {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long t = sc.nextLong();
		long[] a = new long[k];
		long setcost = 0;
		
		for(int i = 0; i < k; i++)
		{
			a[i] = sc.nextLong();
			setcost += a[i];
		}
		Arrays.sort(a);
		
		long best = 0;
		
		for(int set = 0; set <= n; set++)
		{ //tasks to solve all subtasks of
			long score = (k+1)*set;
			if(setcost*set > t)break;
			long time = t - (setcost*set);
			
			int remset = n-set;
			for(int sub = 0; sub < k; sub++)
			{
				long solve = Math.min(time/a[sub], remset);
				time -= a[sub]*solve;
				score += solve;
				if(solve < 1 || time <= 0)break;
			}
			best = Math.max(best, score);
		}
		
		System.out.println(best);
	}

}

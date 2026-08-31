import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        /*int n = stdin.nextInt();
        for(int i = 0; i < n; i++)
        {
        	test(stdin);
        }*/
        test(stdin);
        stdin.close();
    }
    public static void test(Scanner stdin)
    {
    	int n = stdin.nextInt();
    	long[][] dp = new long[n][10];
    	long max[] = new long[3];
    	for(int i = 0; i< n; i++)
    	{
    		int m = stdin.nextInt();
    		PriorityQueue<Integer>[] list = new PriorityQueue[3];
    		for(int u = 0; u < 3; u++)
    		{
    			list[u] = new PriorityQueue(); 
    		}
    		for(int u = 0; u < m; u++)
    		{
    			list[stdin.nextInt() - 1].add(-stdin.nextInt());
    		}
    		long a31,a21,a22,a11,a12,a13;
    		if(list[2].isEmpty())
    		{
    			a31 = -1;
    		}
    		else {
        		a31 = -list[2].poll();
			}
    		if(list[1].isEmpty())
    		{
    			a21 = -1;
    		}
    		else {
        		a21 = -list[1].poll();
			}
    		if(list[1].isEmpty())
    		{
    			a22 = -1;
    		}
    		else {
        		a22 = -list[1].poll();
			}
    		if(list[0].isEmpty())
    		{
    			a11 = -1;
    		}
    		else {
        		a11 = -list[0].poll();
			}
    		if(list[0].isEmpty())
    		{
    			a12 = -1;
    		}
    		else {
        		a12 = -list[0].poll();
			}
    		if(list[0].isEmpty())
    		{
    			a13 = -1;
    		}
    		else {
        		a13 = -list[0].poll();
			}
    		max[0] = Math.max(a31, Math.max(a21, a11));
    		if(a21 > -1 && a11 > -1 && a12 > -1)
    		{
    			max[1] = Math.max(a11 + a12, a11 + a21);
    		}
    		else if(a21 > -1 && a11 > -1)
    		{
    			max[1] =a21 + a11;
    		}
    		else if(a11 > -1 && a12 > -1)
    		{
    			max[1] = a11 + a12;
    		}
    		else
    		{
    			max[1] = -1;
    		}
    		if(a11 > -1 && a12 > -1 && a13 > -1)
    		{
    			max[2] = a11 + a12 + a13;
    		}
    		else {
				max[2] = -1;
			}
    		for(int u = 0; u < 10; u++)
    		{
    			if(i == 0)
    			{
    				if(u < 3)
    				{
    					dp[i][u] = max[u];
    				}
    				else {
						dp[i][u]= -1;
					}
    			}
    			else {
    				if(u < 3)
    				{
    					dp[i][u] = Math.max(dp[i-1][u], max[u]);
    				}
    				else {
        				dp[i][u] = dp[i-1][u]; 
					}
					int pos1 = (u + 9)%10;
					int pos2 = (u + 8)%10;
					int pos3 = (u + 7)%10;
					if(dp[i-1][pos1] != -1 && max[0] != -1)
					{
						if(pos1 > 5 && pos1 < 9 && (u == 9 || u < 2))
						{
							dp[i][u] = Math.max(dp[i][u], dp[i-1][pos1] + max[0] + max[0]);
						}
						else {
							dp[i][u] = Math.max(dp[i][u], dp[i-1][pos1] + max[0]);
						}
					}
					if(dp[i-1][pos2] != -1 && max[1] != -1)
					{
						if(pos2 > 5 && pos2 < 9 && (u == 9 || u < 2))
						{
							dp[i][u] = Math.max(dp[i][u], dp[i-1][pos2] + max[1] + Math.max(a11, a21));
						}
						else {
							dp[i][u] = Math.max(dp[i][u], dp[i-1][pos2] + max[1]);
						}
					}
					if(dp[i-1][pos3] != -1 && max[2] != -1)
					{
						if(pos2 > 5 && pos3 < 9 && (u == 9 || u < 2))
						{
							dp[i][u] = Math.max(dp[i][u], dp[i-1][pos3] + max[2] + a11);
						}
						else {
							dp[i][u] = Math.max(dp[i][u], dp[i-1][pos3] + max[2]);
						}
					}
				}
    		}
    	}
    	long res = 0;
    	for(int u = 0; u < 10; u++)
		{
    		if(res < dp[n-1][u])
    		{
    			res = dp[n-1][u];
    		}
		}
    	System.out.println(res);
    }
}
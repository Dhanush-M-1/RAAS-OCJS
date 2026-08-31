import java.util.*;
public class Main
{
	static int tb[] = new int[400005];
	static int fnd(int x)
	{
		if (x != tb[x]) tb[x] = fnd(tb[x]);
		return tb[x];
	}
	static boolean mrg(int u, int v)
	{
		int f1 = fnd(u), f2 = fnd(v);
		if (f1 != f2)
		{
			tb[f2] = f1;
			return true;
		}
		return false;
	}
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
    	for(int i = 1; i <= n+m; i++)
    		tb[i] = i;
    	int ans = n+m-1;
    	for(int i = 0; i < q; i++)
    	{
    		int u = sc.nextInt(), v = sc.nextInt();
    		if (mrg(u, v+n)) ans--;
    	}
    	System.out.println(ans);
    }
}

	  		  	 				 				  		    		  	
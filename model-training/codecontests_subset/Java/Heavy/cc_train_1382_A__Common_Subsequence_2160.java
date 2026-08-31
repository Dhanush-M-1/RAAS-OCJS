import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t > 0)
        {
		    int i, j, k = 0, n = scan.nextInt(), m = scan.nextInt();
			int [] arr = new int[1001];
			for (i = 0; i < n; ++i)
			{
			j = scan.nextInt();
			arr[j]++;
			}
			for (i = 0; i < m; ++i)
			{
			j = scan.nextInt();
			if (arr[j] > 0)
			{
			k = Math.max(k, j);
			}
			}
			if (k == 0)
			{
			System.out.println("NO");
			}
			else
			{
			System.out.println("YES");
			System.out.println("1 " + k);
			}
            t--;
        }
    }
}
import java.util.*;
import java.math.*;
public class Remainder
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		char[] arr = sc.next().toCharArray();
		int out = 0;
		for(int i = n-x;i<n;i++)
		{
			if(i==n-y-1)
			{
				if(arr[i]!='1')
					out++;
			}
			else
			{
				if(arr[i]!='0')
					out++;
			}
		}
		System.out.println(out);
	}
}
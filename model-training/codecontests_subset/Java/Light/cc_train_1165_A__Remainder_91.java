
import java.util.*;
public class A{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		String s = scan.next();
		int count = 0;
		for(int i = n  - x;i < n;i++)
		{
			if(s.charAt(i) == '1')
				count++;
		}
		if(s.charAt(n - 1 - y) == '0')
			count++;
		else
			{
				count--;
			}
		System.out.println(count);
	}
}
import java.util.*;
public final class test
{
	
	public static void main(String []args)
	{
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int e = 0;
		for(int i=0;i<n;i++)
			if(s.charAt(i) == '8')
				e++;
		int sum = 0;
		while(true)
		{
			
			if(e == 0 || n < 11)
				break;
			sum++;
			e--;
			n = n-11;
			
		}
		System.out.println(sum);
		
	}
	
}
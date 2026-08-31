import java.util.*;
public class Problem_379A
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=0;
		int t=0;
		while(a>0)
		{
			c++;
			a--;
			if(c%b==0)
				a++;
			t++;
		}
		System.out.println(t);
	}
}
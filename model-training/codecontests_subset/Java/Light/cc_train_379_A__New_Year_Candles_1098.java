import java.util.*;
public class Lo
{
	static int doit(int a,int b)
	{
		int c=0;
		int sum=0;
		sum=a;
		while(a>=1)
		{
			c = a/b;
			a = c+(a%b);
			sum+=c;
			if(a<b) break;
		}
		
		return sum;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int a  = sc.nextInt();
		int b  = sc.nextInt();
		System.out.println(doit(a,b));
	}
}
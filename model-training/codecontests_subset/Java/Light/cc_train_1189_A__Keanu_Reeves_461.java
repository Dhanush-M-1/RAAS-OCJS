import java.util.*;
public class codeforcesContest {
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		String x=sc.next();
		int one=0,zero=0;
		for(int i=0;i<x.length();i++)
		{
			if(x.charAt(i)=='1')
			{
				one++;
			}
			else
				zero++;
		}
		if(one != zero)
		{
			System.out.println(1);
			System.out.println(x);
			return;
		}
		if(n%2==0)
		{
			System.out.println(2);
			System.out.println(x.substring(0,1) + " "+ x.substring(1));
		}
		
	}
 
}
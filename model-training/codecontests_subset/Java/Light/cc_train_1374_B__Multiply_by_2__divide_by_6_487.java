import java.util.*;

public class Codeforces
{
	//static int count=0;
	public static int check(int a,int count)
	{
		
		if(a==1)	return count;
		else if(a%6==0)
		{
			//count++;
			return check(a/6,count+1);
		}
		else if(a%3==0 && a%2!=0)
		{
			//count++;
			return check(a*2,count+1);
		}
		else	return -1;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			int a=sc.nextInt();
			int count=0;
			System.out.println(check(a,count));
		}
		sc.close();
	}
}
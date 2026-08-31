import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		String str=s.next();
		
		int[] zero=new int[n];
		int[] one=new int[n];
		
		for(int i=0;i<n;i++)
		{
			if(str.charAt(i)=='0')
			{
				if(i==0)
				{
					zero[i]=1;
				}
				else
				{
					zero[i]=zero[i-1]+1;
					one[i]=one[i-1];
				}
			}
			else
			{
				if(i==0)
				{
					one[i]=1;
				}
				else
				{
					one[i]=one[i-1]+1;
					zero[i]=zero[i-1];
				}
			}
		}
		
		int index=-1;
		
		for(int j=n-1;j>=0;j--)
		{
			if(zero[j]!=one[j]&&zero[n-1]-zero[j]!=one[n-1]-one[j])
			{
				index=j;
				break;
			}
		}
		
		if(n==1)
		{
			System.out.println(1);
			System.out.println(str);
		}
		else if(zero[n-1]!=one[n-1])
		{
			System.out.println(1);
			System.out.println(str);
		}
		else
		{
			System.out.println(2);
			System.out.println(str.substring(0,index+1)+" "+str.substring(index+1));
		}
		
	}
	
}
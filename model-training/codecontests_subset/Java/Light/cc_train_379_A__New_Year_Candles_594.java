import java.util.*;
public class Tester
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		int a=s.nextInt();
		int b=s.nextInt();
		int n=a;
		
		int count=0;
		int rem=0;
		int temp_a=-1;
		for(int i=0;;i++)
		{
			count=count+a/b;
			temp_a=(a/b);
			rem=rem+a%b;
			
			if(temp_a==0)
			{
				a=rem;
				rem=0;
			}
			else
				a=temp_a;
			
			if((a+rem)<b)
				break;
			
			//System.out.println(temp_a+" "+a+" "+count+" "+rem);
		}
		System.out.println(n+count);
		
		
	}
}

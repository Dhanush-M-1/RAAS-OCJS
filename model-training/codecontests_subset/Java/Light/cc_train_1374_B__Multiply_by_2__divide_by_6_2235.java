
import java.util.*;

public class Main {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) 
		{
			int n=sc.nextInt();
			long count=0;
			while(n!=1)
			{
				if(n%6==0)
					{
					n/=6;
					count++;
					}
				else if(n%3==0)
					{
					n*=2;
					count++;
					}
				else break;
			}
			if(n==1) System.out.println(count);
			else System.out.println(-1);
		}
		
		
	}
	
}



	   

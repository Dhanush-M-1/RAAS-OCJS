import java.util.*;
public class B34
{
	public static void main(String[] args)
	{
	  Scanner s=new Scanner(System.in);
	  int t=s.nextInt();
	  while(t>0)
	  {
		int ans=0;
		long n=s.nextInt();
		if(n<6)
		{
		  if(n==1)
		   System.out.println("0");
		  else if(n==3)
		  System.out.println("2");
		  else 
		  System.out.println("-1");
		}
		else
		{
		  while(n%3==0)
		  {
			//System.out.println(n);
			if(n%6==0)
			n=n/6;
			else
			n=n*2;
			ans++;
			
		  }
		 if(n==1)
		  System.out.println(ans);
		else
		System.out.println("-1");
		 
		}
		//System.out.println(ans);
		t--;
	  }
	}
}

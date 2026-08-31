import java.util.*;

public final class cont653A
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T>0)
		{
			int n=sc.nextInt();
			/*int y=sc.nextInt();
			int n=sc.nextInt();
			int rem=n%x;
			if(rem>=y)
				System.out.println(n-(rem-y));
			else
				System.out.println(n-(x-(y-rem)));
			*/
		    int cnt=0;		
		    while(n>=1)
		    {
		    	if(n%6==0)
		    	{
		    		n=n/6;
		    		cnt++;
		    	}
		    	else
		    		break;
		    }		

		    while(n>=1)
		    {
		    	if(n%3==0)
		    	{
		    		n=n/3;
		    		cnt=cnt+2;
		    	}
		    	else
		    		break;
		    }

		    if(n==1)
		    	System.out.println(cnt);
		    else
		    	System.out.println(-1);
			T--;
		}
	}
}
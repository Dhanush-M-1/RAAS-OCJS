import java.util.*;

public class A893 {
		
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt(), winner=-1, loser=-1, player=-1, w=-1;
		boolean flag=true;
		for(int i=0; i<n; i++)
		{
			if(i==0)
			{
				winner=sc.nextInt();
				if(winner!=1 && winner!=2)
				{
					flag=false;
					break;
				}
				else if(winner==1)
				{
					loser=2;
					w=1;
				}
				else
				{
					loser=1;
					w=2;
				}
				player=3;
			}
			else
			{
				winner=sc.nextInt();
				if(winner==loser)
				{
					flag=false;
					break;
				}
				else
				{
					if(winner==player)
					{
						int tmp=loser;
						loser=w;
						w=player;
						player=tmp;
					}
					else if(winner==w)
					{
						int tmp=loser;
						loser=player;
						player=tmp;
					}
				}
			}
			
			
		}
		if(flag)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
		
	}
}
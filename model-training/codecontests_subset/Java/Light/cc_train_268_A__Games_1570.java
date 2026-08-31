import java.util.HashMap;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner (System.in);
		int n=s.nextInt();
		int[] home=new int[n];
		int[] guest=new int[n];
		HashMap<Integer,Integer> guestteams=new HashMap<>();
		for(int i=0;i<(n);i++)
		{
			home[i]=s.nextInt();
			guest[i]=s.nextInt();
			if(guestteams.containsKey(guest[i]))
			{
				int x=guestteams.get(guest[i]);
				guestteams.put(guest[i],x+1);
			}
			else
			{
				guestteams.put(guest[i],1);
			}
		}
		int ans=0;
		for(int i=0;i<(n);i++)
		{
			int cc=home[i];
			if(guestteams.containsKey(cc))
			{
				int x=guestteams.get(cc);
				int guestclothes=guest[i];
				if(guestclothes==cc)
				{
					x--;
				}
				ans+=x;
			}
		}
		System.out.println(ans);
	}

}

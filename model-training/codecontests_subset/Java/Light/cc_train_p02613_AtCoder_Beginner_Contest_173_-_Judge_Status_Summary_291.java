import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] test=new String[n];
		for(int i=0;i<n;i++)test[i]=sc.next();
		int[] cnt={0,0,0,0};
		for(int i=0;i<n;i++)
		{
			switch(test[i])
			{
			case "AC":
				cnt[0]++;
				break;
			case "WA":
				cnt[1]++;
				break;
			case "TLE":
				cnt[2]++;
				break;
			case "RE":
				cnt[3]++;
				break;
			}
		}
		System.out.println("AC x "+cnt[0]);
		System.out.println("WA x "+cnt[1]);
		System.out.println("TLE x "+cnt[2]);
		System.out.println("RE x "+cnt[3]);
		sc.close();
	}
}

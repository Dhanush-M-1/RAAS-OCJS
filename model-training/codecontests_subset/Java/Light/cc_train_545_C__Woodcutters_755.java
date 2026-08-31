import java.util.Scanner;

public class WoodCutters {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		long n=sc.nextInt();
		long[] position=new long[(int) (n+1)];
		long[] height=new long[(int) (n+1)];
		for(int i=1;i<=n;i++)
		{
			position[i]=sc.nextInt();
			height[i]=sc.nextInt();
		}
		long answer=1;
		for(int i=2;i<=n-1;i++)
		{
			if(position[i-1]<position[i]-height[i])
				{
				answer++;
				continue;
				}
			if(position[i]+height[i]<position[i+1])
			{
				answer++;
				position[i]+=height[i];
			}
		}
		if(n>=2)
		System.out.println(answer+1);
		else
			System.out.println(answer);
	}
	
}

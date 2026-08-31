
import java.util.*;

public class Main {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int st[][]=new int[n][2];
		int flag[][]=new int[m][2];
		int ans[]=new int[m];
		
		for(int i=0;i<n;i++)
		{
			st[i][0]=sc.nextInt();
			st[i][1]=sc.nextInt();
		}
		for(int i=0;i<m;i++)
		{
			flag[i][0]=sc.nextInt();
			flag[i][1]=sc.nextInt();
		}
		int min;
		for(int i=0;i<n;i++)
		{
			min=1000000000;
			for(int j=0;j<m;j++)
			{
				ans[j]=Math.abs(st[i][0]-flag[j][0])+Math.abs(st[i][1]-flag[j][1]);
				min=Math.min(ans[j], min);
			}
			//System.out.println(Arrays.toString(ans));
			for(int j=0;j<m;j++)
			{
				if(ans[j]==min) 
					{
						System.out.println(j+1);
						break;
					
					}
			}
			
		}
		
		
		
		System.out.println();
	}
}

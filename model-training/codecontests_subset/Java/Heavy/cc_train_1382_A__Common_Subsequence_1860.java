import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		StringBuilder sb=new StringBuilder();
		
		int t=s.nextInt();
		
		for(int i=0;i<t;i++)
		{
			int n=s.nextInt();
			int m=s.nextInt();
			
			int[] arr=new int[n];
			int[] brr=new int[m];
			
			HashMap<Integer,Integer> map=new HashMap<>();
			
			int p=0;
			int num=-1;
			
			for(int j=0;j<n;j++)
			{
				arr[j]=s.nextInt();
				map.put(arr[j],1);
			}
			
			for(int j=0;j<m;j++)
			{
				brr[j]=s.nextInt();
				
				if(map.containsKey(brr[j]))
				{
					p=1;
					num=brr[j];
				}
			}
			
			if(p==0)
			{
				sb.append("NO\n");
			}
			else
			{
				sb.append("YES\n");
				sb.append("1 "+num+"\n");
			}
			
		}
		
		System.out.println(sb);
		
	}
	
}
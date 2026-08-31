import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		ArrayList<Integer>[] arr=new ArrayList[n+1];
		
		for(int i=0;i<=n;i++)
		{
			ArrayList<Integer> list=new ArrayList<>();
			arr[i]=list;
		}
		
		for(int i=0;i<n-1;i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			
			arr[a].add(b);
			arr[b].add(a);
			
		}
		
		int p=0;
		
		for(int i=1;i<=n;i++)
		{
			if(arr[i].size()==2)
			{
				p=1;
				break;
			}
		}
		
		if(p==1)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
	
}
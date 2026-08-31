import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		for(int i=0;i<t;i++)
		{
			int n=s.nextInt();
			
			int pp=0;
			int cc=0;
			
			int d=0;
			
			for(int j=0;j<n;j++)
			{
				int p=s.nextInt();
				int c=s.nextInt();
				
				if((p<c||p<pp)||c<cc||(pp-cc)>(p-c))
				{
					d=1;
				}
				
				pp=p;
				cc=c;
			}
			
			if(d==0)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
	}
	
}
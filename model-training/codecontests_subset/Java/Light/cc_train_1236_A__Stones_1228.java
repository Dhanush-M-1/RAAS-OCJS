import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		for(int i=0;i<t;i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			int c=s.nextInt();
			
			int ans=0;
			
			int take=Math.min(c/2, b);
			
			ans=ans+take*2;
			ans=ans+take;
			
			b=b-take;
			
			int take2=Math.min(b/2,a);
			
			ans=ans+take2*2;
			ans=ans+take2;
			
			System.out.println(ans);
			
		}
		
	}
	
}
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		int a=0;
		int w=0;
		int t=0;
		int r=0;
		
		for(int i=0;i<n;i++)
		{
			String str=s.next();
			
			if(str.charAt(0)=='A')
				a++;
			else if(str.charAt(0)=='W')
			{
				w++;
			}
			else if(str.charAt(0)=='T')
			{
				t++;
			}
			else
			{
				r++;
			}
		}
		
		System.out.println("AC x "+a);
		System.out.println("WA x "+w);
		System.out.println("TLE x "+t);
		System.out.println("RE x "+r);
		
	}	
	
}
import java.util.*;
public class MI
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int q=sc.nextInt();

		while(q-->0)
		{
			int f=0;
			long r1=sc.nextLong();
			long r2=sc.nextLong();
			long n=sc.nextLong();
			if(n<r1 || r2<n)
			System.out.println(n);			
			else
			{
			long t=r2%n;
			t=n-t;
			System.out.println(r2+t);
			}
		}
		

		
}
}

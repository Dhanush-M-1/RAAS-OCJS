import java.util.Scanner;

public class Codefour {

	public static void main(String[] args) {
		
		int n,i;
		int m;
		
		int a = 0 , b = 0 , c = 0;
		
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		
		for(i=0;i<n;i++)
		{
			m=in.nextInt();
			a+=m;
		}
		
		for(i=0;i<n-1;i++)
		{
			m=in.nextInt();
			b+=m;
		}
		
		for(i=0;i<n-2;i++)
		{
			m=in.nextInt();
			c+=m;
		}
		
		System.out.println(a-b);
		System.out.println(b-c);
		
		
	
		// TODO Auto-generated method stub

	}

}

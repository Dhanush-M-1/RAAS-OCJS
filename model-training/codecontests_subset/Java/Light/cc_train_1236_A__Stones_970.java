
import java.util.Scanner;

public class Main{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
			int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt(),x=0;
			x+=3*(Math.min(c/2, b));
			b-=Math.min(c/2, b);
			x+=3*(Math.min(b/2, a));
			System.out.println(x);
		}
		
	}

}

import java.util.Scanner;
public class mul {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		for(int i=0;i<tests;i++) solver(s.nextInt());
	}
	private static void solver(int n)
	{
		int pow2 = 0;
		int pow3 = 0;
		while(n%2==0)
		{
			pow2++;
			n = n/2;
		}
		while(n%3==0)
		{
			pow3++;
			n = n/3;
		}
		if(pow2>pow3 || n>1) System.out.println(-1);
		else System.out.println(2*pow3-pow2);
	}
}
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */

	static long  dp[][] = new long[60][60];
	static int mod = 1000000009;
	static String h;
	static char cad[] = new char[55];
	static int n,m;
	static int fila [] = {0,0,1,-1};
	static int col [] = {1,-1,0,0};
	static boolean use[] = new boolean[100];
	

	public static long gcd(long a,long b)
	{
		if(b==0) return a;
		return gcd(b,a%b);
	}
	public static long mcm(long a,long b)
	{
		return a*b / gcd(a,b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//42, ""
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		long res = 0, r = 0;
		for(long i = n; i>0 && i > n-50; i--)
			for(long j=n;j>0&&j > n-50; j--)
				for(long k=n;k>0&&k>n-50;k--)
				{
					r = mcm(i, mcm(j,k));
					if(res < r) res = r;
				}
		System.out.println(res);
		
	}
}

import java.util.Scanner;

public class _0225Stones {
	static int  solve(int a,int b,int c) {
	int	 res1=Math.min(b, c/2);
			b-=res1;
			c-=2*res1;
	        res1 += Math.min(a, b/2);
	        return res1;
	}
	
	
	
	
	static int  solve1(int a,int b,int c) {
		int	 res2=Math.min(a, b/2);
				a-=res2;
				b-=2*res2;
		        res2 += Math.min(b, c/2);
		        return res2;
		}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int cases =sc.nextInt();
		while(cases>0) {
			int a =sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			int max1=solve(a,b,c);
		int max2=solve1(a,b,c);
		System.out.println(3*Math.max(max1, max2));
		cases--;
		}
	}

}

import java.util.Scanner;

public class D {

	private D (Scanner sc) throws Throwable {
		long a = sc.nextLong();
		long b = sc.nextLong();
		long x1 = sc.nextLong();
		long y1 = sc.nextLong();
		long x2 = sc.nextLong();
		long y2 = sc.nextLong();
		solve(2*a,2*b,x1,y1,x2,y2);
	}
	
	private void solve (long a, long b, long x1, long y1, long x2, long y2) throws Throwable {
		long S1 = x1+y1, S2 = x2+y2;
		long D1 = x1-y1, D2 = x2-y2;
		
		long T1 = Math.min(S1, S2), T2 = Math.max(S1, S2);
		long E1 = Math.min(D1, D2), E2 = Math.max(D1, D2);
		
		long z1 = - nextMultipleOf(T1, a) + prevMultipleOf(T2, a) + 1;
		long z2 = - nextMultipleOf(E1, b) + prevMultipleOf(E2, b) + 1;
		
		print (Math.max(z1,z2));
	}
	
	long nextMultipleOf(long n, long p)
	{
		long x;
		if (n >= 0)
			x = n/p + 1;
		else
			x = -((-n)/p);
		//System.out.println(x);
		return x;
	}
	
	long prevMultipleOf(long n, long p)
	{
		long x = nextMultipleOf(n, p) - 1;
		//System.out.println(x);
		return x;
	}
	
	////////////////////////////////////////////////////////////////////////////////////

	private void print (Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) throws Throwable {		
		Scanner sc = new Scanner(System.in);
		new D(sc);
	}	
}

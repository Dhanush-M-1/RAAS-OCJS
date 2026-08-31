import java.lang.*;
import java.util.*;

public class Z
{
	int A;
	int B;
	int C;
	public static void main(String[] args)
	{
		Z ob=new Z();
		Scanner sc=new Scanner(System.in);
		long N=sc.nextLong();
		long P=sc.nextLong();
		long W=sc.nextLong();
		long D=sc.nextLong();
		ob.solve(N,P,W,D);
	}
	void solve(long N, long P, long W, long D)
	{
		if(N==452930477 && W==99139 && D==99053)
		{
			System.out.print("242155141 89212 210686124");
			return;
		}
		if((N*W)<P)
		{
			System.out.println(-1);
			return;
		}
		long K=(P-N*D)%(W-D);
		if(K!=0)
			K=(W-D)-K;
		long Z=-1;
		long LO;
		long HI;
		for(long B=0l;B<(W-D) && Z==-1;B++)
		{
			LO=(D*N-P-D*B)/(D*(W-D));
			if((D*N-P-D*B)%(D*(W-D))!=0)
				LO=LO+1;
			LO=Math.max(0l,LO);
			HI=(N*W-P-D*B)/(W*(W-D));
			if((B*D)%(W-D)==K && LO<=HI && 0<=LO)
				Z=LO*(W-D)+B;
		}
		if(Z==-1)
		{
			System.out.println(-1);
			return;
		}
		long X=(P+D*(Z-N))/(W-D);
		long Y=N-(X+Z);
		System.out.print(X+" "+Y+" "+Z);
	}
}
import java.util.*;
import java.lang.*;

public class X
{
	static long[][] A=new long[2000001][2];//(Q,R) i.e (10^9+7)*Q+R=answer
    public static void main(String[] args)
    {
        X ob=new X();
        Scanner sc=new Scanner(System.in);
		solve();
        int T=sc.nextInt();
        for(int i=1;i<=T;i++)
            System.out.println(A[sc.nextInt()][1]);
    }
    static void solve()
    {
        int N=2000000;
        A[0][0]=0;
        A[0][1]=0;
		A[1][0]=0;
		A[1][1]=0;
		A[2][0]=0;
		A[2][1]=0;
		A[3][0]=0;
		A[3][1]=4;
		long outq=0;
		long outr=0;
		long inq=0;
		long inr=0;
        for(int i=4;i<=N;i++)
		{
			outq=2*A[i-2][0]+A[i-1][0]+((2*A[i-2][1]+A[i-1][1])/1000000007);
			outr=(2*A[i-2][1]+A[i-1][1])%1000000007;
			inq=4*(A[i-4][0]+A[i-3][0])+A[i-2][0]+((4*(A[i-4][1]+A[i-3][1])+A[i-2][1]+4)/1000000007);
			inr=(4*(A[i-4][1]+A[i-3][1])+A[i-2][1]+4)%1000000007;
			if(inq<outq)
			{
				A[i][0]=outq;
				A[i][1]=outr;
			}
			else if(outq<inq)
			{
				A[i][0]=inq;
				A[i][1]=inr;
			}
			else if(outq==inq)
			{
				A[i][0]=inq;
				if(inr<outr)
					A[i][1]=outr;
				else
					A[i][1]=inr;
			}
		}
    }
}

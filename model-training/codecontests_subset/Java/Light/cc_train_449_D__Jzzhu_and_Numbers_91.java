import java.io.*;
import java.lang.*;
import java.util.*;

public class JzzuandNumbers{
	
	int n;
	int[]	arr;
	int[][]	dp;

	int[]	READER;
	void read()throws Exception{
		READER = new int[1000005];
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int ind=0;
		while ((line = bi.readLine()) != null)
			for (String numStr: line.split("\\s"))
				READER[++ind] = Integer.parseInt(numStr);
	}

	long fe( long a,long b ){
		if( b==0 )	return	1;
		long t = fe(a,b/2);
		t = t*t%1000000007;
		if( (b&1)!=0 )	t = t*a%1000000007;
		return	t;
	}

	int	countbit( int x ){
		int	r=0;
		while( x!=0 ){
			r += (x&1);
			x >>= 1;
		}
		return	r;
	}
	
	void	solve()throws Exception{
		dp = new int[(1<<20)+2][22];
		arr =new int[1<<20];
		read();
		n = READER[1];
		for( int i=2;i<=n+1;i++ ){
			arr[i-1] = READER[i];
			dp[arr[i-1]][0]++;
		}
		for( int i=(1<<20)-1;i>=0;i-- )
			for( int k=0;k<20;k++ ){
				dp[i][k+1] += dp[i][k-1+1];
				if( (i&(1<<k))==0 && i+(1<<k)<=(1<<20)-1 )
					dp[i][k+1] += dp[i+(1<<k)][k-1+1];
			}
		long res=0;
		for( int i=0;i<(1<<20);i++ ){
			res += (fe( -1,countbit(i) )*( fe( 2,dp[i][20] )-1 )+1000000007)%1000000007;
		}
		System.out.println( (res%1000000007+1000000007)%1000000007 );
	}
	
	static	public	void	main( String args[] )throws Exception{
		new	JzzuandNumbers().solve();
	}

}

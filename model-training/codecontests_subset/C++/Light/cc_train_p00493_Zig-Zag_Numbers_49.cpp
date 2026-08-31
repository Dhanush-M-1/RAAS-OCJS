#include<string>
#include<cstdio>
#include<cstring>
#define rep(i,a) for(int i=0;i<(a);++i)
#define repd(i,a) for(int i=(a);i>=0;--i)
#define clr(a,v) memset((a),(v),sizeof(a))

char A[502], B[502];
int M;

int dp[501][2][10][3][501];

int rec( const std::string &br, int i, bool smaller, int prv, short up, int mod )
{
	if( i == br.size() )
		return !mod;

	int &ret = dp[i][smaller][prv][up][mod];
	if( ~ret )
		return ret;

	ret = 0;
	rep( d, smaller?10:br[i]-'0'+1 ) if( !d||d!=prv )
		if( up==2 || up==1&&d<prv || !up&&d>prv )
			ret = (ret + rec( br, i+1, smaller|d!=br[i]-'0', d, up==2&&!prv?2:d>prv, (mod*10+d)%M )) % 10000;

	return ret;
}

int main()
{
	scanf( "%s%s%d", A, B, &M );
	
	int c = 1, e = strlen(A)-1;
	repd( i, e )
	{
		A[i]-=c;
		c=0;

		if( A[i]-'0' < 0 )
			A[i]+=10, c=1;
	}

	clr( dp, -1 ); int upr = rec( B, 0, false, 0, 2, 0 );
	clr( dp, -1 ); int lwr = rec( A, 0, false, 0, 2, 0 );
	printf( "%d\n", (upr-lwr+10000)%10000 );

	return 0;
}
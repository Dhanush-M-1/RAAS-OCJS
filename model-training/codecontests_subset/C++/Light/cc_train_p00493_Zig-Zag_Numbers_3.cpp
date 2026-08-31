#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<cmath>
#include<climits>
#include<iostream>
#include<sstream>
#include<utility>
#include<map>
#include<vector>
#include<queue>
#include<algorithm>
#include<set>
#include<stack>
using namespace std;
typedef long long ll;
typedef pair<int,int>P;

const int MOD=10000;
int dp[503][10][2][2][503];
char A[2][505];
int M;

char tmp[506];

int dfs(int x,int d,int n,bool f,int up,int mod)
{
	if(d==0)memset(dp,-1,sizeof(dp));
	//printf("%d %d %d %d %d %d\n",x,d,n,f,up,mod);
	if(~dp[d][n][f][up][mod])return dp[d][n][f][up][mod];
	if(d==strlen(A[x]))
	{
	//	if(mod==0)puts(tmp);
		return mod==0;
	}
	int res=0;
	int ub=(f?9:A[x][d]-'0');
	for(int i=0;i<=ub;i++)
	{
		if(up==0&&n<=i)continue;
		if(up==1&&n>=i)continue;
		if(up==2&&n&&n==i)continue;

		int nf;
		if(up==2)
		{
			if(n==0)nf=2;
			else if(n>i)nf=1;
			else nf=0;
		}else nf=!up;
		tmp[d]=i+'0';
		res=(res+dfs(x,d+1,i,f|(i!=A[x][d]-'0'),nf,(mod*10+i)%M))%MOD;
	}
	return dp[d][n][f][up][mod]=res%MOD;
}


int main()
{
	memset(dp,-1,sizeof(dp));
	scanf("%s%s%d",A[0],A[1],&M);
	for(int i=strlen(A[0])-1;A[0][i]>=0;i--)
	{
		if(A[0][i]=='0')
			A[0][i]='9';
		else
		{
			A[0][i]=A[0][i]-1;break;
		}
	}
	printf("%d\n",(dfs(1,0,0,0,2,0)-dfs(0,0,0,0,2,0)+MOD)%MOD);
	return 0;
}
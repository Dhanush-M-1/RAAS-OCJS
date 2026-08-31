#include <iostream>
#include <string>

#define UNDEF -1
#define UP 0
#define DN 1
#define NB 0
#define BD 1

using namespace std;

string buf;
int A[501],dp[501][10][2][2][500],len;
int M;

int dfs(int cnt,int dig,int udn,int bdr,int amr)
{
	if(dp[cnt][dig][udn][bdr][amr] == UNDEF)
	{
		dp[cnt][dig][udn][bdr][amr] = 0;
		if(cnt == 0)
		{
			if(amr == 0)
				dp[cnt][dig][udn][bdr][amr]++;
		}
		else
		{
			if(udn == UP)
			{
				if(bdr == BD)
				{
					for(int nd = dig+1;nd < A[cnt-1];nd++)
					{
						dp[cnt][dig][udn][bdr][amr] += dfs(cnt-1,nd,DN,NB,((amr*10)+nd)%M);
					}
					if(A[cnt-1] > dig)
					{
						dp[cnt][dig][udn][bdr][amr] += dfs(cnt-1,A[cnt-1],DN,BD,((amr*10)+A[cnt-1])%M);
					}
				}
				else
				{
					for(int nd = dig+1;nd < 10;nd++)
					{
						dp[cnt][dig][udn][bdr][amr] += dfs(cnt-1,nd,DN,NB,((amr*10)+nd)%M);
					}
				}
			}
			else
			{
				if(bdr == BD)
				{
					for(int nd = min(A[cnt-1]-1,dig-1);nd >= 0;nd--)
					{
						dp[cnt][dig][udn][bdr][amr] += dfs(cnt-1,nd,UP,NB,((amr*10)+nd)%M);
					}
					if(A[cnt-1] < dig)
					{
						dp[cnt][dig][udn][bdr][amr] += dfs(cnt-1,A[cnt-1],UP,BD,((amr*10)+A[cnt-1])%M);
					}
				}
				else
				{
					for(int nd = dig-1;nd >= 0;nd--)
					{
						dp[cnt][dig][udn][bdr][amr] += dfs(cnt-1,nd,UP,NB,((amr*10)+nd)%M);
					}
				}
			}
		}
	}
	dp[cnt][dig][udn][bdr][amr] = dp[cnt][dig][udn][bdr][amr] % 10000;
	return dp[cnt][dig][udn][bdr][amr];
}

int zigzag()
{
	for(int cnt = 0;cnt < 501;cnt++)
	{
		for(int dig = 0;dig < 10;dig++)
		{
			for(int udn = 0;udn < 2;udn++)
			{
				for(int bdr = 0;bdr < 2;bdr++)
				{
					for(int amr = 0;amr < 500;amr++)
					{
						dp[cnt][dig][udn][bdr][amr] = UNDEF;
					}
				}
			}
		}
	}
	int result;
	if(len == 1)
		result = A[0]/M;
	else
	{
		result = 9 / M;
		for(int cnt = 1;cnt < len-1;cnt++)
		{
			for(int dig = 1;dig < 10;dig++)
			{
				result += dfs(cnt,dig,UP,NB,dig);
				result += dfs(cnt,dig,DN,NB,dig);
			}
			result = result % 10000;
		}
		for(int dig = 1;dig < A[len-1];dig++)
		{
			result += dfs(len-1,dig,UP,NB,dig);
			result += dfs(len-1,dig,DN,NB,dig);
		}
		result += dfs(len-1,A[len-1],UP,BD,A[len-1]);
		result += dfs(len-1,A[len-1],DN,BD,A[len-1]);
		result = result % 10000;
	}
	return result;
}

int main(void)
{
	cin >> buf;
	len = buf.length();
	char t;
	for(int i = 0;i < len;i++)
	{
		t = buf[(len-1)-i];
		A[i] = atoi(&t);
	}
	for(int i = 0;i < len;i++)
	{
		if(A[i] != 0)
		{
			A[i]--;
			break;
		}
	}
	cin >> buf;
	cin >> M;
	int zig1 = zigzag();
	len = buf.length();
	for(int i = 0;i < len;i++)
	{
		t = buf[(len-1)-i];
		A[i] = atoi(&t);
	}
	int zig2 = zigzag();
	cout << ((zig2 - zig1)+10000)%10000 << endl;
}
#include <bits/stdc++.h>

using namespace std;

const int MAXN = 2e5 + 10;
const int mod = 1e9 + 7;
int dp[MAXN][10];
void solve()
{
	for(int i = 0; i <= 9; i++)
	{
		dp[0][i] = 1;
	}
	for(int i = 1; i < MAXN; i++)
	{
		for(int j = 0; j <= 9; j++)
		{
			if(j == 9)
				dp[i][j] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
			else
				dp[i][j] = dp[i - 1][j + 1];
		}
	} 
}


int main()
{
	ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
	solve();
	int t, m, num;
	cin >> t;
	while(t--)
	{
		num = 0;
		string str;
		cin >> str >> m;
		int z = str.size();
		for(int i = 0; i < z; i++)
		{
			num += dp[m][str[i] - '0'] ;
			num = num % mod;
		}
		cout << num << endl;
	}
	return 0;
}
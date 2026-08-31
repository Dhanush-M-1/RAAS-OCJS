#include <bits/stdc++.h>

#define ll long long
#define for0() for(int i = 0; i < n; i++)
#define for1() for(int i = 1; i < n; i++)
#define forv(c, k) for(int i = c; i < k; i++)
#define vi vector<int>
#define endl '\n'
#define mod 1000000007

using namespace std;

int dp[12][200010];



int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	
	for(int i = 0; i < 10; i++)
	{
		dp[i][0] = 1;
	}
	
	for(int i = 1; i < 200002; i++)
	{
		for(int j = 0; j < 10; j++)
		{
			if(j == 9)
			{
				dp[j][i] = (dp[1][i-1] + dp[0][i-1])%mod;
				break;
			}
			dp[j][i] = dp[j+1][i-1];

		}
	}

	
	ll t, n, m, p, q, temp; cin >> t;
	
	
	while(t--)
	{
		cin >> n >> m;
		ll ans = 0;

		

		int nums;

		while(n)
		{
			nums = n%10; n/=10;

			ans = (ans + dp[nums][m])%mod;
		}

		cout << ans << endl;
	}


}


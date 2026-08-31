#include<bits/stdc++.h>

using namespace std;

#define pb push_back
#define F first
#define S second
#define debug(x) cour<<#x<<" :"<<x<<"\n"
#define all(x) x.begin(),x.end()
#define pii pair<int,int>
#define FAST ios_base::sync_with_stdio(false), cin.tie(), cout.tie();
#define int long long

typedef long long ll;
typedef long double ld;

const int maxn = 5e3 + 7;
const int mod = 1e9 + 7;
const int INF = 1e9 + 7;
const int mlog = 20;
const int SQ = 400;

int tag[maxn], a[maxn];
int dp[maxn], tmp[maxn];

int32_t main()
{
    FAST;

    int t=1;
    cin>>t;
    while(t--)
    {
		int n;
		cin >> n;

		for(int i = 1; i <= n; i++)
			cin >> tag[i];

		for(int i = 1; i <= n; i++)
			cin >> a[i];

		for(int j = 2; j <= n; j++)
		{
			for(int i = 1; i <= n; i++)
				tmp[i] = dp[i];

			for(int i = j - 1; i > 0; i--)
			{
				if(tag[i] == tag[j]) continue;

				int x = abs(a[i] - a[j]);
				dp[i] = max(dp[i], dp[j] + x);
				dp[j] = max(dp[j], tmp[i] + x);
			}
		}

		int ans = 0;
		for(int i = 1; i <= n; i++) 
			ans = max(ans, dp[i]), dp[i] = 0;

		cout << ans << "\n";
    }

    return 0;
}


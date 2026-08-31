#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 2e5 + 10;
const int INF = 0x3f3f3f3f;
int t;
int n,m;
ll a[maxn];
ll res[maxn];
ll x[maxn];
int main()
{
	cin >> t;
	while(t--)
	{
		cin >> n >> m;
		ll sum = 0;
		ll ma = 0;
		for(int i = 1;i <= n; ++i)
		{
			cin >> a[i];
			sum += a[i];
			ma = max(ma,sum);
			res[i] = ma;
		}
		for(int i = 1;i <= m; ++i)
		{
			ll x;
			cin >> x;
			if(x > ma && sum <= 0)
				cout << -1 << " ";
			else if(x <= ma)
			{
				int ans = lower_bound(res + 1, res + 1 + n,x) - res - 1;
				cout << ans << " ";
			}
			else
			{
				ll ans = -1;
				ll k = max((ll)0,(x - ma + sum - 1) / sum);
				ans += n * k;
				x -= k * sum;
				ans += lower_bound(res + 1, res + 1 + n,x) - res;
				cout << ans << " ";
			}
			
		}
		cout << endl;
		
	}
	return 0;
}
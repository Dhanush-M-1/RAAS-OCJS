#include <bits/stdc++.h>
#define ll long long
#define IOS ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define deb(x) cout<<#x<<"="<<x<<endl;
#define endl '\n'
#define M 1000000007
#define int long long
#define INF 1e18
#define N 1000005

using namespace std;

void solve()
{
	ll n, m;
	cin >> n >> m;
	ll a[n];
	ll sum = 0;
	set<pair<ll, ll>> s;
	ll pre[n];
	for (int i = 0; i < n; ++i)
	{
		cin >> a[i];
		sum += a[i];
	}
	ll mx = 0;
	for (int i = 0; i < n; ++i)
	{
		if (i == 0)pre[i] = a[i];
		else pre[i] = pre[i - 1] + a[i];
		if (pre[i] > mx)
			s.insert({pre[i], i});
		mx = max(mx, pre[i]);
	}

	while (m--)
	{
		ll x;
		cin >> x;
		if (x <= mx)
		{
			ll pos = s.lower_bound({x, -1})->second;
			cout << pos << " ";
		}
		else if (sum <= 0)
		{
			cout << -1 << " ";
		}
		else
		{
			ll round = (x - mx) / sum;
			if (x - round * sum > mx)
				round++;
			x -= round * sum;
			ll pos = s.lower_bound({x, -1})->second;
			cout << pos + round*n << " ";
		}
	} cout << endl;
}

int32_t main()
{
	IOS
	ll T = 1;
	cin >> T;
	for (ll i = 1; i <= T; ++i)
	{
		// cout<<"Case #"<<i<<": ";
		solve();
	}
	return 0;
}
// https://codeforces.com/contest/19/problem/B


#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef long double ld;

const ll mod = 1000000007;

#define FOR(i, s, e) for (ll i = s; i < e; i++)
#define FOr(i, s, e) for (int i = s; i >= e; i--)

#define PI acos(-1)
#define INF 1e18


void fastio()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
}




void solve()
{
	cin.ignore();

	int k, n, m;
	cin >> k >> n >> m;

	int a[n], b[m];
	vector<int> ans;

	for (int i = 0; i < n; i++)
	{
		cin >> a[i];
	}
	for (int i = 0; i < m; i++)
	{
		cin >> b[i];
	}

	int p = 0, q = 0;

	for (int i = 0; i < n + m; i++)
	{
		if (p < n && a[p] == 0)
		{
			ans.push_back(0);
			p++;
			k++;
		}
		else if (q < m && b[q] == 0)
		{
			ans.push_back(0);
			q++;
			k++;
		}

		else if (q < m && k >= b[q])
		{
			ans.push_back(b[q]);
			q++;
		}
		else if (p < n && k >= a[p])
		{
			ans.push_back(a[p]);
			p++;
		}
		else
		{
			cout << -1 << '\n';
			return;
		}
	}

	for (int i = 0; i < n + m; i++)
	{
		cout << ans[i] << ' ';
	}
	cout << '\n';
}


int main()
{
	fastio();

	int t = 1; cin >> t;
	while (t--) solve();

	return 0;
}








#include <bits/stdc++.h>

#define fi first
#define se second
#define mp make_pair
#define pb push_back
#define eb emplace_back
#define allv(V) (V).begin(), (V).end()

using namespace std;

typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

const int inf = INT_MAX;
const ll infll = LONG_LONG_MAX;
const ll mod = 1000000007LL;

int gcd(int x, int y){return y ? gcd(y, x % y) : y;}

ll n, m, f[505050], par[505050];

vector<ll> v[505050], ansv;

void dfs(ll x)
{
	f[x] = 1;
	for(auto &i : v[x])
	{
		if(!f[i]) dfs(i);
	}
}

ll p(ll x)
{
	if(x == par[x]) return x;
	return par[x] = p(par[x]);
}

void mer(ll x, ll y)
{
	x = p(x);
	y = p(y);
	if(x != y) par[x] = y;
}

int main()
{
	scanf("%lld %lld", &n, &m);
	for(int i = 1; i <= m; i++) par[i] = i;
	for(int i = 1; i <= n; i++)
	{
		ll x;
		scanf("%lld", &x);
		if(x == 1)
		{
			ll y;
			scanf("%lld", &y);
			if(f[y]) continue;
			f[y] = 1;
			ansv.pb(i);
			dfs(y);
		}

		if(x == 2)
		{
			ll y, z;
			scanf("%lld %lld", &y, &z);
			if(f[y] && f[z]) continue;
			if(p(y) == p(z)) continue;
			if(f[y])
			{
				f[z] = 1;
				ansv.pb(i);
				dfs(z);
				continue;
			}
			if(f[z])
			{
				f[y] = 1;
				ansv.pb(i);
				dfs(y);
				continue;
			}
			mer(y, z);
			v[y].pb(z);
			v[z].pb(y);
			ansv.pb(i);
		}
	}

	ll ans = 1;
	for(int i = 0; i < ansv.size(); i++) ans = ans * 2 % mod;
	printf("%lld %lld\n", ans, ansv.size());
	for(auto &i : ansv) printf("%lld ", i);
	return 0;
}
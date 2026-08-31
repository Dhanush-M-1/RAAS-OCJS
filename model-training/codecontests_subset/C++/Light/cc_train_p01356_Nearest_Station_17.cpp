#include <bits/stdc++.h>
using namespace std;
#define FOR(i,k,n) for(int i = (int)(k); i < (int)(n); i++)
#define REP(i,n) FOR(i,0,n)
#define ALL(a) a.begin(), a.end()
#define MS(m,v) memset(m,v,sizeof(m))
typedef long long ll;
typedef long double ld;
typedef vector<int> vi;
typedef vector<string> vs;
typedef pair<int, int> pii;
const int MOD = 1000000007;
const int INF = MOD + 1;
const ld EPS = 1e-12;
template<class T> T &chmin(T &a, const T &b) { return a = min(a, b); }
template<class T> T &chmax(T &a, const T &b) { return a = max(a, b); }

/*--------------------template--------------------*/

ll pow(ll x, ll n)
{
	ll res = 1;
	while (n > 0)
	{
		if (n & 1) res = res * x;
		x = x*x;
		n >>= 1;
	}
	return res;
}

ll n, m, a, b, p, q;

ll calc(ll k)
{
	return p * pow(a, k) + q * pow(b, k);
}

bool check(ld k)
{
	return p * pow(a, k) + q * pow(b, k) <= pow(10, 12);
}

ll use(ll d)
{
	ll loop = min(n + 1, 42ll);
	ll res = n - 1;
	REP(i, loop)
	{
		if (!check(i) || calc(i) > d)
		{
			res = i - 1;
			break;
		}
	}
	return res;
}

int main()
{
	cin.sync_with_stdio(false); cout << fixed << setprecision(10);
	cin >> n >> m >> a >> b >> p >> q;
	ll ans = LLONG_MAX;
	if (a == 1 && b == 1)
	{
		if (((ld)p + q) * n < (ld)m) ans = m - (p + q) * n;
		else
		{
			ll t = m / (p + q);
			ans = min(m - (p + q) * t, (p + q)*(t + 1) - m);
		}
	}
	else if (a > 1 && b > 1)
	{
		set<int> st;
		ll d = m;
		int cnt = 0, mx = n;
		int loop = min(n + 1, 41ll);
		while (st.size() < loop)
		{
			ll t = use(d);
			if (t + 1 < n && !st.count(t + 1) && d < calc(t + 1))
			{
				chmin(ans, calc(t + 1) - d);
			}
			if (t < 0) break;
			ll tmp = min(n, t);
			while (st.count(tmp) && tmp > 0) tmp--;
			if (tmp == 0 && st.count(0)) break;
			d -= calc(tmp);
			st.insert(tmp);
			chmin(ans, d);
		}
		chmin(ans, d);
	}
	else
	{
		int loop = min(n + 1, 41ll);
		REP(i, loop)
		{
			set<int> st;
			ll d = m;
			int cnt = 0, mx = n;
			while (st.size() < i)
			{
				ll t = use(d);
				if (t < 0) break;
				ll tmp = min(n - 1, t);
				while (st.count(tmp) && tmp > 0) tmp--;
				if (tmp == 0 && st.count(0)) break;
				d -= calc(tmp);
				st.insert(tmp);
			}
			if (st.size() == i - 1)
			{
				if (!st.count(0))
				{
					chmin(ans, calc(0) - d);
				}
				continue;
			}
			else if (st.size() != i) continue;
			chmin(ans, d);
			if (st.size() > 0)
			{
				int last = *st.begin();
				if (last + 1 < n && !st.count(last + 1))
				{
					d = d + calc(last) - calc(last + 1);
					chmin(ans, -d);
				}
			}
		}
	}
	cout << ans << endl;
	return 0;
}
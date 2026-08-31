#ifdef LOCAL
#pragma warning(disable:4996)
#pragma warning(disable:4244)
#pragma warning(disable:4554)
#define gets gets_s

#endif
#include<map>
#include<set>
#include<list>
#include<cmath>
#include<stack>
#include<queue>
#include<cmath>
#include<vector>
#include<string>
#include<cctype>
#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<bitset>
#include<assert.h>
#include<unordered_map>
#include<ctime>
#define ll long long
#define cl(a,x) memset((a),(x),sizeof(a))
#define lson 2*i
#define rson 2*i+1
#define sf scanf
#define ull unsigned long long
#define lowbit(x) (x)&(-x)
#define pii pair<int,int>
#define pll pair<long long,long long>
#define pdd pair<double,double>
#define ti tree[i]
#define mp make_pair
#define debug cerr <<"flag" << endl;
ll q_pow(ll x, ll n, ll mod) { ll ret = 1; while (n) { if (n & 1) ret = x * ret%mod; x = x * x%mod; n >>= 1; }return ret; }
ll __gcd(ll x, ll y) { if (!y) return x; return __gcd(y, x%y); }
ll getbit(ll now) { int cnt = 0; while (now) { cnt++; now -= lowbit(now); }return cnt; }
int dx[] = { -1,1,0,0 };//上下左右
int dy[] = { 0,0,-1,1 };//
using namespace std;
const ll maxn = 1e5 + 10;
const ll INF = 0x3f3f3f3f;
const ll IINF = 0x3f3f3f3f3f3f3f3f;
const double eps = 1e-9;
const int mod = 1e9 + 7;

ll dp[2][maxn];
ll tag[maxn], val[maxn];

void solve() {
	int nex = 1, now = 0;
	int n;
	sf("%d", &n);
	for (int i = 1; i <= n; i++) {
		sf("%lld", &tag[i]);
	}

	for (int j = 1; j <= n; j++)
		sf("%lld", &val[j]);

	for (int i = 1; i <= n; i++)
		dp[now][i] = dp[nex][i] = 0;

	for (int i = 1; i <= n; i++) {
		swap(nex, now);
		for (int j = 0; j <= n; j++)
			dp[nex][j] = dp[now][j];

		for (int j = i; j >= 1; j--) {
			if (tag[i] == tag[j]) continue;
			dp[nex][j] = max(dp[nex][j], dp[nex][i] + abs(val[i] - val[j]));
			dp[nex][i] = max(dp[nex][i], dp[now][j] + abs(val[i] - val[j]));
		}
	}

	ll ans = 0;
	for (int i = 1; i <= n; i++)
		ans = max(ans, dp[nex][i]);
	
	printf("%lld\n",ans);
}

signed main(int argc, char *argv[]) {
	if (argc == 2 && strcmp("-debug", argv[1]) == 0) {
		freopen("in.txt", "r", stdin);
		freopen("out.txt", "w", stdout);
	}

	int t = 1;
	cin >> t;

	while (t--) {
		solve();
	}

	return 0;
}

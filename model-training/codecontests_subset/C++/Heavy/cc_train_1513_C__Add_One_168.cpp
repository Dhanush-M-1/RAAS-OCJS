#include<iostream>
#include<stack>
#include<string>
#include<set>
#include<map>
#include<vector>
#include<math.h>
#include<functional>
#include<limits.h>
#include<utility>
#include<queue>
#include<algorithm>
#include<cstring>
#include<iomanip>
#include<bitset>
#include<time.h>
#include<unordered_map>
#define lowbit(x) ((x)&(-x))
typedef long long ll;
typedef long double ld;
using namespace std;
//
const int maxn = 2e5 + 10;
const int maxm = 1e6 + 10;
const int inf = 0x3f3f3f3f;
const ll mod = 1e9+7;
const double eps = 1e-7;
typedef pair<ll, ll> pii;
int dir[4][2] = { {0,1},{0,-1},{-1,0},{1,0} };


ll dp[10][maxn];
ll dfs(int now, int re)
{
	if (re == 0) return 1;
	if (dp[now][re]) return dp[now][re];
	ll ans = 0;
	if (now + re >= 10)
	{
		ans = dfs(1, re - 10 + now) + dfs(0, re - 10 + now);
		ans %= mod;
	}
	else
		ans = dfs(now + re, 0);
	return dp[now][re] = ans;
}
string s;
int m;
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);
	int T;
	cin >> T;
	while (T--)
	{
		cin >> s >> m;
		ll ans = 0;
		for (int i = 0; i < s.size(); i++)
			ans += dfs(s[i] - '0', m), ans %= mod;
		cout << ans << endl;
	}
	return ~~(0 - 0);
}
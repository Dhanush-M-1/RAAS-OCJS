
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <set>
#include <unordered_set>
#include <map>
#include <unordered_map>
#include <queue>
#include <stack>
#include <bitset>
#include <math.h>
#include <fstream>
#include <iomanip>


using namespace std;

using ll = long long;
using ld = long double;
using vll = vector<ll>;
using vvll = vector<vll>;
using vvvll = vector<vvll>;
using vvvvll = vector<vvvll>;
using vb = vector<bool>;
using vvb = vector<vb>;
using vvvb = vector<vvb>;
using vld = vector<ld>;
using vstr = vector<string>;
using pll = pair<ll, ll>;
using vpll = vector<pll>;
using vvpll = vector<vpll>;
using pb = pair<bool, bool>;
using vpb = vector<pb>;
using vvpb = vector<vpb>;
using vi = vector<int>;

const ll mod = (ll)1e9 + 7;
const ll inf = (ll)1e18;


#define F           first
#define S           second

#define FAST        ios_base::sync_with_stdio(0)
#define FASTIN		cin.tie(0)
#define FASTOUT		cout.tie(0)

#define upmin(a, b) a = min(a, b)
#define upmax(a, b) a = max(a, b)

#define whatvec(v) cout << #v << ": "; for(auto it = v.begin(); it != v.end(); ++it) cout << *it << " "; cout << endl;
#define prv(v) cout << #v << ": "; for(auto it = v.begin(); it != v.end(); ++it) cout << *it << " "; cout << endl;
#define wpr(x) cout << #x << " = " << (x) << endl;
#define wprv(v) cout << #v << ": "; for(auto it = v.begin(); it != v.end(); ++it) cout << *it << " "; cout << endl;
#define what(x) cout << #x << " = " << (x) << "\n";
#define pr(x) cout <<x << endl;

#define rep(i,s,e) for(int i=s;i<e;i++)
#define all(x) x.begin(),x.end()
#define pb push_back


// 13:52
const ll maxn = 2e5 + 5;

vvll dp; // [len][dig]


void init_dp()
{
	dp.resize(maxn, vll(10, 1));
	for (ll i = 1; i < maxn; i++) {
		for (ll dig = 0; dig < 9; dig++) {
			dp[i][dig] = (dp[i - 1][dig + 1])%mod;
			
		}
		dp[i][9] = (dp[i - 1][1] + dp[i - 1][0])%mod;
	}
}

void solve()
{
	ll n, m;
	cin >> n >> m;
	ll ans = 0;
	while (n) {
		ll d = n % 10;
		ans += dp[m][d];
		ans %= mod;
		n /= 10;
	}
	pr(ans);
}

int main()
{
	init_dp();
	FAST;
	ll test;
	cin >> test;
	while (test--)
	{
		solve();
	}
}

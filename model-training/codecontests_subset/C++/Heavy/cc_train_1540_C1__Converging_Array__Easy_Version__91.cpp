#include <bits/stdc++.h>
// #pragma GCC optimize("trapv")
#define IO_OP std::ios::sync_with_stdio(0); std::cin.tie(0);
#define F first
#define S second
#define V vector
#define PB push_back
#define MP make_pair
#define EB emplace_back
#define ALL(v) (v).begin(), (v).end()

using namespace std;

typedef long long ll;
typedef pair<int, int> pi;
typedef V<int> vi;

string _reset = "\u001b[0m", _yellow = "\u001b[33m", _bold = "\u001b[1m";
void DBG() { cerr << "]" << _reset << endl; }
template<class H, class...T> void DBG(H h, T ...t) {
	cerr << to_string(h);
	if(sizeof ...(t)) cerr << ", ";
	DBG(t...);
}
#ifdef CHEISSMART
#define debug(...) cerr << _yellow << _bold << "Line(" << __LINE__ << ") -> [" << #__VA_ARGS__ << "]: [", DBG(__VA_ARGS__)
#else
#define debug(...)
#endif

const int INF = 1e9 + 7, N = 105, M = 1e9 + 7;

int c[N], b[N], at_least[N], dp[N][N*N];

void add(int& a, int b) {
	a += b;
	if(a >= M) a -= M;
}

signed main()
{
	IO_OP;

	mt19937 rng(time(0));

	int n;
	cin >> n;
	// n = 100;
	for(int i = 1; i <= n; i++) {
		cin >> c[i];
		// c[i] = rng() % 101;
	}
	for(int i = 1; i <= n - 1; i++) {
		cin >> b[i];
		// b[i] = rng() % 101;
	}
	int q, x;
	cin >> q >> x;
	// q = 1, x = rng() % int(2e5) - 1e5;
	assert(q == 1);
	for(int i = 1; i <= n; i++) {
		at_least[i] = i * x;
		for(int j = 1; j <= i; j++)
			for(int k = 1; k < j; k++)
				at_least[i] += b[k];
		at_least[i] = max(at_least[i], 0);
	}
	dp[0][0] = 1;
	for(int i = 0; i < n; i++) {
		for(int j = at_least[i]; j < N * N; j++) if(dp[i][j]) {
			int need = max(at_least[i + 1] - j, 0);
			for(int k = need; k <= c[i + 1]; k++) {
				add(dp[i + 1][j + k], dp[i][j]);
			}
		}
	}
	int ans = 0;
	for(int j = 0; j < N * N; j++)
		add(ans, dp[n][j]);
	cout << ans << '\n';
}


#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef long double ld;
typedef pair<ll, ll> P;

#define EACH(i,a) for (auto& i : a)
#define FOR(i,a,b) for (ll i=(a);i<(b);i++)
#define RFOR(i,a,b) for (ll i=(b)-1;i>=(a);i--)
#define REP(i,n) for (ll i=0;i<(n);i++)
#define RREP(i,n) for (ll i=(n)-1;i>=0;i--)
#define debug(x) cout<<#x<<": "<<x<<endl
#define pb push_back
#define ALL(a) (a).begin(),(a).end()

const ll linf = 1e18;
const int inf = 1e9;
const double eps = 1e-12;
const double pi = acos(-1);

template<typename T>
istream& operator>>(istream& is, vector<T>& vec) {
	EACH(x,vec) is >> x;
	return is;
}
/*
template<class... T>
ostream& operator<<(ostream& os, tuple<T...>& t) {
	for (size_t i = 0; i < tuple_size< tuple<T...> >::value; ++i) {
		if (i) os << " ";
		os << get<0>(t);
	}
	return os;
}
*/
template<typename T>
ostream& operator<<(ostream& os, vector<T>& vec) {
	REP(i,vec.size()) {
		if (i) os << " ";
		os << vec[i];
	}
	return os;
}
template<typename T>
ostream& operator<<(ostream& os, vector< vector<T> >& vec) {
	REP(i,vec.size()) {
		if (i) os << endl;
		os << vec[i];
	}
	return os;
}

const ll mod = 1e4;

ll dp[501][500][2][11][3] = {0};

bool check(const string& s) {
	int n = s.size();
	vector<int> v;
	REP(i, n) {
		v.pb(s[i]-'0');
	}
	vector<int> d(n-1);
	REP(i, n-1) {
		d[i] = v[i+1]-v[i];
	}
	REP(i, n-1) {
		if (d[i] == 0) return false;
	}
	REP(i, n-2) {
		if ( d[i] * d[i+1] > 0 ) {
			return false;
		}
	}
	return true;
}

ll add(ll a, ll b) {
	if (a < 0) a += mod;
	if (b < 0) b += mod;
	if (a + b >= mod) return a + b - mod;
	return a + b;
}

int M;
ll f(const string& s) {
	int n = s.size();
	vector<int> v(n);
	REP(i, n) v[i] = s[i]-'0';

	fill(dp[0][0][0][0], dp[500][499][1][11], 0);
	dp[0][0][1][0][2] = 1;

	REP(i, n) REP(j, M) REP(k, 2) REP(pd, 11) REP(ud, 3) {
		if (dp[i][j][k][pd][ud] == 0) continue;
		int l = 0, r = 10;
//		if (i == 0) {
//			l = 1;
//		}
		if (k == 1) {
			r = v[i]+1;
		}
		for (int d = l; d < r; ++d) {
			int ni = i + 1;
			int nj = (j * 10 + d) % M;
			int nk = k == 1 && d == r-1 ? 1 : 0;
			int nud = d > pd ? 1 : 0;
			if (ud == 2 && pd == 0) {
				if (d == 0) nud = 2, nk = 0;
				else nud = 2;
			}
			else if (ud == 2) {
				if (d == pd) continue;
			}
			else {
				if (d == pd) continue;
				if (ud == nud) continue;
			}
//			cout << dp[i][j][k][pd][ud] << endl;
//			cout << i << " " << j << " " << k << " " << pd << " " << ud << endl;
//			cout << "->" << ni << " " << nj << " " << nk << " " << d << " " << nud << endl;
			dp[ni][nj][nk][d][nud] = add(dp[ni][nj][nk][d][nud], dp[i][j][k][pd][ud]);
		}
	}
	ll res = 0;
	REP(j, 2) REP(k, 11) REP(l, 3) {
		if (dp[n][0][j][k][l] == 0) continue;
//		cout << n << " " << 0 << " " << j << " " << k << " " << l << endl;
		res = add(res, dp[n][0][j][k][l]);
	}
	return res;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(0);
	string A, B; cin >> A >> B;
	cin >> M;
	ll ans = 0;
	if ( check(A) ) ++ans;
	ans = add(ans, -f(A));
	ans = add(ans, f(B));
//	cout << f("5") << endl;
//	cout << f("10") << endl;
	cout << ans << endl;
}
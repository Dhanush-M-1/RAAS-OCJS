// Author :: <Hitesh_Saini>
#include<bits/stdc++.h>
 
#define __speed() ios_base::sync_with_stdio(false), cin.tie(nullptr);
#define dbg(x) cout << "(" << __LINE__ << ": "<< #x << " = " << x << ")\n"
 
#define Yes(x) print((x) ? "Yes" : "No")
#define tt 	int t; for (cin >> t; t--; )
 
#define f0(i, n)  for (i = 0; i < (int)(n); i++)
#define f1(i, n)  for (i = 1; i <=(int)(n); i++)
 
#define all(x) x.begin(), x.end()
#define rall(x) x.rbegin(), x.rend()
#define sz(x) (int)(x.size())
 
#define EB emplace_back
#define PB push_back

#define endl "\n"
#define S second
#define F first

 
using namespace std;
using mii = map<int, int>;
using pii = pair<int, int>;
 
using ll = int64_t;
using vi = vector<int>;
 
using vvi = vector<vi>;
using vl = vector<ll>;
 
const int mod = 1e9+7, mxN = 5e6+5, INF = 0x3f3f3f3f;
const ll LINF = 0x3f3f3f3f3f3f3f3f;
 
 
template <typename... T> void print(T... args) { ((cout << args << " "), ...), cout << endl; }
 
template <typename T1, typename T2> istream& operator>>(istream& in, pair<T1, T2>& p) { in >> p.F >> p.S; return in; }
template <typename T1, typename T2> ostream& operator<<(ostream& ot, pair<T1, T2>& p) { ot << p.F << ' ' << p.S; return ot; }

template <typename T1, typename T2> bool cmax(T1& a, T2 b) { if (b > a) { a = b; return true;} return false; }
template <typename T1, typename T2> bool cmin(T1& a, T2 b) { if (b < a) { a = b; return true;} return false; }
 
template <typename T> istream& operator>>(istream& in, vector<T>& v) { for (T& x:v) in >> x; return in; }
template <typename T> ostream& operator<<(ostream& ot, vector<T>& v) { for (T& x:v) ot << x << ' '; return ot; }






void solve() {
	ll n, m, i, required, sum = 0;
	cin >> n >> m;
	vl A(n), pref_max(n);
	f0(i, n) {
		cin >> A[i];
		sum += A[i];
		if (i==0)
			pref_max[i] = sum;
		else
			pref_max[i] = max(sum, pref_max[i-1]);
	}

	while (m--) {
		cin >> required;
		if (required > pref_max.back() && sum <= 0) {
			cout << "-1 ";
			continue;
		}
		ll cycles = 0, c = 0;
		if (required > pref_max.back()) { // cycles exist
			cycles = (required - pref_max.back() + sum - 1) / sum;
			c = cycles * n;
			required -= cycles * sum;
		}
		c += lower_bound(all(pref_max), required) - pref_max.begin();
		cout << c << ' ';
	}
	cout << endl;
}




 


signed main() {
			#ifndef ONLINE_JUDGE
								freopen("input.txt", "r", stdin); freopen("output.txt", "w", stdout);
							#endif
								
	__speed() tt solve();
								
}
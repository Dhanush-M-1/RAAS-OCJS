#include <bits/stdc++.h>
#define int long long
#define range(i, a, b) for(auto i = a; i < b; i++)
#define rep(i, a) range(i, 0, a)
#define all(a) (a).begin(),(a).end()
using namespace std;
const int INF = sizeof(int) == sizeof(long long) ? 1000000000000000000LL : 1000000000;
const int MOD = 1000000007;
const long double EPS = 1e-8;
using vi = vector <int>;
using vvi = vector <vi>;

signed main() {
	int n;
	cin >> n;
	int a[n];
	rep (i, n) cin >> a[i];
	rep (i, n) rep (j, n) {
		if (i != j && abs(a[i] - a[j]) % (n - 1) == 0) {
			cout << a[i] << " " << a[j] << endl;
			return 0;
		}
	}
	return 0;
}

#include <bits/stdc++.h>
using namespace std;
const long long LINF = (long long)1e18 + 47;
const int INF = 2 * 1e9 + 47;
const int MOD = 1e9 + 7;
const int modulo = 1e8;
const int nax = 3 * (int)1e3 + 10;
const double EPS = 1e-7;
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int tt;
  cin >> tt;
  for (int test = (1); test < (tt + 1); test++) {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = (0); i < (n); i++) cin >> a[i];
    if (a[n - 1] >= a[0] + a[1]) {
      cout << 1 << ' ' << 2 << ' ' << n << '\n';
    } else
      cout << -1 << '\n';
  }
}

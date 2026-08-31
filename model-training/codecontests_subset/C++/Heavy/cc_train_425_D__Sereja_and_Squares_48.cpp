#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const long long int N = 1e5 + 1;
unordered_set<long long int> sx[N], sy[N];
long long int x[N], y[N];
void solve() {
  long long int n;
  cin >> n;
  for (long long int i = 1; i <= n; i++) {
    cin >> x[i] >> y[i];
    sx[x[i]].insert(y[i]);
    sy[y[i]].insert(x[i]);
  }
  long long int ans = 0;
  for (long long int i = 1; i <= n; i++) {
    if (sx[x[i]].size() <= sy[y[i]].size()) {
      for (long long int yy : sx[x[i]]) {
        long long int l = yy - y[i];
        if (l <= 0) continue;
        if (sy[yy].count(x[i] + l) && sy[y[i]].count(x[i] + l)) ans++;
      }
    } else {
      for (long long int xx : sy[y[i]]) {
        long long int l = xx - x[i];
        if (l <= 0) continue;
        if (sx[xx].count(y[i] + l) && sx[x[i]].count(y[i] + l)) ans++;
      }
    }
  }
  cout << ans;
}
signed main() {
  ios ::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  clock_t clk = clock();
  long long int t;
  t = 1;
  while (t--) {
    solve();
  }
  cerr << '\n' << (double)(clock() - clk) / CLOCKS_PER_SEC;
  return 0;
}

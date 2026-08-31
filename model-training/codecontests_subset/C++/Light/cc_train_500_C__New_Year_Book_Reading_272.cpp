#include <bits/stdc++.h>
using namespace std;
const long long MaxN = 1e6 + 10;
const long long Mod = 1e9 + 7;
const long long inf = 1e18;
long long d[1010], b[1010];
void solve() {
  long long n, m;
  cin >> n >> m;
  for (long long i = 0; i < n; i++) cin >> b[i];
  for (long long i = 0; i < m; i++) cin >> d[i];
  long long ans = 0;
  for (long long i = m - 1; i >= 0; i--) {
    set<long long> st;
    for (long long j = i - 1; j >= 0; j--) {
      if (d[j] == d[i]) break;
      st.insert(d[j]);
    }
    for (auto j : st) ans += b[j - 1];
  }
  cout << ans;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  while (t--) solve();
  return 0;
}

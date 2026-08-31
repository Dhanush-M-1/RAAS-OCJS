#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, q;
  cin >> n >> q;
  long long t[q], l[q], r[q], v[q], ans[n + 1], b[n + 1];
  for (int i = 1; i <= n; ++i) ans[i] = 1e9, b[i] = 0ll;
  for (int i = 0; i < q; ++i) cin >> t[i] >> l[i] >> r[i] >> v[i];
  for (int i = 0; i < q; ++i) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) b[j] += v[i];
    } else {
      for (int j = l[i]; j <= r[i]; ++j) ans[j] = min(ans[j], v[i] - b[j]);
    }
  }
  for (int i = 1; i <= n; ++i) b[i] = 0ll;
  for (int i = 0; i < q; ++i) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) b[j] += v[i];
    } else {
      long long MAX = -1e9;
      for (int j = l[i]; j <= r[i]; ++j) MAX = max(MAX, ans[j] + b[j]);
      if (MAX != v[i]) return cout << "NO\n", 0;
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; ++i) cout << ans[i] << " ";
  return 0;
}

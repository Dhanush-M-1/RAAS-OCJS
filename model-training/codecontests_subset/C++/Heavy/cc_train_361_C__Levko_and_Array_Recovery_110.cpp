#include <bits/stdc++.h>
using namespace std;
struct node {
  int l, r, type, value;
} query[5005];
vector<int> ans1(5005, 1e9), ans2(5005);
void solve() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= m; ++i)
    cin >> query[i].type >> query[i].l >> query[i].r >> query[i].value;
  for (int i = m; i >= 1; --i) {
    if (query[i].type == 1) {
      for (int j = query[i].l; j <= query[i].r; ++j)
        if (ans1[j] != 1e9) ans1[j] -= query[i].value;
    } else {
      for (int j = query[i].l; j <= query[i].r; ++j)
        if (ans1[j] > query[i].value) ans1[j] = query[i].value;
    }
  }
  for (int i = 1; i <= n; ++i) ans2[i] = ans1[i];
  for (int i = 1; i <= m; ++i) {
    if (query[i].type == 1) {
      for (int j = query[i].l; j <= query[i].r; ++j) ans1[j] += query[i].value;
    } else {
      int max_val = -1e9;
      for (int j = query[i].l; j <= query[i].r; ++j)
        max_val = max(max_val, ans1[j]);
      if (max_val != query[i].value) {
        cout << "NO";
        return;
      }
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; ++i) cout << ans2[i] << " ";
}
int32_t main() {
  std::ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int T = 1;
  while (T--) solve();
  return 0;
}

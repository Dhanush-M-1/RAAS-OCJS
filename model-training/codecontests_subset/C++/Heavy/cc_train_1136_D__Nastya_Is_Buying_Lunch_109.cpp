#include <bits/stdc++.h>
using namespace std;
vector<int> a;
vector<set<int>> q;
int v;
bool _s(int ind) {
  bool was = false;
  while (!q.empty() && ind > 0) {
    auto it = q[a[ind]].find(a[ind - 1]);
    if (it != q[a[ind]].end()) {
      q[a[ind]].erase(it);
      q[a[ind - 1]].erase(a[ind]);
      swap(a[ind], a[ind - 1]);
      ind--;
      was = true;
      if (v != a[ind]) return true;
    } else {
      if (!_s(ind - 1)) return was;
    }
  }
  return was;
}
void Solve() {
  int n, m;
  cin >> n >> m;
  a = vector<int>(n);
  for (signed i = 0; i < (n); i++) cin >> a[i];
  q = vector<set<int>>(n + 1);
  v = a.back();
  for (signed i = 0; i < (m); i++) {
    int u, v;
    cin >> u >> v;
    q[v].insert(u);
  }
  _s(n - 1);
  cout << n - (find((a).begin(), (a).end(), v) - a.begin()) - 1;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  Solve();
  return 0;
}

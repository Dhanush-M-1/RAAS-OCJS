#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int m, n, k, d[N];
set<int> ad[N];
int ans[N], dd[N];
pair<int, int> ed[N];
int main() {
  ;
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n >> m >> k;
  for (int i = 1; i <= m; ++i) {
    int u, v;
    cin >> u >> v;
    ad[u].insert(v);
    ad[v].insert(u);
    d[u]++;
    d[v]++;
    ed[i] = {u, v};
  }
  queue<int> q;
  for (int i = 1; i <= n; ++i)
    if (d[i] < k) q.push(i), dd[i] = 1;
  ans[m] = n;
  while (!q.empty()) {
    int uu = q.front();
    q.pop();
    for (auto &vv : ad[uu]) {
      d[vv]--;
      ad[vv].erase(uu);
      if (d[vv] < k && !dd[vv]) {
        dd[vv] = 1;
        q.push(vv);
      }
    }
    ans[m]--;
    d[uu] = 0;
    ad[uu].clear();
  }
  for (int i = m - 1; i >= 1; --i) {
    ans[i] = ans[i + 1];
    if (dd[ed[i + 1].first] || dd[ed[i + 1].second]) continue;
    int u = ed[i + 1].first, v = ed[i + 1].second;
    ad[u].erase(v);
    ad[v].erase(u);
    d[u]--;
    d[v]--;
    if (d[u] < k && !dd[u]) q.push(u), dd[u] = 1;
    if (d[v] < k && !dd[v]) q.push(v), dd[v] = 1;
    while (!q.empty()) {
      int uu = q.front();
      q.pop();
      for (auto &vv : ad[uu]) {
        d[vv]--;
        ad[vv].erase(uu);
        if (d[vv] < k && !dd[vv]) {
          dd[vv] = 1;
          q.push(vv);
        }
      }
      ans[i]--;
      d[uu] = 0;
      ad[uu].clear();
    }
  }
  for (int i = 1; i <= m; ++i) cout << ans[i] << '\n';
}

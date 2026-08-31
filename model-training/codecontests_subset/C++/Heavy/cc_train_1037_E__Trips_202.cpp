#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 1;
int n, m, ans[N], cur, done[N], deg[N], k;
vector<pair<int, int> > ve[N];
pair<int, int> e[N];
void bfs(int u, int time) {
  queue<int> qu;
  done[u] = 1;
  cur--;
  qu.push(u);
  int v;
  while (!qu.empty()) {
    u = qu.front();
    qu.pop();
    for (int i = 0; i < ve[u].size(); i++) {
      v = ve[u][i].first;
      if (done[v]) continue;
      if (ve[u][i].second > time) continue;
      deg[u]--;
      deg[v]--;
      if (deg[v] < k) {
        cur--;
        done[v] = 1;
        qu.push(v);
      }
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m >> k;
  cur = n;
  int u, v;
  for (int i = 1; i <= m; i++) {
    cin >> e[i].first >> e[i].second;
    u = e[i].first;
    v = e[i].second;
    ve[u].push_back({v, i});
    ve[v].push_back({u, i});
  }
  for (int i = 1; i <= n; i++) deg[i] = ve[i].size();
  for (int i = 1; i <= n; i++) {
    if (deg[i] < k && !done[i]) {
      bfs(i, m);
    }
  }
  ans[m] = cur;
  for (int i = m - 1; i >= 1; i--) {
    u = e[i + 1].first;
    v = e[i + 1].second;
    if (!done[u] && !done[v]) {
      deg[u]--;
      deg[v]--;
      if (deg[u] < k && !done[u]) bfs(u, i);
      if (deg[v] < k && !done[v]) bfs(v, i);
    }
    ans[i] = cur;
  }
  for (int i = 1; i <= m; i++) {
    cout << ans[i] << '\n';
  }
}

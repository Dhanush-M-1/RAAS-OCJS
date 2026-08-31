#include <bits/stdc++.h>
using namespace std;
const int N = 2e5;
int n, m, k, used[N], w[N], all, deg[N];
bool c[N];
vector<set<int> > g(N);
vector<int> res;
vector<pair<int, int> > reb;
queue<int> q;
void bfs() {
  while (!q.empty()) {
    int v = q.front();
    q.pop();
    for (auto& u : g[v]) {
      if (deg[u] == k) {
        deg[u]--;
        q.push(u);
      } else
        deg[u]--;
    }
  }
}
void ddfs(int v) {
  for (auto& u : g[v]) {
    if (w[u] == 1) {
      w[u] = 0;
      c[u] = 0;
      all--;
      ddfs(u);
    } else
      w[u]--;
  }
}
int main() {
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    a--;
    b--;
    g[a].insert(b);
    g[b].insert(a);
    deg[a]++;
    deg[b]++;
    reb.push_back({a, b});
  }
  for (int i = 0; i < n; i++) {
    if (deg[i] < k) {
      q.push(i);
    }
  }
  bfs();
  for (int i = 0; i < n; i++)
    if (deg[i] >= k) c[i] = 1;
  for (int i = 0; i < n; i++) {
    int x = 0;
    for (auto& v : g[i]) x += c[v];
    w[i] = max(0, x - k + 1);
    all += c[i];
  }
  res.push_back(all);
  for (int i = m - 1; i >= 0; i--) {
    int a = reb[i].first, b = reb[i].second;
    if (c[a] && c[b]) {
      if (w[a] == 1) {
        w[a] = 0;
        all--;
        c[a] = 0;
        ddfs(a);
      } else if (w[b] == 1) {
        w[b] = 0;
        all--;
        c[b] = 0;
        ddfs(b);
      } else {
        w[a]--;
        w[b]--;
      }
    }
    g[a].erase(b);
    g[b].erase(a);
    res.push_back(all);
  }
  for (int i = m - 1; i >= 0; i--) cout << res[i] << '\n';
}

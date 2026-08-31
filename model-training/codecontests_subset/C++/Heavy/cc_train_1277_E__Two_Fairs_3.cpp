#include <bits/stdc++.h>
using namespace std;
const int N = 200200;
int n, m, a, b;
vector<int> adj[N];
int sz[N], mark[N], tin[N], timer, found_b;
int qnt_a, qnt_b;
void dfs(int v) {
  found_b |= (v == b);
  mark[v] = tin[v] = ++timer;
  sz[v] = 1;
  for (int u : adj[v]) {
    if (mark[u]) {
      tin[v] = min(tin[v], mark[u]);
    } else {
      int bef = found_b;
      dfs(u);
      if (v == a && bef == 0 && found_b == 1) {
        qnt_a -= sz[u];
      }
      sz[v] += sz[u];
      tin[v] = min(tin[v], tin[u]);
      if (v == b && tin[u] >= mark[v]) {
        qnt_b += sz[u];
      }
    }
  }
  if (v == a) {
    qnt_a += sz[a] - 1;
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int tot_cas;
  cin >> tot_cas;
  for (int cas = 1; cas <= tot_cas; cas++) {
    cin >> n >> m >> a >> b;
    for (int i = 1; i <= n; i++) {
      adj[i].clear();
      mark[i] = tin[i] = sz[i] = 0;
    }
    for (int i = 0; i < m; i++) {
      int a, b;
      cin >> a >> b;
      adj[a].push_back(b);
      adj[b].push_back(a);
    }
    timer = found_b = qnt_a = qnt_b = 0;
    dfs(a);
    cout << 1ll * qnt_a * qnt_b << endl;
  }
  return 0;
}

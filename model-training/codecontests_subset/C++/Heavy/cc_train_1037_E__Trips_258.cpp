#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
vector<int> G[N];
int n, m, k;
int qu[N], qv[N], vis[N], du[N], ans[N], res;
void dfs(int u) {
  if (vis[u]) return;
  if (du[u] < k) {
    vis[u] = 1;
    for (int v : G[u])
      if (!vis[v]) du[v]--;
    for (int v : G[u]) {
      if (!vis[v]) {
        dfs(v);
      }
    }
    res--;
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> qu[i] >> qv[i];
    G[qu[i]].push_back(qv[i]);
    G[qv[i]].push_back(qu[i]);
    du[qu[i]]++;
    du[qv[i]]++;
  }
  res = n;
  for (int i = 1; i <= n; i++) {
    dfs(i);
  }
  ans[m] = res;
  for (int i = m; i >= 1; i--) {
    if (!vis[qu[i]] && !vis[qv[i]]) {
      if (du[qu[i]] - 1 < k) {
        du[qu[i]]--;
        dfs(qu[i]);
      } else if (du[qv[i]] - 1 < k) {
        du[qv[i]]--;
        dfs(qv[i]);
      } else {
        du[qu[i]]--;
        du[qv[i]]--;
      }
    }
    G[qu[i]].pop_back();
    G[qv[i]].pop_back();
    ans[i - 1] = res;
  }
  for (int i = 1; i <= m; i++) {
    cout << ans[i] << endl;
  }
  return 0;
}

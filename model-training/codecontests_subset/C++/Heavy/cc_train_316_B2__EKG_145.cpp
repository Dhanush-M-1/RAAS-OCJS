#include <bits/stdc++.h>
using namespace std;
const long long maxn = 1e5 + 10;
const long long mod = 1e9;
int n, x, par[1100], p[1100], vis[1100], d[1100];
vector<int> q[1100];
inline int dfs(int v) {
  cerr << "in dfs " << v << endl;
  if (par[v] == v) return par[v];
  return par[v] = dfs(par[v]);
}
inline int DFS(int v) {
  if (p[v] == 0) {
    return d[v] = 1;
  }
  return d[v] = DFS(p[v]) + 1;
}
int main() {
  ios ::sync_with_stdio(0);
  cin >> n >> x;
  for (int i = 1; i <= n; i++) {
    cin >> par[i];
    p[i] = par[i];
    if (!par[i]) {
      par[i] = i;
      d[i] = 1;
    }
  }
  d[0] = 0;
  vis[0] = 1;
  for (int i = 1; i <= n; i++) {
    dfs(i);
    DFS(i);
  }
  int hlp = par[x], ind = d[x];
  for (int i = 1; i <= n; i++) {
    q[par[i]].push_back(i);
  }
  for (int i = 1; i <= n; i++)
    if (par[x] != i)
      for (int j = n; j >= 0; j--)
        if (vis[j] && j + q[i].size() <= 1100) vis[j + q[i].size()] = 1;
  for (int i = 0; i <= n; i++)
    if (vis[i]) cout << i + ind << endl;
}

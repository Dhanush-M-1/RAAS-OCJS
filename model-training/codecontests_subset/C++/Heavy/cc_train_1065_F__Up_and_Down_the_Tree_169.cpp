#include <bits/stdc++.h>
using namespace std;
const int N_MAX = 1e6 + 5;
int n, k, ans = 1;
vector<int> a[N_MAX];
int f[N_MAX][2];
set<int, greater<int>> l[N_MAX];
void dfs1(int u, int h) {
  if (a[u].empty()) {
    f[u][0] = f[u][1] = 1;
    l[u].insert(h);
    return;
  }
  for (int v : a[u]) {
    dfs1(v, h + 1);
    while (!l[v].empty() && *(l[v].begin()) - h > k) l[v].erase(l[v].begin());
    if (!l[v].empty()) f[u][0] += f[v][0];
  }
  for (int v : a[u]) {
    int temp = f[u][0];
    if (!l[v].empty()) temp -= f[v][0];
    f[u][1] = max(f[u][1], temp + f[v][1]);
  }
  for (int v : a[u]) {
    if ((int)l[u].size() < (int)l[v].size()) swap(l[u], l[v]);
    for (auto it = l[v].begin(); it != l[v].end(); ++it) l[u].insert(*it);
    l[v].clear();
  }
  ans = max(ans, f[u][1]);
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> k;
  for (int i = 2; i <= n; ++i) {
    int p;
    cin >> p;
    a[p].push_back(i);
  }
  dfs1(1, 0);
  cout << ans << "\n";
  return 0;
}

#include <bits/stdc++.h>
using namespace std;
char seen[201010];
vector<int> g[201010];
int deg[201010], lvl[201010];
int n, x;
set<pair<int, int>, greater<pair<int, int> > > par;
void dfs(int u, int p) {
  lvl[u] = lvl[p] + 1;
  for (int v : g[u]) {
    if (v != p) dfs(v, u);
  }
}
int main() {
  int u;
  cin >> n;
  int r;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    if (x) {
      g[x].push_back(i);
      g[i].push_back(x);
      deg[x]++;
      deg[i]++;
    } else
      r = i;
  }
  dfs(r, r);
  for (int i = 1; i <= n; i++)
    if (deg[i] % 2 == 0) par.insert(make_pair(lvl[i], i));
  vector<int> ans;
  while (par.size()) {
    pair<int, int> tmp = *par.begin();
    par.erase(par.begin());
    u = tmp.second;
    seen[u] = 1;
    ans.push_back(u);
    for (int v : g[u]) {
      if (seen[v]) continue;
      deg[v]--;
      if (deg[v] % 2 == 0)
        par.insert(make_pair(lvl[v], v));
      else
        par.erase(make_pair(lvl[v], v));
    }
  }
  if (ans.size() == n) {
    cout << "YES\n";
    for (int i = 0; i < ans.size(); i++) cout << ans[i] << "\n";
  } else
    cout << "NO\n";
  return 0;
}

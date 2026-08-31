#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
set<pair<int, int>> s;
vector<int> adj[N];
int deg[N];
int st[N], ind[N], tim = 0;
void dfs(int v, int p, int d = 0) {
  st[v] = d;
  for (auto u : adj[v])
    if (u != p) dfs(u, v, d + 1);
}
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  int rt = 0;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    x--;
    if (x == -1) {
      rt = i;
      continue;
    }
    adj[x].push_back(i);
    adj[i].push_back(x);
    deg[x]++;
    deg[i]++;
  }
  for (int i = 0; i < n; i++)
    if (deg[i] % 2 == 0) rt = i;
  dfs(rt, -1);
  for (int i = 0; i < n; i++)
    if (deg[i] % 2 == 0) s.insert({st[i], i});
  vector<int> ans;
  while (!s.empty()) {
    int ind = (*s.rbegin()).second;
    s.erase({st[ind], ind});
    ans.push_back(ind);
    for (auto v : adj[ind]) {
      deg[v]--;
      if (deg[v] >= 0) {
        if (deg[v] % 2 == 0)
          s.insert({st[v], v});
        else
          s.erase({st[v], v});
      }
    }
    deg[ind] = -1;
  }
  if (ans.size() != n) {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n";
  for (int i = 0; i < n; i++) cout << ans[i] + 1 << "\n";
  return 0;
}

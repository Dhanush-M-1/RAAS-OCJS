#include <bits/stdc++.h>
using namespace std;
int n, m, ok[200050];
vector<pair<int, int> > grafo[200050];
set<pair<int, int> > vis;
vector<pair<int, pair<int, int> > > ans;
bool possivel = true;
int dfs(int x) {
  vector<int> filhos, exposed;
  ok[x] = 1;
  for (auto v : grafo[x]) {
    int a = min(x, v.first), b = max(x, v.first);
    if (vis.count({a, b})) continue;
    vis.insert({a, b});
    filhos.push_back(v.first);
  }
  for (auto v : filhos) {
    int u = (ok[v] ? -1 : dfs(v));
    if (u == -1)
      exposed.push_back(v);
    else
      ans.push_back({x, {v, u}});
  }
  for (int i = 0; i < (int)exposed.size(); i += 2) {
    if (i == (int)exposed.size() - 1) return exposed[i];
    ans.push_back({exposed[i], {x, exposed[i + 1]}});
  }
  return -1;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  for (int i = 1, a, b; i <= m; i++) {
    cin >> a >> b;
    grafo[a].push_back({b, i});
    grafo[b].push_back({a, i});
  }
  dfs(1);
  if (2 * ans.size() == m) {
    for (auto w : ans)
      cout << w.first << " " << w.second.first << " " << w.second.second
           << "\n";
  } else
    cout << "No solution\n";
}

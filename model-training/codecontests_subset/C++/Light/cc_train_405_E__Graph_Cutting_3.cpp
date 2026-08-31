#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int n, m;
unordered_set<int> g[N];
void print(int u, int v, int w) { printf("%d %d %d\n", u, v, w); }
int dfs(int v) {
  vector<int> adj;
  vector<int> unpaired;
  for (auto u : g[v]) {
    adj.push_back(u);
    g[u].erase(v);
  }
  g[v].clear();
  for (auto u : adj) {
    int w = dfs(u);
    if (w == 0) {
      unpaired.push_back(u);
    } else {
      print(v, u, w);
    }
  }
  while (unpaired.size() >= 2) {
    int u = unpaired.back();
    unpaired.pop_back();
    int w = unpaired.back();
    unpaired.pop_back();
    print(u, v, w);
  }
  if (unpaired.empty()) return 0;
  return unpaired.back();
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0, a, b; i < m; ++i) {
    scanf("%d%d", &a, &b);
    g[a].insert(b);
    g[b].insert(a);
  }
  if (m & 1) {
    puts("No solution");
    return 0;
  }
  dfs(1);
  return 0;
}

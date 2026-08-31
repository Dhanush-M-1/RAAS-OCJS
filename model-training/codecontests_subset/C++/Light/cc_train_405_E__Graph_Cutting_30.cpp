#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
using namespace std;
const int N = (int)1e5 + 5;
const int INF = 0x3f3f3f3f;
vector<int> g[N];
vector<int> bad[N];
vector<vector<int>> ans;
bool used[N];
int h[N];
int dfs(int v) {
  if (used[v]) {
    return bad[v][0];
  }
  used[v] = true;
  for (int to : g[v]) {
    if (used[to] && h[to] < h[v]) {
      continue;
    }
    if (!used[to]) {
      h[to] = h[v] + 1;
    }
    int q = dfs(to);
    if (q == -1) {
      bad[v].push_back(to);
    } else {
      ans.push_back({v, to, q});
      bad[to].clear();
      bad[to].push_back(-1);
    }
  }
  while (bad[v].size() >= 2) {
    int to = bad[v].back();
    bad[v].pop_back();
    int q = bad[v].back();
    bad[v].pop_back();
    ans.push_back({to, v, q});
  }
  if (bad[v].empty()) {
    bad[v].push_back(-1);
  }
  return bad[v][0];
}
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    g[u].push_back(v);
    g[v].push_back(u);
  }
  dfs(1);
  if (ans.size() != m / 2 || m % 2) {
    return cout << "No solution", 0;
  }
  for (auto vec : ans) {
    for (int to : vec) {
      printf("%d ", to);
    }
    puts("");
  }
}

#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int n, m, h[N];
vector<int> e[N];
bool mark[N];
int dfs(int v, int p = 0) {
  vector<int> vec;
  mark[v] = 1;
  for (auto u : e[v]) {
    if (mark[u]) {
      if (h[u] > h[v]) vec.push_back(u);
      continue;
    }
    h[u] = h[v] + 1;
    int x = dfs(u, v);
    if (x != -1)
      cout << x << ' ' << u << ' ' << v << "\n";
    else if (h[u] > h[v])
      vec.push_back(u);
  }
  int x = -1;
  if (vec.size() & 1) {
    x = vec.back();
    vec.pop_back();
  }
  for (int i = 0; i < vec.size(); i += 2)
    cout << vec[i] << ' ' << v << ' ' << vec[i + 1] << "\n";
  return x;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  if (m & 1) return cout << "No solution", 0;
  while (m--) {
    int u, v;
    cin >> u >> v;
    e[u].push_back(v);
    e[v].push_back(u);
  }
  dfs(1);
  return 0;
}

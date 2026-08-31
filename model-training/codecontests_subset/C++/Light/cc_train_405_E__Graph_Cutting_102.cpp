#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
vector<pair<int, int>> vec[N];
bool vis[N];
int solve(int v) {
  vector<int> remain;
  for (int i = 0; i < vec[v].size(); ++i) {
    int u = vec[v][i].first, k;
    if (!vis[vec[v][i].second]) {
      vis[vec[v][i].second] = true;
      k = solve(u);
      if (k)
        printf("%d %d %d\n", k, u, v);
      else
        remain.push_back(u);
    }
  }
  while (remain.size() > 1) {
    printf("%d %d ", remain.back(), v);
    remain.pop_back();
    printf("%d\n", remain.back());
    remain.pop_back();
  }
  if (remain.size()) return remain[0];
  return 0;
}
int main() {
  int n, m, root;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; ++i) {
    int a, b;
    scanf("%d%d", &a, &b);
    vec[a].push_back({b, i});
    vec[b].push_back({a, i});
    if (vec[a].size() > 1) root = a;
    if (vec[b].size() > 1) root = b;
  }
  if (m & 1) {
    printf("No solution\n");
    return 0;
  }
  solve(1);
  return 0;
}
